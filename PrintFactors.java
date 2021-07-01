public class PrintFactors{
    public static void main (String [] args){
        printFactors(-4);

    }
    public static void printFactors(int number){
        // a simple for loop that increments every value between 1 and number 
        for (int i = 1; i < number; i++){
            //test to see if i divides into number an even amount of times, and if so, it will print it
            if (number % i == 0){
                System.out.print(i + " and ");
            }
        }
        //the fencepost aspect of this algorithm is that the above for loop will print only the last "wire" not include the last "post"
        //so here is the last "post" a.k.a number in this case. 
        System.out.println(number);

    }
}