public class CaesarCipher
{
	public static void main(String[] args) 
	{
		encodePlainText();
	}
	public static void encodePlainText(){
		//Declaration of variables
		String plainText = "";
		StringBuilder cipherText = new StringBuilder();
		int key;
		char encodedChar;
		//take user input
		Scanner170 input = new Scanner170(System.in);
		System.out.print("Your message? ");
		plainText = input.nextLine();
		System.out.print("Encoding key? ");
		key = input.nextInt();

		for (int i = 0; i < plainText.length(); i++){
			char plainTextCharacters = plainText.charAt(i);
			if (plainTextCharacters != ' '){
				//converting to upper case
				char upperCasePTC = Character.toUpperCase(plainTextCharacters);
				//encoding uppercase plain text characters
				int encodedInt = (key + (int)upperCasePTC - 65) % 26;
				//converting encodedInt to a character
				encodedChar = (char) (encodedInt + 65);
			}
			else{
				encodedChar = ' ';
			}
			cipherText.append(encodedChar);
		}
		System.out.println("Your message "+ cipherText);
	}
}
