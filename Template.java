public class Template {
    public static void main(){
        String input = "";
        decode(input);
    }
    public static void decode(String input){
        char decodedChar;
        for (int i = 0; i <= input.length(); i++){
            StringBuilder plainText = new StringBuilder();
            char cipherTextChar = input.charAt(i);

            if (cipherTextChar != ' '){
                char upperCipherTextChar = Character.toUpperCase(cipherTextChar);
                int decodedInt = (i * -1)+((int)upperCipherTextChar - 65) % 26;
                decodedChar = (char) (decodedInt + 65);
            }
            else {
                decodedChar = ' '; 
            }
            plainText.append(decodedChar);
        }
    }
}