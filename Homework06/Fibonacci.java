/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Fibonacci.java
 *  Purpose       :  Creates method fibonacci
 *  @author       :  Jason Wong
 *  Date written  :  2017-04-11
 *  Description   :  Methods for GinormousInt and doing mathematical calculations with great numbers
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  N/A
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-11  Jason Wong Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Fibonacci {
public static GinormousInt fibonacci (int inputValue3) {
      if (inputValue3 == 2 || inputValue3 == 1) {
        return new GinormousInt("1");
      } else {
    GinormousInt fint1 = new GinormousInt("0");
    GinormousInt fint2 = new GinormousInt("1");
         for (int i = 2; i < inputValue3; i++) {
            GinormousInt fintsum = fint1.add(fint2);
            System.out.println(fintsum);
            fint1 = fint2;
            fint2 = fintsum;
         }
         return fint1.add(fint2);
      }
    }
public static void main(String[] args) {
       System.out.println(fibonacci(Integer.parseInt(args[0])));
}
}
