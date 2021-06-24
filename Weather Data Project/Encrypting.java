import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Encrypting{
   public static void main(String [] args) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, 
   BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, FileNotFoundException{
        Scanner fileInput = new Scanner (new File ("/Users/enodynowski/Desktop/URL.txt"));
        apiKeyEncrypting();

   }
   public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
      keyGenerator.init(n);
      SecretKey key = keyGenerator.generateKey();
      return key;
  }

  public static IvParameterSpec generateIv() {
   byte[] iv = new byte[16];
   new SecureRandom().nextBytes(iv);
   return new IvParameterSpec(iv);
}

public static String encrypt(String algorithm, String input, SecretKey key,
    IvParameterSpec ivParameterSpec) throws NoSuchPaddingException, NoSuchAlgorithmException,
    InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException {
    
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
    byte[] cipherText = cipher.doFinal(input.getBytes());
    return Base64.getEncoder()
        .encodeToString(cipherText);
}

public static String decrypt(String algorithm, String cipherText, SecretKey key,
    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
    InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException {
    
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.DECRYPT_MODE, key, iv);
    byte[] plainText = cipher.doFinal(Base64.getDecoder()
        .decode(cipherText));
    return new String(plainText);
}

static void apiKeyEncrypting()
    throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
    BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException { 
        String input = "iMue2MKkV2xhk5Xi5ABDAqUSvM4MvU5W";
        SecretKey key = Encrypting.generateKey(128);
        IvParameterSpec ivParameterSpec = Encrypting.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = Encrypting.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = Encrypting.decrypt(algorithm, cipherText, key, ivParameterSpec);
        System.out.println(cipherText);
        System.out.println(plainText);

   
   }
}