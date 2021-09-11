import java.util.Scanner;
public class CaesarCipher
{
	public static void main(String[] args) 
	{
		decodeCipherText();
	}
	public static void decodeCipherText(){
		//Declaration of variables
		String CipherText = "";
		StringBuilder PlainText = new StringBuilder();
		int key;
		char encodedChar;
		//take user input
		Scanner input = new Scanner(System.in);
		System.out.print("Your message? ");
		CipherText = input.nextLine();
		System.out.print("Encoding key? ");
		key = input.nextInt();

		for (int i = 0; i < CipherText.length(); i++){
			char ciperTextCharacters = CipherText.charAt(i);
			if (ciperTextCharacters != ' '){
				//converting to upper case
				char upperCasePTC = Character.toUpperCase(ciperTextCharacters);
				//encoding uppercase plain text characters
				int encodedInt = (key + (int)upperCasePTC - 65) % 26;
				//converting encodedInt to a character
				encodedChar = (char) (encodedInt + 65);
			}
			else{
				encodedChar = ' ';
			}
			PlainText.append(encodedChar);
		}
		System.out.println("Your message is "+ PlainText);
		input.close();
	}
}
