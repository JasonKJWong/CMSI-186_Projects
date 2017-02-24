
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Jason Wong
 *  Date          :  2017-02-23
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet{


   private int count;
   private int sides;
   private Die[] ds = null;


   public DiceSet( int count, int sides ) {
     if(count<1){
       throw new IllegalArgumentException();
     }

      this.sides = sides;
      this.count = count;

      ds = new Die[ count ];
      for (int i = 0; i< ds.length -1; i++){
        ds[i] = new Die(sides);
      }
   }


   public int sum() {
     int holder = 0;
     int sum = 0;
     for (int i =0; i< ds.length - 1; i++){
       holder = sum + ds[i].getValue();
       sum = holder;
     }
      return sum;
   }


   public void roll() {
     for (int i = 0; i<ds.length; i++){
       ds[i].roll();
     }
   }


   public int rollIndividual( int dieIndex ) {
      return ds[dieIndex].roll();
   }


   public int getIndividual( int dieIndex ) {
      return ds[dieIndex].getValue();
   }


   public String toString() {
      String outcome = "";
      for (int i = 0; i< ds.length; i++){
        outcome = outcome + "( " + ds[i].getValue() + " )";
      }
      return outcome;
   }

   public static String toString( DiceSet ds ) {
      return ds.toString();
   }

   public boolean isIdentical( DiceSet ds ) {
     if (ds.sum() == this.sum()){
       return true;
     }else{ return false;
     }
   }

   public static void main( String[] args ) {
      DiceSet j = new DiceSet( 4, 5);
      DiceSet j2 = new DiceSet( 4,5);

      j.roll();
      j2.roll();

      System.out.println(j.toString());
      System.out.println(j2.toString());

      System.out.println(j.sum());
      System.out.println(j2.sum());

      System.out.println(j.isIdentical(j2));

   }

}
