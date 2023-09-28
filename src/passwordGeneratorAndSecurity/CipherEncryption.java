package passwordGeneratorAndSecurity;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Scanner;

public class CipherEncryption extends PasswordGenerator{

        public static void main(String args[]) throws Exception {

            Scanner scanner = new Scanner(System.in);

            String password;

            System.out.println("Enter password");
            password = scanner.nextLine();

            //Creating a Signature object

            Signature sign = Signature.getInstance("SHA256withRSA");

            //Creating KeyPair generator object
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

            //Initializing the key pair generator
            keyPairGen.initialize(678);

            //Generating the pair of keys
            KeyPair pair = keyPairGen.generateKeyPair();

            //Creating a Cipher object
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            //Initializing a Cipher object
            cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

            //Adding data to the cipher
            byte[] input = password.getBytes();
            cipher.update(input);

            //encrypting the data
            byte[] cipherText = cipher.doFinal();
            System.out.println(new String(cipherText, "UTF8"));

            System.out.println("=========================================");

            cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

            //Decrypting the text
            byte[] decipheredText = cipher.doFinal(cipherText);
            System.out.println(new String(decipheredText));

        }
}
