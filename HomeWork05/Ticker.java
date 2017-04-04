/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ticker.java
 *  Purpose       :  Exported from Clock.java to provide "tick" method for Ball.java
 *  @author       :  Jason Wong
 *  Date written  :  2017-04-1
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
 *  @version 1.0.0  2017-03-25  Jason Wong Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Ticker {

   private double hour;
   private double mins;
   private double secs;
   private double secsHolder;

   public Ticker() {
      this.secs = 0 ;
      this.mins = 0 ;
      this.hour = 0 ;
      this.secsHolder = 0 ;
   }

   public double tick(){

    secsHolder = secsHolder + 1;
    secs = secsHolder;
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

   public String toString() {
      String s1 = Double.toString(secs);
      String m1 = Double.toString(mins);
      String h1 = Double.toString(hour);
      return h1 + m1 + s1;
   }
  public double exportSeconds(){
    return secsHolder;
  }
}
