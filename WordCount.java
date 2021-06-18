import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount{
    public static void main (String [] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("/Users/enodynowski/Desktop/Hamlet.txt"));
        wordCounter(input);

    }

    public static void wordCounter(Scanner input) throws FileNotFoundException{
        int lineCount = 0;
        int charCount = 0;
        int wordCount = 0;
        
        //for words and characters
        while (input.hasNext()){
            String next = input.next();
            wordCount++;
            charCount = charCount + next.length();  

        }

        Scanner lines = new Scanner (new File ("/Users/enodynowski/Desktop/Hamlet.txt"));
        while (lines.hasNextLine()){
            lines.nextLine();
            lineCount++;
        }

        System.out.println("Total words = " + wordCount);
        System.out.println("Total characters = " + charCount);
        System.out.println("Total lines = " + lineCount);

    }
    
}
