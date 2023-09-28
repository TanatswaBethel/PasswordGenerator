package passwordGeneratorAndSecurity;

import java.util.Random;

public class PasswordGenBackend {

    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBER = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()_-+=[]{};:'<>/?~";
    private final Random random;


    public PasswordGenBackend() {

        random = new Random();
    }

    public String generatePassword (int length, boolean includeUppercase, boolean includeLowerCase, boolean includeNumbers, boolean includeSpecialSymbols) {

        StringBuilder passwordBuilder = new StringBuilder();

        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPER_CHARACTERS;
        if(includeLowerCase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBER;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        for(int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());

            char randomChar = validCharacters.charAt(randomIndex);

            passwordBuilder.append(randomChar);

        }

        return passwordBuilder.toString();
    }

}
