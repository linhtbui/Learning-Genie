import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Main class
 * 
 * @author holtevan and builinh
 *
 */
public class LearningGenie {
    
    /** Main method for LearningGenie
     * 
     * @param args Command line arguments
     * @throws IOException Thrown when a file cannot be written to
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        File dataTree = new File("datatree.txt");
        DecisionTree tree = new DecisionTree(dataTree);
        
        System.out.println("I am the learning genie!");
        System.out.println("I can figure out whatever you are thinking of by questions.");
        
        int numThings = tree.firstNode.countObjects();
        if (numThings == 1) {
            System.out.println("I know " + tree.firstNode.countObjects() + " thing!");
        } else {
            System.out.println("I know " + tree.firstNode.countObjects() + " things!");
        }
        
        while (true) {
            System.out.println("\nThink of a country!");
            
            tree.firstNode = tree.firstNode.guess(in);
            
            System.out.print("Do you want to continue? ");
            String answer = in.nextLine().toLowerCase();
            if (answer.equals("no")) {
                break;
            }
        }
        
        FileWriter writer = new FileWriter(dataTree);
        tree.firstNode.write(writer);
        writer.close();
        in.close();
    }
}
