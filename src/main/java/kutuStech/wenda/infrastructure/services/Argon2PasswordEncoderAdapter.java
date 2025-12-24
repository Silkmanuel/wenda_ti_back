package kutuStech.wenda.infrastructure.services;
import java.security.SecureRandom;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;


import kutuStech.wenda.adapters.output.config.PasswordEncodePort;

@Component
public class Argon2PasswordEncoderAdapter implements PasswordEncodePort{

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?";
    private static final String ALL = UPPER + LOWER + DIGITS + SYMBOLS;
    private static final int SIZE = 8;


    private final Argon2PasswordEncoder argon2PasswordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public String encode(String rawPassord) {
        return argon2PasswordEncoder.encode(rawPassord);
    }

    @Override
    public Boolean matches(String rawPassord, String encodePassword) {
        return argon2PasswordEncoder.matches(rawPassord, encodePassword);
    }

    @Override
    public String generatePasword() {
        StringBuilder password = new StringBuilder(SIZE);
        password.append(UPPER.charAt(RANDOM.nextInt(UPPER.length())));
        password.append(LOWER.charAt(RANDOM.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        password.append(SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length())));
        for (int i = 4; i < SIZE; i++) {
            password.append(ALL.charAt(RANDOM.nextInt(ALL.length())));
        }
        return password.toString();
    }

    
}
