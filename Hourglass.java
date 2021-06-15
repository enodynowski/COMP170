public class Hourglass
{
	//can change HALF_HEIGHT to be whatever value, to increase/decrease size of figures
	public static final int HALF_HEIGHT = 17;
	public static void main(String[] args) 
	{
		//these are the two examples from the textbook
		drawLine();
		drawTopTriangle();
		drawBottomTriangle();
		drawLine();
		drawBottomTriangle();
		drawTopTriangle();
		drawLine();
		//this is where I just started experimenting on my own
		drawBottomTriangle();
		drawFourLines();
		drawTopTriangle();
		drawLine();
	}


	//this will create the horizontal line
	public static void drawLine(){
		System.out.print("+");
		for (int e = 1; e <= (2 * HALF_HEIGHT); e++){
			System.out.print("-");
		}
		System.out.println("+");
	}


	//this will create the top triangle of the hourglass
	public static void drawTopTriangle (){
		for (int line = 1; line <= HALF_HEIGHT; line++){
			System.out.print("|");
			for (int i = 1; i <= (line - 1); i++){
				System.out.print(" ");
			}
			System.out.print("\\");
			int stars = 2 * HALF_HEIGHT - 2 * line;
			for (int e = 1; e <= stars; e++){
				System.out.print(".");
			}
			System.out.print("/");
			for (int e = 1; e <= (line -1); e++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
	}


	//this will create the bottom triangle in the hourglass
	public static void drawBottomTriangle (){
		for (int line = 1; line <= HALF_HEIGHT; line++){
			System.out.print("|");
			for (int e = 1; e <= (HALF_HEIGHT - line); e++){
				System.out.print(" ");
			}
			System.out.print("/");
			for (int e = 1; e <= 2 * (line-1); e++){
				System.out.print(".");
			}
			System.out.print("\\");
			for (int e = 1; e <= (HALF_HEIGHT - line); e++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
	}

	//this is only here to reduce the repetitiveness in the main method
	public static void drawFourLines (){
		drawLine();
		drawLine();
		drawLine();
		drawLine();
	}
}
