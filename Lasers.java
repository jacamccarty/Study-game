
public class Lasers{
    private int xCoor;
    private int yCoor;
    public boolean isExploded;
  
    public Lasers(int x, int y){
      StdDraw.setPenColor(StdDraw.WHITE);
      xCoor = x;
      yCoor = y;
      boolean isExploded = false;
  
      drawLaser();
      while(isExploded == false || yCoor <= 100){
        moveLaser();
      }
  
    }
  
    private void drawLaser(){
      StdDraw.line(xCoor, yCoor, xCoor, yCoor + 2);
    }
  
    private void moveLaser(){
      StdDraw.clear();
      yCoor = yCoor + 2;
      drawLaser();
      StdDraw.pause(60);
    }
  
    public void isAlienShot(Aliens a){
      int ax = a.getXCoor();
      int ay = a.getYCoor();
      if(ax <= xCoor + 5 && ax >= xCoor - 5 && ay <= yCoor + 5 && ay >= yCoor - 5){
        a.isAlienHit = true;
        isExploded = true;
      }
    }
    
    public int getX(){
      return xCoor;
    }
  
    public int getY(){
     return yCoor;
    }
  
  }