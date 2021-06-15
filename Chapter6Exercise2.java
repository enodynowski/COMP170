import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Chapter6Exercise2 {
    public static void main(String[] args) throws FileNotFoundException
    {
            Scanner input = new Scanner(new File( "/Users/enodynowski/Desktop/integers" ));
            evenNumbers(input);

    }
    public static void evenNumbers(Scanner input){
        int number = 0;
        int total = 0;
        int sum = 0;
        int evens = 0;
        double evenPercent = 0.0;
        while (input.hasNextInt()){
            number = input.nextInt();
            total++;
            sum += number;
            if (number % 2 == 0){
                evens++;
            }
        }
        evenPercent = (100 * evens/total);
        System.out.println(total + " numbers, sum = " + sum );
        System.out.println(evens + " evens" + " (" + evenPercent + "%)");
        
    }
}
