import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode {
    
    public String guessObj;
    
    public GuessNode(String guessObj) {
        this.guessObj = guessObj;
    }
    
    public int countObjects() {
        return 1;
    }
    
    public DecisionNode guess(Scanner in) {
        System.out.print("Are you thinking of " + this.guessObj + "? ");
        
        String answer = in.nextLine().toLowerCase();
        
        if (answer.equals("yes")) {
            System.out.println("Excellent, thanks!");
            return null;
        } else if (answer.equals("no")) {
            System.out.println("Oh no, I was wrong!");
            System.out.print("What [THING] were you thinking of? ");
            
            String thinkingOf = in.nextLine().toLowerCase();
            thinkingOf = Character.toUpperCase(thinkingOf.charAt(0)) + thinkingOf.substring(1);
            
            System.out.println("What is a yes/no question that distinguishes a " + this.guessObj + " from a " + thinkingOf + "?");
            System.out.print("(Yes corresponds to " + this.guessObj + "; No corresponds to " + thinkingOf + ") ");
            
            String newQuestion = in.nextLine().toLowerCase();
            newQuestion = Character.toUpperCase(newQuestion.charAt(0)) + newQuestion.substring(1);
            if (newQuestion.charAt(newQuestion.length() - 1) != '?') {
                newQuestion += "?";
            }
            
            return new QuestionNode(newQuestion, this, new GuessNode(thinkingOf));
        } else {
            return this.guess(in);
        }
    }
    
    public void write(FileWriter out) throws IOException {
        
    }
}
