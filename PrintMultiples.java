public class PrintMultiples
{
	public static void main(String[] args) 
	{
		printMultiples(3, 5);
		printMultiples(7,3);
		printMultiples(-5,3);
		printMultiples(0,4);
	}
	public static void printMultiples (int number, int howMany){
		//Print out the sentence that precedes the multiples
		System.out.print("The first "+ howMany + " multiples of " + number +" are " );
		//this will dictate how many multiples of number will be printed
		//and will print up until the last one required, such that the commas are formatted correctly
		for (int i = 1; i < howMany; i++){
			System.out.print((number * i) + ", ");
		}
		//this will print the very last value, without a comma at the end
		System.out.print(number*howMany);
		//added an extra println so that when called multiple times from main they print on separate lines
		System.out.println();
	}
}
