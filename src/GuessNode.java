import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Class for storing guesses
 * 
 * @author holtevan and builinh
 *
 */
public class GuessNode implements DecisionNode {
    
    public String guessObj;
    
    /** Instantiates a new GuessNode with the given guess
     * 
     * @param guessObj The guess for the new node
     */
    public GuessNode(String guessObj) {
        this.guessObj = guessObj;
    }
    
    /** 
     * See DecisionNode interface
     */
    public int countObjects() {
        return 1;
    }
    
    /** 
     * See DecisionNode interface
     */
    public DecisionNode guess(Scanner in) {
        System.out.print("Are you thinking of " + this.guessObj + "? ");
        
        String answer = in.nextLine().toLowerCase();
        
        if (answer.equals("yes")) {
            System.out.println("Excellent, thanks!");
            return this;
        } else if (answer.equals("no")) {
            System.out.println("Oh no, I was wrong!");
            System.out.print("What country were you thinking of? ");
            
            String thinkingOf = in.nextLine().toLowerCase();
            thinkingOf = Character.toUpperCase(thinkingOf.charAt(0)) + thinkingOf.substring(1);
            
            System.out.println("What is a yes/no question that distinguishes " + this.guessObj + " from " + thinkingOf + "?");
            System.out.print("(Yes corresponds to " + this.guessObj + "; No corresponds to " + thinkingOf + ") ");
            
            String newQuestion = in.nextLine().toLowerCase();
            newQuestion = Character.toUpperCase(newQuestion.charAt(0)) + newQuestion.substring(1);
            if (newQuestion.charAt(newQuestion.length() - 1) != '?') {
                newQuestion += "?";
            }
            
            System.out.println("Thanks! I'll learn from this experience!");
            
            return new QuestionNode(newQuestion, this, new GuessNode(thinkingOf));
        } else {
            return this.guess(in);
        }
    }
    
    /** 
     * See DecisionNode interface
     */
    public void write(FileWriter out) throws IOException {
        out.write(this.guessObj + '\n');
    }
}
