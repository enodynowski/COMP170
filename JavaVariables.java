import java.util.*;

public class JavaVariables {
    public static void main(String[] args) {
        /*
         * we declare variables by putting a type name in front of them;
         * declaring a variable does not give it a value
         * examples:
         *  int x; or char c; double d; or String s;
         *
         * primitive types always begin with a lower case letter, and
         * reference (object) types always begin with an upper case letter
         *
         * primitive type variables have different sizes depending on what
         * types of values go into them: ints are 32 bits, chars are 16 bits,
         * doubles are 64 bits, etc
         *
         * once we put a value into a primitive variable it is independent of
         * all other primitive variables' values, even of the same type; values
         * are put into variables through assigning them a matching expression
         *
         * examples:
         *  int x; x = 42; or int x = 42; // this expression is a literal int
         *  int y = x; y = 34; // x and y are independent of each other, x == 42
         *
         * reference type variables are all the same size, just big enough to
         * hold a reference to an object in memory (like a memory address); a
         * reference variable does not contain the object it refers to, that
         * object lives in memory and is pointed to or referred to by the variable
         *
         * this means that two or more variables could refer to the same object
         * and both of them would see any changes made to that object
         *
         * examples:
         *  String s = "abc"; or Random r = new Random();
         *  or Scanner170 console = new Scanner170(System.in);
         *
         * s, r, and console do not contain their respective objects, so == does
         * not work the way you might expect - it checks that two variables refer to
         * the same object in memory, not that those objects' contents are the same;
         * use the objects' equals method to check for that
         *
         * also, unless a class changes the way its objects are printed, the standard
         * way of printing an object will not reveal its contents, it will only print
         * its class name and its "address", like java.util.Random@548e7850
         *
         * an array is a way of giving a set of values of the same type a single name:
         * an array variable starts with a type (primitive or reference) followed
         * by [] and the variable name, like int[] numbers or String[] names - those
         * each reserve the same size area in memory that can hold an object reference,
         * because arrays in Java are objects!
         *
         * initializing an array means assigning it an array reference giving its length
         * like int[] numbers = new int[25]; or numbers = new int[25] if already declared -
         * that creates an array of that length filled with 0's; if we want to fill up the
         * array with values, we can use a for loop:
         *  int[] numbers = new int[5]; // elements are numbers[0] ... numbers[4]
         *  for (int i = 0; i < numbers.length; i++) { // .length gives its fixed length
         *      numbers[i] = i + 1; // 1 through 5
         *  }
         *
         * alternatively we can create an array using array "initializer syntax":
         * int[] numbers = { 1, 2, 3, 4, 5 }; // length 5 filled with those numbers
         *
         * since arrays in Java are objects, two array variables can refer to the same
         * array in memory: int[] numbers2 = numbers; // if numbers is initialized
         * then changing the array using one of the variables causes a change in the other:
         * numbers[3] = 99; // then numbers2[3] is 99 because both refer to the same array
         *
         * arrays do not have methods like normal Java objects, and as mentioned above,
         * == and printing won't work as you might expect with arrays - instead the Arrays
         * class in java.util provides equals and toString methods to help with arrays:
         * boolean b = Arrays.equals(numbers2, numbers); // equal even if not the same object
         * System.out.println(Arrays.toString(numbers)); // prints contents of numbers
         */

        int[] numbers = { 1, 2, 3, 4, 5 }; // new array object, array initializer syntax
        int[] numbers1 = new int[5]; // another distinct array object
        int[] numbers2 = numbers; // numbers and numbers2 refer to the same object now
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = i+1; // 1 to 5
        }
        System.out.println("comparing numbers and numbers1 using ==:");
        System.out.println(numbers == numbers1);
        System.out.println("comparing numbers and numbers1 using Arrays.equals:");
        System.out.println(Arrays.equals(numbers, numbers1));
        System.out.println();
        System.out.println("printing numbers using println(numbers): " + numbers);
        System.out.println("printing numbers1 using println(numbers1): " + numbers1);
        System.out.println("printing numbers using Arrays.toString: " + Arrays.toString(numbers));
        System.out.println("printng numbers1 using Arrays.toString: " + Arrays.toString(numbers1));
        System.out.println();
        numbers[3] = 99;
        System.out.println("numbers: " + Arrays.toString(numbers));
        System.out.println("numbers2: " + Arrays.toString(numbers2));
        System.out.println("numbers1: " + Arrays.toString(numbers1)); // different object
    }
}
