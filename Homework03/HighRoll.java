
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Creates user input instructions and command
 *  Author        :  Jason Wong
 *  Date          :  2017-02-23
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
      int saveFeature = 0;
      DiceSet r = new DiceSet(2,5);
      System.out.println( "\n   Welcome to the MainProgLoopDemo!!\n" );
      System.out.println( "     Press the '1' key to roll multiple dice" );
      System.out.println( "     Press the '2' key to roll a die" );
      System.out.println( "     Press the '3' key to calculate your result for the fist set ");
      System.out.println( "     Press the '4' to save the score as a high score");
      System.out.println( "     Press the '5' key to display the high score");
      System.out.println( "     Press the 'q' key to quit the program." );

  
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();

            if( 'q' == inputLine.charAt(0) ) {
               break;
            }
            if( '1' == inputLine.charAt(0)){
              r.roll();
              System.out.println("Dices rolled, results are: " + r.toString());
            }

            if ('2' == inputLine.charAt(0)){
              System.out.println("After rolling the die, result is: " + r.rollIndividual(0));
            }

            if ('3' == inputLine.charAt(0)){
              System.out.println("Score for the first is: " + r.sum());
            }

            if ('4' == inputLine.charAt(0)){
              saveFeature = r.sum();
            }

            if ('5' == inputLine.charAt(0)){
              System.out.println("The saved high score is: " + saveFeature);
            }

            }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
