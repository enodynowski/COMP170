import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Chapter6Exercise4 {
    //this will format the decimal places in the final value such that it rounds down to only 2
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main (String[] args) throws FileNotFoundException{
       //Creating the scanner object and pointing it to the file that contains the text "29 pennies 38 quarters 101 Pennies 47 NiCkeLs 9 DIMES"
        Scanner input = new Scanner(new File( "/Users/enodynowski/Desktop/coins" ));
        countCoins(input);
        
    }
    public static void countCoins(Scanner input){
       //declaring constant variables
        final double PENNY = 0.01; 
        final double NICKEL = 0.05;
        final double DIME = 0.1;
        final double QUARTER = 0.25; 
        double totalCount = 0.0;
        int coinCount = 0;
        String coinType;
        //reading the file for integers and strings
        while (input.hasNext()){
            coinCount = input.nextInt();
            coinType = input.next();
            //this will ignore the case of the strings, and parse the text to determine which constant to multiple by
            if (coinType.equalsIgnoreCase("PENNIES")){
                totalCount += coinCount * PENNY;
            } else if (coinType.equalsIgnoreCase("NICKELS")){
                totalCount+= coinCount * NICKEL;
            } else if (coinType.equalsIgnoreCase("DIMES")){
                totalCount += coinCount * DIME;
            } else if (coinType.equalsIgnoreCase("QUARTERS")){
                totalCount += coinCount * QUARTER;
            } 
        }
        //set the rounding to down and print the final output
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("$" + df.format(totalCount));
    } 
}
