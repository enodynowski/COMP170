public class Sequence
{
	public static void main(String[] args) 
	{
		printStars();
	}
	public static void printStars(){
		for (int i = 1; i <= 6; i++){
			for (int j = 1; j <= 3 * i + 5; j++ ){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
