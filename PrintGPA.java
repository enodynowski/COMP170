import java.util.Scanner;
public class PrintGPA {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		printGPA(console);

	}

	public static void printGPA(Scanner console) {
		String name;
		int tests, score;
		double total = 0.0;
		double avg = 0.0;
		System.out.print("Enter a student's record: ");
		name = console.next();
		tests = console.nextInt();
		for (int i =0; i< tests; i++){
			score = console.nextInt();
			total+= score;
		}
		if (tests > 0){
			avg = total/tests;
		}
		System.out.println(name + "'s grade is " + avg);
	}
}

