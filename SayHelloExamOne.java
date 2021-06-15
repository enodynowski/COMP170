public class SayHelloExamOne {
	public static void main(String[] args) {

		Scanner170 input = new Scanner170(System.in);
		System.out.print("please enter a value");
		int value = input.nextInt();
		sayHello(value);
	}
	public static void sayHello (int value){
		for (int i = 1; i <= value/2; i++){
			System.out.println("Hello There!");
		}

	}
}
