import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Class to generate a new tree of DecisionNodes
 * 
 * @author holtevan and builinh
 *
 */
public class DecisionTree {
    
    public DecisionNode firstNode;
    
    /** Instantiates a new tree containing only the USA
     */
    public DecisionTree() {
        this.firstNode = new GuessNode("USA");
    }
    
    /** Recursively assembles a subtree starting at the current node
     * 
     * @param current The first node in this subtree
     * @param in The Scanner to read new nodes with
     */
    private void assembleTree(QuestionNode current, Scanner in) {
        String line = in.nextLine();
        
        if (line.charAt(0) == '#') {
            current.yesNode = new QuestionNode(line.substring(1), null, null);
            
            assembleTree((QuestionNode) current.yesNode, in);
            
            line = in.nextLine();
            
            if (line.charAt(0) == '#') {
                current.noNode = new QuestionNode(line.substring(1), null, null);
                
                assembleTree((QuestionNode) current.noNode, in);
            } else {
                current.noNode = new GuessNode(line);
            }
        } else {
            current.yesNode = new GuessNode(line);
            
            line = in.nextLine();
            
            if (line.charAt(0) == '#') {
                current.noNode = new QuestionNode(line.substring(1), null, null);
                
                assembleTree((QuestionNode) current.noNode, in);
            } else {
                current.noNode = new GuessNode(line);
            }
        }
    }
    
    /** Instantiates a new tree by reading a saved DecisionTree from a text file
     * 
     * @param file The file to read from
     * @throws FileNotFoundException Thrown if the file cannot be found
     */
    public DecisionTree(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        
        String line = in.nextLine();
        
        if (line.charAt(0) == '#') {
            this.firstNode = new QuestionNode(line.substring(1), null, null);
            
            assembleTree((QuestionNode) this.firstNode, in);
        } else {
            this.firstNode = new GuessNode(line);
        }
    }
}
