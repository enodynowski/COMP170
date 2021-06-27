public class Template {
	public static void main(String[] args) {

		System.out.println(digitRange(68430));
		System.out.println(digitRange(131913));
		System.out.println(digitRange(31));
		System.out.println(digitRange(5));
		}


	public static int digitRange(int num) {

		int min;
		min = 10;
		int max;
		max = 0;
		if (num / 10 == 0) {
			return 1;
		}
		while (num != 0) {
			int digits;
			digits = num % 10;
			num = num / 10; // used to get largest number. Once largest number is found, moves on to smallest number
			if (digits > max){
				max = digits;
			}
			else if (digits < min){ // to get smallest number
				min = digits;
			}
		}
		return max - min + 1;
		}

}
