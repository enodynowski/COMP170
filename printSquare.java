public class printSquare {
	public static void main(String[] args) 
	{
		makeASquare(3, 7);
	}
	public static void makeASquare(int min, int max){
		for (int i = min; i <= max; i++){
			for(int j = i; j<=max; j++){
				System.out.print(j);
			}
			for(int j = min; j < i; j++){
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
