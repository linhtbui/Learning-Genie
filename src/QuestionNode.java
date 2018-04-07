import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Class for storing questions
 * 
 * @author holtevan and builinh
 *
 */
public class QuestionNode implements DecisionNode {
    
    public String question;
    public DecisionNode yesNode;
    public DecisionNode noNode;
    
    /** Instantiates a new QuestionNode with the given question and yes and no subtrees
     * 
     * @param question The question for the new node
     * @param yesNode The first node in the yes-subtree for this node
     * @param noNode The first node in the no-subtree for this node
     */
    public QuestionNode(String question, DecisionNode yesNode, DecisionNode noNode) {
        this.question = question;
        this.yesNode  = yesNode;
        this.noNode   = noNode;
    }
    
    /** 
     * See DecisionNode interface
     */
    public int countObjects() {
        return this.yesNode.countObjects() + this.noNode.countObjects();
    }
    
    /** 
     * See DecisionNode interface
     */
    public DecisionNode guess(Scanner in) {
        System.out.print(this.question + " ");
        
        String answer = in.nextLine().toLowerCase();
        
        if (answer.equals("yes")) {
            this.yesNode = this.yesNode.guess(in);
            
            return this;
        } else if (answer.equals("no")) {
            this.noNode = this.noNode.guess(in);
            
            return this;
        } else {
            return this.guess(in);
        }
    }
    
    /** 
     * See DecisionNode interface
     */
    public void write(FileWriter out) throws IOException {
        out.write("#" + this.question + '\n');
        this.yesNode.write(out);
        this.noNode.write(out);
    }
}
