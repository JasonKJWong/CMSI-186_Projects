/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
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

public class Clock {

   private double hour;
   private double mins;
   private double secs;
   private double finalAngle;
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double MINIMUM_DEGREE_VALUE = 0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private double secsHolder;
   private double vTimeSlice;
   private static final double TICKER_MAX = 1800;

   public Clock() {
      this.secs = 0 ;
      this.mins = 0 ;
      this.hour = 0 ;
      this.secsHolder = 0 ;
      this.vTimeSlice = 0;
   }

   public double tick(double ticker) {
     if ((ticker > TICKER_MAX || ticker < 0)){
      System.out.println("Invalid time slice, please enter 1800 < x < 0");
    }
    this.secs = ticker + secs;
    secsHolder = ticker + secsHolder;
    if (this.secs>=60){
      this.mins += (this.secs/60);
      this.secs = (this.secs % 60);
    }
    if (this.mins >=60){
      this.hour += (this.mins/60);
      this.mins = (this.mins/60);
    }
  return secsHolder;
}

   public double validateAngleArg( String argValue ) throws NumberFormatException {
     double vAngle = Double.parseDouble(argValue);
     if (vAngle > MAXIMUM_DEGREE_VALUE || vAngle < MINIMUM_DEGREE_VALUE){
       System.out.println("Invalid angle value, please enter 360 < x < 0");
       throw new IllegalArgumentException();
   }
   return vAngle;
 }

   public double validateTimeSliceArg( String argValue ) {
      vTimeSlice = Double.parseDouble(argValue);
     if (vTimeSlice > TICKER_MAX  || vTimeSlice < 0){
     System.out.println("Due to invalid time slice input, slice set to default of 60 seconds.");
      return DEFAULT_TIME_SLICE_IN_SECONDS;
   }
   return vTimeSlice;
 }

   public double getMinuteHandAngle() {
     double minAngle = (secsHolder*0.1)%MAXIMUM_DEGREE_VALUE ;
      return minAngle;
   }
   public double getHourHandAngle() {
     double hourAngle = secsHolder*0.008333;
      return hourAngle;
   }


   public double getHandAngle() {
     double minAngle2 = getMinuteHandAngle();
     double hourAngle2 = getHourHandAngle();
     if (minAngle2 > 180 && minAngle2 > hourAngle2){
       finalAngle = ((MAXIMUM_DEGREE_VALUE-minAngle2) + hourAngle2);
     }
     if (hourAngle2 > 180 && hourAngle2 > minAngle2){
       finalAngle = ((MAXIMUM_DEGREE_VALUE-hourAngle2) + minAngle2);
     }
     if (minAngle2<=180 && minAngle2>hourAngle2){
       finalAngle = minAngle2 - hourAngle2;
     }
     if (hourAngle2 <= 180 && hourAngle2>minAngle2){
       finalAngle = hourAngle2 - minAngle2;
     }
     return finalAngle;
   }

   public String toString() {
      String s1 = Double.toString(secs);
      String m1 = Double.toString(mins);
      String h1 = Double.toString(hour);
      return h1 + m1 + s1;
   }
  public double exportSeconds(){
    return secsHolder;
  }

   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();

      System.out.println("Testing the getHourHandAngle() function for 350");
      clock.tick(350);
      System.out.println(clock.getHourHandAngle());
      System.out.println(clock.toString());
      System.out.println();
      System.out.println("Testing the getMinuteHandAngle() function for 350");
      System.out.println(clock.getMinuteHandAngle());
      System.out.println(clock.toString());
      System.out.println();
      System.out.println("Testing the getHandAngle() function for 350");
      System.out.println(clock.getHandAngle());
      System.out.println(clock.toString());
      System.out.println();

      System.out.println("Testing the getHourHandAngle() function for 115");
      clock.tick(115);
      System.out.println(clock.getHourHandAngle());
      System.out.println(clock.toString());
      System.out.println();
      System.out.println("Testing the getMinuteHandAngle() function for 115");
      System.out.println(clock.getMinuteHandAngle());
      System.out.println(clock.toString());
      System.out.println();
      System.out.println("Testing the getHandAngle() function for 115");
      System.out.println(clock.getHandAngle());
      System.out.println(clock.toString());
      System.out.println();

      System.out.println( "  Testing validateAngleArg().... " );
      System.out.print( "      sending '  50 degrees', generating:" );
      try {System.out.println((50 == clock.validateAngleArg("50"))? " - got 50" : " - no joy");}
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Testing validateAngleArg().... " );
      System.out.print( "      sending '  250 degrees', generating:" );
      try {System.out.println((250 == clock.validateAngleArg("250"))? " - got 250" : " - no joy");}
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Testing validateAngle().... " );
      System.out.print( "      sending '  0 degrees', generating:" );
      try {System.out.println((0 == clock.validateAngleArg("50"))? " - got 0" : " - no joy");}
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }


      System.out.println("Now testing validateTimeSliceArg()");
      System.out.print(" testing time slice value of 40");
      clock.validateTimeSliceArg("40");
      System.out.println("Testing time slice value of 1000");
      clock.validateTimeSliceArg("1000");
   }
}
