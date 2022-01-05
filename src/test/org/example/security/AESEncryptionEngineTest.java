package org.example.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AESEncryptionEngineTest {

    private final AESEncryptionEngine aesEncryptionEngine = new AESEncryptionEngine();

    // To add setUp method for testing the encryption and decryption

    @Test   // To split into 2 tests
    void encryptAndDecrypt() {
        String stringToEncrypt = "String for encryption";
        String preparedKey = "SecretKey";

        EncryptionPair pairToEncrypt = new EncryptionPair.Builder(preparedKey).withText(stringToEncrypt).build();
        String encryptedString = aesEncryptionEngine.encrypt(pairToEncrypt);

        EncryptionPair pairToDecrypt = new EncryptionPair.Builder(preparedKey).withText(encryptedString).build();
        String decryptedString = aesEncryptionEngine.decrypt(pairToDecrypt);

        assertEquals(stringToEncrypt, decryptedString);
    }

//    @Test
//    void prepareSecretKey() {
//    }
}