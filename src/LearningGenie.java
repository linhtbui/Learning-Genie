import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LearningGenie {
    
    public static void main(String[] args) throws IOException {
        DecisionTree tree = new DecisionTree(new File("testfile.txt"));
        
        FileWriter file = new FileWriter(new File("results.txt"));
        tree.firstNode.write(file);
        file.close();
        
        System.out.println("Done.");
    }
}
