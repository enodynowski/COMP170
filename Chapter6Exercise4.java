import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class Chapter6Exercise4 {
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main (String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File( "/Users/enodynowski/Desktop/coins" ));
        countCoins(input);
        
    }
    public static void countCoins(Scanner input){
        final double PENNY = 0.01; 
        final double NICKEL = 0.05;
        final double DIME = 0.1;
        final double QUARTER = 0.25; 
        double totalCount = 0.0;
        int coinCount = 0;
        String coinType;
        while (input.hasNext()){
            coinCount = input.nextInt();
            coinType = input.next();
            if (coinType.equalsIgnoreCase("PENNIES")){
                totalCount += coinCount *PENNY;
            } else if (coinType.equalsIgnoreCase("NICKELS")){
                totalCount+= coinCount * NICKEL;
            } else if (coinType.equalsIgnoreCase("DIMES")){
                totalCount += coinCount * DIME;
            } else if (coinType.equalsIgnoreCase("QUARTERS")){
                totalCount += coinCount * QUARTER;
            } 
        }
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("$" + df.format(totalCount));
    } 
}
