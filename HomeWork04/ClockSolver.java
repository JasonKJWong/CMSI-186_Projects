/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Jason Wong
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
  *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {

   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private final double EPSILON_VALUE              = 0.25;
   private double angleTest;

   public ClockSolver() {
      super();
   }

   public void handleInitialArguments( String args[] ) {
      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( args.length < 1 || args.length > 2){
         System.out.println( "   Sorry you must enter valid arguments\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." ); System.exit( 1 );
      }
      Clock clock = new Clock();
      if (args.length == 2){

        clock.validateAngleArg(args[0]);
        clock.validateTimeSliceArg(args[1]);
      }
      if (args.length ==1){
        clock.validateAngleArg(args[0]);
        clock.validateAngleArg(args[1]);
      }
      }

   public static void main( String args[] ) {
      double ticker2;
      ClockSolver cse = new ClockSolver();
      Clock clock    = new Clock();
      cse.handleInitialArguments( args );
      cse.angleTest = Double.parseDouble(args[0]);

      if(args.length ==1){
          while(clock.exportSeconds() <= 43200){
            clock.tick(60);
            clock.getHourHandAngle();
            clock.getMinuteHandAngle();
            if (Math.round(clock.getHandAngle() - cse.angleTest)<= cse.EPSILON_VALUE){
            System.out.println(clock.toString());
          }
        }
      }
      if(args.length == 2){
        ticker2 = Double.parseDouble(args[1]);
        while(clock.exportSeconds() <= 43200){
          clock.tick(ticker2);
          clock.getHourHandAngle();
          clock.getMinuteHandAngle();
          if (Math.round(clock.getHandAngle() - cse.angleTest) <= cse.EPSILON_VALUE){
          System.out.println(clock.toString());
        }
      }
    }
  }
}
