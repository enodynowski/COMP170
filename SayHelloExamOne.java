import java.util.Scanner;

public class SayHelloExamOne {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("please enter a value");
		int value = input.nextInt();
		sayHello(value);
		input.close();
	}
	public static void sayHello (int value){
		for (int i = 1; i <= value/2; i++){
			System.out.println("Hello There!");
		}

	}
}
