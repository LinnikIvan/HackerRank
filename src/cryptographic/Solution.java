package cryptographic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String string = new Scanner(System.in).nextLine();
        System.out.println(getEncryptionValue(string, "SHA-256"));
        System.out.println(getEncryptionValue(string, "MD5"));
    }

    private static String getEncryptionValue(String value, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(value.getBytes());

        StringBuilder builder = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                builder.append('0');
            }
            builder.append(hex);
        }

        return builder.toString();
    }
}