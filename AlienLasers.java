public class AlienLasers{
    private int xCoor;
    private int yCoor;
    public boolean isExploded;
  
    public AlienLasers(int x, int y){
      StdDraw.setPenColor(StdDraw.RED);
      xCoor = x;
      yCoor = y;
      boolean isExploded = false;
  
      drawLaser();
      while(isExploded == false || yCoor >= 0){
        moveLaser();
      }
  
    }
  
    private void drawLaser(){
      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.line(xCoor, yCoor, xCoor, yCoor - 2);
    }
  
    private void moveLaser(){
      StdDraw.clear();
      yCoor = yCoor + 2;
      drawLaser();
      StdDraw.pause(60);
    }
  
    public void isShipShot(Ship s){
      int sx = s.getX();
      int sy = s.getY();
      if(sx <= xCoor + 5 && sx >= xCoor - 5 && sy <= yCoor + 5 && sy >= yCoor - 5){
        s.isShipHit = true;
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
  