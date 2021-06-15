public class SeeMovie
{
	public static void main(String[] args) 
	{
		//outputs not
		seeMovie(15.4, 4);

		//outputs very
		seeMovie(4.99, 3);

		//outputs sort of
		seeMovie(24.99, 5);
	}
	public static void seeMovie(double cost, int rating){
		if (cost < 5.0 ||(cost <12.0 && rating == 5)){
			System.out.println("very");
		}
		if (cost >= 12.0 && rating == 5){
			System.out.println("sort of");
		} else if (cost >= 12.0){
			System.out.println("not");
		}
		if ((cost >= 5.0 && cost <=11.99) && (rating >= 2 && rating <= 4)){
			System.out.println("sorta");
		}
		if ((rating < 2) && (cost >= 5.0)){
			System.out.println("not");
		}
	}
}
