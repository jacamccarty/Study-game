public class LifeMeter{
  private int currentX;
  private int y;
  private int lifeCount;

  public LifeMeter (){
    currentX = 100;
    y = 90;
    drawMeter();
    lifeCount = 5;
  }

  private void drawMeter(){
    StdDraw.setPenColor(StdDraw.RED);
    for(int i = 0; i < 5; i++){
      StdDraw.circle(currentX, y, 2);
      currentX = currentX - 4;
    }
  }

  public void loseLife(){
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.circle(currentX, y, 2);
    currentX = currentX + 4;
    lifeCount--;
  }

  public int getLifeCount(){
    return lifeCount;
  }
}