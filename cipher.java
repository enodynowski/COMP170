public class cipher {
    public static void main(String [] args){
        String input = "DPEPN LDECZYZXJ XPLYD EZZ XLYJ DPNCPED";
        decode(input);
    }
    public static void decode(String input){
        char decodedChar;
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            char cipherTextChar = input.charAt(i);

            if (cipherTextChar != ' '){
                char upperCipherTextChar = Character.toUpperCase(cipherTextChar);
                int decodedInt = (15)+((int)upperCipherTextChar) % 26;
                decodedChar = (char) (decodedInt);
            }
            else {
                decodedChar = ' '; 
            }
            plainText.append(decodedChar);
        }
        System.out.println(plainText);
    }
}