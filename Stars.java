public class Stars
{
	public static void main(String[] args)
	{
		printStars();
		}

	public static void printStars() {
		for (int i = 1; i <= 4; i++){
			for (int stars = 1; stars <= -2 * i + 9; stars++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}