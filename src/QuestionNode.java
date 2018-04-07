import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode {
    
    public String question;
    public DecisionNode yesNode;
    public DecisionNode noNode;
    
    public QuestionNode(String question, DecisionNode yesNode, DecisionNode noNode) {
        this.question = question;
        this.yesNode  = yesNode;
        this.noNode   = noNode;
    }
    
    public int countObjects() {
        return this.yesNode.countObjects() + this.noNode.countObjects();
    }
    
    public DecisionNode guess(Scanner in) {
        System.out.print(this.question + " ");
        
        String answer = in.nextLine().toLowerCase();
        
        if (answer.equals("yes")) {
            DecisionNode newNode = this.yesNode.guess(in);
            
            if (newNode != null) {
                this.yesNode = newNode;
            }
            
            return null;
        } else if (answer.equals("no")) {
            DecisionNode newNode = this.noNode.guess(in);
            
            if (newNode != null) {
                this.noNode = newNode;
            }
            
            return null;
        } else {
            return this.guess(in);
        }
    }
    
    public void write(FileWriter out) throws IOException {
        out.write("#" + this.question + '\n');
        this.yesNode.write(out);
        this.noNode.write(out);
    }
}
