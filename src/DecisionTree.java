import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecisionTree {
    
    public DecisionNode firstNode;
    
    public DecisionTree() {
        this.firstNode = new GuessNode("Dog");
    }
    
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
