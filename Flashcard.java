public class Flashcard {
    private String term;
    private String def;
  
    public Flashcard(String t, String d){
      term = t;
      def = d;
    }
  
    public String getDef(){
      return def;
    }
  
    public String getTerm(){
      return term;
    }
  
    public String toString (){
    return "Term: " + term + "\nDefinition: " + def;
    }
  }