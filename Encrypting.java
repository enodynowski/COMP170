import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Encrypting{
   public static void main(String [] args) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, FileNotFoundException
   {
        testEncrypting();

   }
    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException 
    {
        //creating and initializing the secret key that is used for the encryption
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public static IvParameterSpec generateIv() 
    {
        //specifying the parameters of the initialization vector
        //this is done by creating an array of 16 cryptographically secure randomized bytes
        byte[] iv = new byte[16];
        //using the SecureRandom class, which, similar to the Random class, generates pseudorandom numbers, but these are cryptographically secure
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static String encrypt(String algorithm, String input, SecretKey key, IvParameterSpec ivParameterSpec) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException 
    {
        //creating and initializing a new cipher with the specified algorithm. In this case AES 128 bit CBC
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
        //the doFinal method is the one that actually encrypts the input string's bytes 
        byte[] cipherText = cipher.doFinal(input.getBytes());
        //using the base64 class to encode the encrpyed bytes into a string
        return Base64.getEncoder()
            .encodeToString(cipherText);
    }

    public static String decrypt(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException 
    {
        //similar to above, creating and initializing a new cipher with the same algorithm as the encrypted bytes
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        //again, in this case the doFinal method decrypts the encoded bytes, and the base64 decoder changes the encoded string to its bytes 
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
            .decode(cipherText));
        return new String(plainText);
    }

    static void testEncrypting()throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException 
    { 
            //a test method, with a specified input string, encryption key, initialization vector, and AES CBC algorithm with the specific padding
            //such that the input string is exactly 128 bits
            String input = "Here's some text to be encrytped";
            SecretKey key = Encrypting.generateKey(128);
            IvParameterSpec ivParameterSpec = Encrypting.generateIv();
            String algorithm = "AES/CBC/PKCS5Padding";
            String cipherText = Encrypting.encrypt(algorithm, input, key, ivParameterSpec);
            String plainText = Encrypting.decrypt(algorithm, cipherText, key, ivParameterSpec);
            
            System.out.println(plainText);
            System.out.println(cipherText);
   }
}