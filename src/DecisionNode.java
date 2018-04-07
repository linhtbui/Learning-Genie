import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Interface for decision nodes (guesses and questions)
 * 
 * @author holtevan and builinh
 *
 */
public interface DecisionNode {
    
    /** Counts the number of GuessNodes
     * 
     * @return the number of guesses in this subtree
     */
    public int countObjects();
    
    /** Asks a question or makes a guess and reacts accordingly
     * 
     * @param in The Scanner to use for collecting user input
     * @return An updated subtree starting at this node
     */
    public DecisionNode guess(Scanner in);
    
    /** Writes the subtree starting at this node to a file
     * 
     * @param out The FileWriter to write data to
     * @throws IOException Thrown when a file cannot be written to
     */
    public void write(FileWriter out) throws IOException;
}
