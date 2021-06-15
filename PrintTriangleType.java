public class PrintTriangleType
{
	public static void main(String[] args) 
	{
		printTriangleType(5,7,7);
		printTriangleType(6,6,6);
		printTriangleType(5,7,8);
		printTriangleType(2,18,2);
	}
	public static void printTriangleType(int side1, int side2, int side3) {
		try {
			//this testSides call will throw an Illegal argument exception if any of the two sides are <= the 3rd side
			testSides(side1, side2, side3);
			//this will test if any of the two sides are equal to one another and the 3rd side is not
			if ((side1 == side2 && side2 != side3) || (side2 == side3 && side3 != side1) || (side1 == side3 && side3 != side2)) {
				System.out.print("isosceles");
			}
			//this will test if all 3 sides are equal to one another
			if (side1 == side2 && side2 == side3) {
				System.out.print("equilateral");
			}
			//this will test if none of the sides are equal to one another
			if (side1 != side2 && side2 != side3 && side1 != side3) {
				System.out.print("scalene");
			}
			//print an extra line at the end so the next call of the function prints on a new line
			System.out.println();
		}
		//this catch operator will catch the illegal argument exception thrown from testSides(side1, side2, side3) if there is one
		catch (IllegalArgumentException impossibleSides) {
			System.out.print("The side lengths " + side1 + ", " + side2 + ", and " + side3 +  " cannot form a triangle");
		}
	}
	//this is a method that will throw an IllegalArgumentException if the sum of any two sides are <= the 3rd side. It will also throw an exception if any of the 3 sides have a length of 0
	public static void testSides(int testSide1, int testSide2, int testSide3) throws IllegalArgumentException{
		if ((testSide1 + testSide2 <= testSide3) || (testSide1 + testSide3 <= testSide2) || (testSide2 + testSide3 <= testSide1) || (testSide1 ==0) ||(testSide2 ==0)||(testSide3 ==0)){
			throw new IllegalArgumentException();
		}
	}
}
