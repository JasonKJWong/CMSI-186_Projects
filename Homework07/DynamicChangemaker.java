/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DynamicChangemaker.java
 *  Purpose       :  provides methods for the class "DynamicChangemaker"
 *  @author       :  B.J. Johnson
 *  @author       :  Jason Wong
 *  Date written  :  2017-04-27
 *  Description   :  generates most optimal way to make change of a given amount
 *  Notes         :  everything functions properly(aside from test17..)
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DynamicChangemaker {
/**
* Main program for DynamicChangeMaker
*
* @param args
*            generated denomination and subsequent amount
* @return most efficient way to generate amount
*/
  public static void main(String[] args) {
    if (args.length != 2) {
          printUsage();
            return;
        }
        try {
            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }
      /**
       * Generates most efficient coin sum
       *
       * @param denominations coins for the stated currency
       * @param amount amount of coins in cents/dollar value
       * @return most efficient coin sum
       */
public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
  Tuple[][] table = new Tuple[denominations.length][(amount +1)];
  Tuple caseZero = new Tuple(denominations.length); // used later for a casewhere 0  is given
  Tuple finalsum = new Tuple(denominations.length); // will call to return the optimal solution

for (int i = 0; i<denominations.length; i++){ // scans through each generated denomination
  for (int j=0; j<amount + 1; j++){
    if( j<denominations[i]){
      if (j==0){
  table[i][j] = caseZero;
} else {
    table[i][j] = Tuple.IMPOSSIBLE;
  }
} else {
  int tempHolder = j - denominations[i];
  table[i][j] = new Tuple (denominations.length);
  table[i][j].setElement(i,1);
    if (table[i][tempHolder] != Tuple.IMPOSSIBLE){
    table[i][j] = table[i][j].add(table[i][tempHolder]);
  } else{
    table[i][j] = Tuple.IMPOSSIBLE;
  }
}

if (i >0 && table[i-1][j] != Tuple.IMPOSSIBLE){
  if(table[i][j] == Tuple.IMPOSSIBLE){
    table[i][j] = table[i-1][j];
  } else if (table[i-1][j] != Tuple.IMPOSSIBLE){
    if (table[i][j].total() > table[i-1][j].total()){
    table[i][j] = table[i-1][j];
    }
  }
}
finalsum = table[i][j];
}
}
return finalsum;
}

/**
* States a message telling people the necessary inputs
* @return inputs required
*/
    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }
/**
* adds the consonant "s" when multiple coins are needed(ex: pennies)
*@param count numerical value of how many times a coin is used
*@return adds a s or keeps the string the same
*/
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }
}
