import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

public class StudyInvaders {
  public static void main(String[] args) throws IOException {
      StdDraw.setXscale(0, 101);
      StdDraw.setYscale(0, 101);
      StdDraw.setPenRadius(0.01);
      //read in file and establish arraylist of flashcards
      //showMenu();
  }

public static void showMenu(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Options:");
    System.out.println("Create a set: enter 'c'");
    System.out.println("Warning! Creating a new set will erase previously made sets.");
    System.out.println("Play Space Invaders: enter 'p'");
    System.out.println("See instructions: enter 'i'");
    String r = sc.nextLine();
    if(r.equals("c")){
        ArrayList<Flashcard> f = createSet();
        
    }
    else if(r.equals("i")){
      System.out.println("Welcome to Study Invaders! You are in a spaceship, and you must defeat the evil aliens by shooting them with your knowledge! Every turn, you will be shown a term from your flashcard set. If you answer the question correctly, you will be rewarded with 5 shots to beat those pesky aliens! But watch out - if you answer incorrectly you'll be the one taking damage. The game ends when you answer every question correctly, unless the aliens get to you first! Good luck and happy studying!!!");
    }
    else {
      System.out.println("Please enter a valid option!");
      showMenu();
    }
  }

  public static ArrayList<Flashcard> createSet () {
     Scanner sc = new Scanner(System.in);
     boolean done = false;
     ArrayList<Flashcard> set = new ArrayList<Flashcard>();
     while (!done){
       System.out.println("Enter a term: ");
       String t = sc.nextLine();
       System.out.println("Enter the definition:");
       String d = sc.nextLine();
       Flashcard f = new Flashcard(t, d);
       set.add(f);
       
       System.out.println("Would you like to add another card? 'yes' or 'no'");
       String r = sc.nextLine();
       if (r.equals("no")){
         done = true;
       }   
       else if (!r.equals("yes")){
         System.out.println("Please enter 'yes' or 'no'!");
         r = sc.nextLine();
       }
       if (r.equals("no")){
         done = true;
       } 
     }
     return set;
  }

  public static void playGame(ArrayList<Flashcard> f){
  //display the ship at the bottom of the screen w/background
  // initialize lives and shots 
    Ship ship = new Ship();
    LaserMeter numShots = new LaserMeter();
    ArrayList<Aliens> allAliens = new ArrayList<Aliens>();
    //enemies on other side of screen (maybe like ten at the start)
    for(int i =0; i < 5; i++){ 
      Aliens a = new Aliens();
      allAliens.add(a);
    }

    while(ship.getLives() > 0){
      ship.moveShip();
      boolean correctAnswer = checkAnswer(f);
      if (correctAnswer){
        numShots.addShots();
      }
      while(numShots.getLaserCount() > 0){
        if(StdDraw.isMousePressed() && numShots.getLaserCount() > 0){
          Lasers shot = new Lasers(ship.getX(), ship.getY());
        }
        else if(StdDraw.isMousePressed() && numShots.getLaserCount() == 0){
          System.out.println("You're out of shots! Answer a question to get more!");
        }
      }
    //update lives and shots accordingly
    //loop again (ask the question, etc.)
      if (f.size() == 0){
        System.out.println("Congrats! You showed those aliens who's boss.");
        //f.size)
        //enemies spontaneously combust
        break;
      }
      if (ship.getLives() == 0){
        System.out.println("Better luck next time, haha.");
        break;
      }
    }
    }
    
  // space to shoot
  // esc to pause 
        //create a pause menu
  //loop
    //question shows up:
    //the aliens get to shoot(must be within 5 y level)
    //if answer correctly, gets to have like 5 shots(must be within 5 y level)
    //game over if answer all questions or u die (lol rip)
  

  public static boolean checkAnswer (ArrayList<Flashcard> f){
    Scanner sc = new Scanner(System.in);
    int i = (int)(Math.random() * (f.size()) + 0);
    System.out.print("What term has the definition: ");
    System.out.println(f.get(i).getDef() + "? ");
    String answ = sc.nextLine();
    if( answ.equals(f.get(i).getTerm())){
      f.remove(i);
      System.out.println("Good job, you got it! Now shoot down those aliens!");
      return true;
    }
    else{
      System.out.println("Oh no! The answer was actually " + f.get(i).getTerm());
      System.out.println("Looks like the aliens are stealing this shot.");
      return false;
    }
  }
}



