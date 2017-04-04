/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Utilizes the Ball.java methods to run a soccer simulation
 *  @author       :  Jason Wong
 *  Date written  :  2017-3-17
 *  Description   :  Utilizing the methods listed in Ball.java, this program will run a full simulation to find
                     the collisions of ball on a standard plane.  The maximum field(width,length) has been set to
                     300, 300 in Ball.java.  The program will also state when the balls are halted.
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  N/A
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-02  Jason Wong Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class SoccerSim {

  public double numberBalls;
  public Ball[] balls;
  public double[] collision;
  public Ticker ticker;

  private static final double BALL_RADIUS = 4.45;

  public double distance;
  public double timeSlice;
  public double CollisionX;
  public double CollisionY;

  public SoccerSim(){
    timeSlice = 0;
    balls = null;
    numberBalls = 0;
  }

  public void createBalls(String args[] ) {
     System.out.println("Beginning Soccer Simulation . . .");

     if (args.length < 4 || args.length > 5){
       System.out.println("Sorry, you must input a minimum of 4 inputs and a maximum of 5 inputs.");
       System.exit(1);
     }
    Ticker tickermain = new Ticker();
    numberBalls = Math.floor(args.length/4);
    int h = 0;
    balls = new Ball[(int)numberBalls];

    for (int i=0; i<args.length -1; i+=4){
      double xPosition = Double.parseDouble(args[0+i]);
      double yPosition = Double.parseDouble(args[1+i]);
      double xDelta = Double.parseDouble(args[2+i]);
      double yDelta = Double.parseDouble(args[3+i]);
      balls[h] = new Ball (xPosition, yPosition, xDelta, yDelta);
      balls[h].getBallPosition();
      balls[h].getBallSpeed();
      h++;
      System.out.println(h + " position " + balls[h].positionString() + " , speed: " + balls[h].movementString());
    }
  }
public void addBalls(){
  for (int i = 0; i<numberBalls; i++){
    balls[i].getBallPosition();
    balls[i].getBallSpeed();
  }
}

public boolean ballCollision(){
  for (int i = 0; i<= numberBalls-2; i++){
    for (int j = 1 + i; j<= numberBalls-1; j++){
      CollisionX = balls[0].getBallPosition()[0] - balls[1].getBallPosition()[0];
      double exponentialX = Math.pow(CollisionX ,2);
      CollisionY = balls[0].getBallPosition()[1] - balls[1].getBallPosition()[1];
      double exponentialY = Math.pow(CollisionY,2);
      distance = Math.sqrt(exponentialX + exponentialY);
      if (distance <=((BALL_RADIUS*2)/12)){
        System.out.println("Collision has occurred");
        return true;
      }
      return false;
    }
  }
  return false;
}
  public boolean gameOver(){
    for (int i = 0; i<numberBalls; i++){
    if (balls[i].gameEnded()){
      return true;
    }
  System.out.println("Game has ended and there is no potential for collision");
  return false;
  }
  return false;
}
  public static void main( String args[] ){
    Ticker tickfinal = new Ticker();
    SoccerSim j = new SoccerSim();

    while (j.gameOver()){
      j.addBalls();
      tickfinal.tick();

      if (j.ballCollision() == true){
        break;
      }
      continue;
    }
  }
}
