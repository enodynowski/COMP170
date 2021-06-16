import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Chapter6Exercise2 {
    public static void main(String[] args) throws FileNotFoundException
    {
         //reads a .txt file with a list of integers, separated by single spaces e.g. 5 1 28 13   
        Scanner input = new Scanner(new File( "/Users/enodynowski/Desktop/integers" ));
        evenNumbers(input);

    }
    public static void evenNumbers(Scanner input){
        int number = 0;
        int total = 0;
        int sum = 0;
        int evens = 0;
        double evenPercent = 0.0;
        //parses through the integers in the file, stopping before there are no more integers
        while (input.hasNextInt()){
            number = input.nextInt();
            total++;
            sum += number;
            //incrememnting the value of evens for all of the even numbers present 
            if (number % 2 == 0){
                evens++;
            }
        }
        //calculating the percentage of integers that are even
        evenPercent = (100 * evens/total);
        System.out.println(total + " numbers, sum = " + sum );
        System.out.println(evens + " evens" + " (" + evenPercent + "%)");
        
    }
}
