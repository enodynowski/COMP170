public class LongestName
{
	public static void main(String[] args) 
	{
		//creating the scanner object and calling the method
		Scanner170 console = new Scanner170(System.in);
		longestName(console, 4);
	}
	public static void longestName(Scanner170 console, int n){
		String longest = "";
		boolean tie = false;
		//printing n amount of times
		for (int i = 1; i <= n; i++){
			System.out.print("Name #" + i + "? ");
			String name = console.next();
			//to test if there has been a tie. I.E. if there are two names with the same length
			if(name.length() == longest.length()) {
				tie = true;
			} else if(name.length() > longest.length()) {
				tie = false;
				longest = name;
			}
		}
		//formatting the name such that only the first letter is capitalized
		String formatted = longest.substring(0, 1).toUpperCase() + longest.substring(1).toLowerCase();
		//printing the final messages. Either the longest name or if there was a tie.
		System.out.println(formatted + "'s name is longest");
		if(tie)
			System.out.println("(There was a tie!)");

		}
	}
