public class Quadrant
{
	public static void main(String[] args) 
	{
		testQuadrant(-2.3, 14.2);
	}
	public static void testQuadrant(double x, double y){
		if (x < 0 && y < 0){
			System.out.print(3);
		}
		if (x < 0 && y > 0){
			System.out.print(2);
		}
		if (x > 0 && y < 0){
			System.out.print(4);
		}
		if (x > 0 && y > 0){
			System.out.print(1);
		}
		if ( x == 0 || y == 0){
			System.out.print(0);
		}
	}
}
