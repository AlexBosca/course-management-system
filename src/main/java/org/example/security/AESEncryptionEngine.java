package org.example.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class AESEncryptionEngine implements EncryptionEngine {

    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    @Override
    public String encrypt(EncryptionPair pair) {
        try {
            prepareSecretKey(pair.getPreparedKey());
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(pair.getText().getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            // TODO: Log the exception
        }
        return null;
    }

    @Override
    public String decrypt(EncryptionPair pair) {
        try {
            prepareSecretKey(pair.getPreparedKey());
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(pair.getText())));
        } catch (Exception e) {
            // TODO: Log the exception
        }

        return null;
    }

    @Override
    public void prepareSecretKey(String preparedKey) {
        try {
            MessageDigest sha;
            key = preparedKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (Exception e) {
            // TODO: Log the exception
        }
    }
}
