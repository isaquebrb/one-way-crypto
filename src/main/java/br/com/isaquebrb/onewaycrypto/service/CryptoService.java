package br.com.isaquebrb.onewaycrypto.service;

import br.com.isaquebrb.onewaycrypto.exception.CryptoException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptoService {

    public String encrypt(String originalString) {
        try {
            MessageDigest msgDigest = MessageDigest.getInstance("SHA3-256");
            byte[] hashBytes = msgDigest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new CryptoException("Couldn't encrypt the original string");
        }
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
