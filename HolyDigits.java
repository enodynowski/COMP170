public class HolyDigits {
    public static void main (String[] args){
        
        addressFinder();

    }
    public static void addressFinder(){
        int testNumber = 1;
        int checkCorrect = 0;
        int a,b,c,d, digitSum;
        a = 0;
        b = 0;
        c = 0;
        d = 0;

        while (checkCorrect == 0){
            a = testNumber % 10;
            System.out.println(a);
            b = testNumber % 100 - a/10;
            System.out.println(b);
            c = testNumber % 1000 - (a+b)/100;
            System.out.println(c);

            d = testNumber % 10000 - (a+b+c)/1000;
            System.out.println(d);

            digitSum = (a+b+c+d);

            if ((a != b) && (b != c) && (c != d) && (a != c) && (a != d) && (b != d) && (a == (c*3)) && (digitSum == 27) && (d % 2 == 0)){
                System.out.println("Hello 0");
                checkCorrect = 1;
                } else {
                    System.out.println(checkCorrect);
                    testNumber++;
                    System.out.println(testNumber);

                }
                   
        }
        System.out.println("The address is: " + a + b + c + d + "Pennsylvania Ave");

    }   
}
