/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Creates ball class for soccer simulation
 *  @author       :  Jason Wong
 *  Date written  :  2017-3-17
 *  Description   :  This class provides methods for constructing a ball in the larger soccer simulation.
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  N/A
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-17  Jason Wong Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class Ball{
  /* Variable Entries, all relevant size and measurements are in unit"feets" */

  private double[] livePosition = new double[2]; //array creation 1 - position inputs
  private double[] liveSpeed = new double[2]; //array creation 2 - speed inputs
  private double xPosition = 0.0;
  private double yPosition = 0.0;

  private static final double DEFAULT_FRICTION = 0.01;
  private static final double BALL_RADIUS = 4.45;
  private static final double BALL_WEIGHT = 1.0;
  private static final double FRAME_WIDTH_MAXIMUM = 300; // Maximum size in a standard plane(width)
  private static final double FRAME_WIDTH_MAXIMUM2 = -300;
  private static final double FRAME_LENGTH_MAXIMUM = 300; // Maximum size in a standard plane(length)
  private static final double FRAME_LENGTH_MAXIMUM2 = -300;
  private Ticker ticker;

  private double RELEVANT_FRICTION = 0.0;
  private double xDelta = 0.0;
  private double yDelta = 0.0;


  public Ball (double x1, double y1, double dx1, double dy1){
    xPosition = x1;
    xDelta = dx1;
    yPosition = y1;
    yDelta = dy1;
  }

/* Created method to return the subsequent position of the ball */
  public double[] getBallPosition(){
    xPosition = xPosition + xDelta;
    yPosition = yPosition + yDelta;
    livePosition[0] = xPosition;
    livePosition[1] = yPosition;
    return livePosition;
  }

/* Quick method to string the balls' position */
  public String positionString(){
    return "Current Position: " + livePosition[0] + "  " + livePosition[1];
  }

  public boolean gameEnded(){
    if((xPosition > FRAME_WIDTH_MAXIMUM) || (xPosition < FRAME_WIDTH_MAXIMUM2) ||
    (yPosition > FRAME_LENGTH_MAXIMUM) || (yPosition < FRAME_LENGTH_MAXIMUM2)){
      return false;
    }
  return true;
  }

  public double[] getBallSpeed(){
    xDelta = xDelta - (DEFAULT_FRICTION*xDelta);
    yDelta = xDelta - (DEFAULT_FRICTION*xDelta);
    liveSpeed[0] = xDelta;
    liveSpeed[1] = yDelta;
    return liveSpeed;
  }

  public String movementString(){
    return "Current Speed: " + liveSpeed[0] + "  " + liveSpeed[1];
  }
  public static void main ( String args[] ) {
    Ticker ticker = new Ticker();
    Ticker ticker2 = new Ticker();
    System.out.println("Testing Ball.java and its methods...");
    System.out.println("Creating ball with x1,y1 = (10,20), deltaX,deltaT = (3,4)");

    Ball jay =  new Ball (10,20,3,4);
    jay.getBallPosition();
    jay.getBallSpeed();
    System.out.println(jay.positionString());
    System.out.println(jay.movementString());
    System.out.println("Timer: " + ticker.toString());

    ticker.tick();
    jay.getBallPosition();
    jay.getBallSpeed();
    System.out.println(jay.positionString());
    System.out.println(jay.movementString());
    System.out.println("Timer: " + ticker.toString());

    System.out.println("Creating ball with x1,y1 = (100,200), deltaX,deltaT = (-2,-4)");

    Ball jay2 =  new Ball (100,200,-2,-4);
    jay2.getBallPosition();
    jay2.getBallSpeed();
    System.out.println(jay2.positionString());
    System.out.println(jay2.movementString());
    System.out.println("Timer: " + ticker2.toString());

    ticker2.tick();
    jay2.getBallPosition();
    jay2.getBallSpeed();
    System.out.println(jay2.positionString());
    System.out.println(jay2.movementString());
    System.out.println("Timer: " + ticker2.toString());
  }
}
