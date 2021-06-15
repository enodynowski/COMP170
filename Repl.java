public class Repl
{
	public static void main(String[] args) 
	{
		System.out.println(repl("ohgodwhy", 5));
	}
	public static String repl(String input, int repeat){
		String begin;
		begin = "";
		for (int i = 1; i <= repeat; i++){

			begin += input;
		}
		return begin;

	}
}
