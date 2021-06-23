import java.util.ArrayList;

public class DigitRange {
   /* For what it's worth, I really don't know if this is the "correct" way
    to solve this one, but it's what I was able to come up with. Any feedback on an easier
    or less complicated method would be greatly appreciated.
   */
   
    public static void main (String [] args){
        //some examples
        // 7 - 2 = 5, +1 is 6, so should print 6
        System.out.println(calculateDigitRange(25721));
        //8 - 1 = 7 + 1 is 8, so should print 8
        System.out.println(calculateDigitRange(481623));
        //7 - 3 = 4 + 1 is 5, so should print 5
        System.out.println(calculateDigitRange(7734645));
        //testing a 1 digit case, it returns 1
        System.out.println(calculateDigitRange(5));



    }
    public static int calculateDigitRange(int number){
        
        //so since I can't just cast number to a string and use indexOf(), I cast it to an Array list instead 

        ArrayList<Integer> array = new ArrayList<Integer>();
        //This do/while block will break down the number passed into the method into its component digits
        do {
            array.add (number % 10);
            number /= 10;
        } while (number > 0);
       

        //I set the variable maximum to the correseponding value of an unimportant index in the Array list, in this case, at index 0
        int maximum = array.get(0);
        //this for loop will traverse the array, 
        //and if it encounters a value at index i that is greater than the previously defined value, it will update maximum to that value
        for (int i = 1; i < array.size();i++){
            if (array.get(i)>maximum){
                maximum = array.get(i);
            }
        }
       
        //I set the variable minimum to the correseponding value of an unimportant index in the Array list, in this case, at index 1
        int minimum = array.get(0);
        //this is the same as the loop above for max, however it will test the values to see if they are less than
        //the previousl define minimum, and then update the minimum to that value
        for (int i = 1; i <array.size(); i++){
            if (array.get(i) < minimum){
                minimum = array.get(i);
            }
        }
        // a quick math expression to evaluate the difference between the two values
        int difference = maximum - minimum + 1;
        
        
        return difference;
        
        
    }
     
}

