public class Aliens{
    private int xCoor = (int)(Math.random() * 91) + 5;
    private int yCoor = (int)(Math.random()*5) + 100;
    public boolean isAlienHit;
    private AlienLasers gun = new AlienLasers(xCoor, yCoor);
    
  
    public Aliens(){
      isAlienHit = false;
      StdDraw.enableDoubleBuffering();
      generateAlien(xCoor, yCoor);
      while(isAlienHit == false){
        moveAlien();
      }
    }
  
    private void generateAlien(int x, int y){//don't touch this
      StdDraw.picture(xCoor, y, "Rb51c045087e1c551ab2e5a2c40df6b23.png");
    }
  
    private void moveAlien(){
      while(yCoor > -50 && isAlienHit == false) {
        StdDraw.clear();
        yCoor = yCoor - 5;
        generateAlien(yCoor, xCoor);
        StdDraw.pause(60);
      }
    }
  
    public void setHit(){
      isAlienHit = true;
      double r = 5;
      while (r <= 15){
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.circle(xCoor, yCoor, r);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.circle(xCoor, yCoor, r/3);
        StdDraw.pause(60);
        r++;
      }
      
    } 
  
    //accessors
    
    public int getXCoor(){
      return xCoor;
    }
  
    public int getYCoor(){
      return yCoor;
    }
  }