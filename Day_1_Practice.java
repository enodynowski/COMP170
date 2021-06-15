public class Day_1_Practice
{
	public static void main(String[] args) 
	{
		int today;
		int tomorrow;
		String thisMonth;

		today = 24;
		tomorrow = today + 1;
		thisMonth = "May ";
		// This is parts a and c
		System.out.println("Hello, World \nWelcome, Eno" + "\nToday is " + thisMonth + today + "\nTomorrow will be " + thisMonth + tomorrow);
		if (today > 20) {
			System.out.println("Hooray! " + thisMonth + "is almost over!");
		} else {
			System.out.print("Oh well, there's still some of " + thisMonth);
		}
		// This is part b
		System.out.println("I grew up in Evanston, but now I live in Edgewater");
	}


}
