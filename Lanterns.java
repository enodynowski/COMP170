public class Lanterns {
	public static void main(String[] args) 
	{
		PrintTwoTops();
		PrintVerticals();
		PrintStarLine();
		PrintTwoTops();
		PrintStarLine();
		PrintVerticals();
		PrintVerticals();
		PrintStarLine();
		PrintStarLine();
		System.out.println("    *****");
	}
	public static void PrintTwoTops(){
		PrintTop();
		System.out.println();
		PrintTop();
	}
	public static void PrintTop(){
		System.out.println("    *****");
		System.out.println("  *********");
		System.out.println("*************");
	}
	public static void PrintVerticals(){
		System.out.println("* | | | | | *");
	}
	public static void PrintStarLine(){
		System.out.println("*************");
	}
}
