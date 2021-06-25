import java.util.ArrayList;import java.util.Collections;public class DigitRange {public static void main (String [] args){System.out.println(calculateDigitRange(25721));System.out.println(calculateDigitRange(481623));System.out.println(calculateDigitRange(7734645));System.out.println(calculateDigitRange(5));}public static int calculateDigitRange(int number){ArrayList<Integer> array = new ArrayList<Integer>(); do {array.add (number % 10); number /= 10;} while (number > 0); return (Collections.max(array) - Collections.min(array) + 1);}}
/* 

haha. I don't think Tony Hoare would appreciate this very much,
but it's all on one line now :)

*/
