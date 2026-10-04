package com.mycompany.tap_u1p4_a.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 *
 * @author iscal
 */
public class HashService {
    public static String sha1Hash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            
            byte[] hashBytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Ensure two digits per byte
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
