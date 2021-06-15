public class Triangles {
    public static void main(String[] args) {
        // tests of printTriangleType
        printTriangleType(5, 7, 7); // isoceles
        printTriangleType(6, 6, 6); // equilateral
        printTriangleType(5, 7, 8); // scalene
        printTriangleType(2, 18, 2); // throws exception
        printTriangleType(-6, -6, -6); // would also throw exception
    }
    // preconditions for printTriangleType
    //	    All three side lengths passed are > 0
    //		No side's length exceeds the sum of any two other sides
    // postconditions
    //		If all three sides are the same, the method prints equilateral
    //		otherwise if two of the sides are the same, the method prints isoceles
    //		otherwise the method prints scalene

    public static void printTriangleType(int a, int b, int c) {
        System.out.println("call of printTriangleType(" + a + ", " + b + ", " + c + ")"); // DEBUG
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("at least one side is <= 0: " + a + ", " + b + ", " + c);
        }
        if (a+b < c || a+c < b || b+c < a) {
            throw new IllegalArgumentException("at least one side is longer than the sum of the other two sides: " +
                    a + ", " + b + ", " + c);
        }
        // pseudocode for the method goes here, followed by the Java code
    }
}