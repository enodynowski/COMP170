public class Pow {
	public static void main(String[] args) {
		System.out.println(pow(3, 4));
	}

	public static int pow(int base, int exponent) {
		int result = 1;
		while (exponent > 0) {
			result *= base;
			exponent--;

		}
		return result;
	}
}
