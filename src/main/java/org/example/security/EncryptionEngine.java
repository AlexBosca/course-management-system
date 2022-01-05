package org.example.security;

public interface EncryptionEngine { // To refactor that class

    void prepareSecretKey(String preparedKey);
    String encrypt(EncryptionPair pair);
    String decrypt(EncryptionPair pair);

//    static String encryptPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest digester = MessageDigest.getInstance("SHA-256");
//
//        byte[] encodedHash = digester.digest(password.getBytes(StandardCharsets.UTF_8));
//
//        StringBuilder encryptedPassword = new StringBuilder(2 * encodedHash.length);
//
//        for(int i = 0; i < encodedHash.length; i++) {
//            String hexVal = Integer.toHexString(0xff & encodedHash[i]);
//
//            if(hexVal.length() == 1) {
//                encryptedPassword.append('0');
//            }
//
//            encryptedPassword.append(hexVal);
//        }
//
//        return encryptedPassword.toString();
//    }
}
