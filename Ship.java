public class Ship {
    private int xCoor;
    private int yCoor;
    public boolean isShipHit;
    LifeMeter lives = new LifeMeter();
  
    public Ship(){
      
      isShipHit = false;
      xCoor = 50;
      yCoor = 0;
      drawShip(xCoor, yCoor);
    }
  
    public void drawShip(int x, int y){
      StdDraw.picture(x, y, "Re069d4c18a8525c6fac4c2a187761fd9.png");
    }
  
    public void moveShip(){
      if(xCoor > StdDraw.mouseX()){
          xCoor = xCoor - 1;
          StdDraw.clear();
          drawShip(xCoor, yCoor);
          StdDraw.pause(60);
      }else if(xCoor < StdDraw.mouseX()){
          xCoor = xCoor + 1;
          StdDraw.clear();
          drawShip(xCoor, yCoor);
          StdDraw.pause(60);
      }
    }
  
    public int getX(){
      return xCoor;
    }
  
    public int getY(){
     return yCoor;
    }
  
    public int getLives(){
      return lives.getLifeCount();
    }
  
  
    public void gotHit(){
      isShipHit = true;
      lives.loseLife();
    } 
  }