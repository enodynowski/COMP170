public class numUnique
{
	public static void main(String[] args) 
	{
		uniques(3,3,3);
	}
	public static void uniques(int a, int b, int c){
		if ((a == b && b != c) || (b == c && c != a) || (a == c && c != b)){
			System.out.print(2);
		}
		if (a == b && b == c){
			System.out.print(1);
		}
		if (a != b && b != c && a != c){
			System.out.print(3);
		}

	}
}
