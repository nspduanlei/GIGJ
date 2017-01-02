package com.app.gigj.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MS5
 */
public class MD5Util {
//    private static final String TAG = MD5Util.class.getSimpleName();
//    private static final int STREAM_BUFFER_LENGTH = 1024;
//
//    public static MessageDigest getDigest(final String algorithm) throws NoSuchAlgorithmException {
//        return MessageDigest.getInstance(algorithm);
//    }
//
//    public static byte[] md5(String txt) {
//        return md5(txt.getBytes());
//    }
//
//    public static String getMd5UserId(String userId) {
//        return new String(md5(userId + "($_$)Glgj($_$)"));
//    }
//
//    public static String getPassword(String password) {
//        return new String(md5(password + "$$ht_zx$$"));
//    }
//
//    public static byte[] md5(byte[] bytes) {
//        try {
//            MessageDigest digest = getDigest("MD5");
//            digest.update(bytes);
//            return digest.digest();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static byte[] md5(InputStream is) throws NoSuchAlgorithmException, IOException {
//        return updateDigest(getDigest("MD5"), is).digest();
//    }
//
//    public static MessageDigest updateDigest(final MessageDigest digest, final InputStream data) throws IOException {
//        final byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
//        int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
//
//        while (read > -1) {
//            digest.update(buffer, 0, read);
//            read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
//        }
//
//        return digest;
//    }

    private static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        //StringBuilder hex = new StringBuilder(hash.length * 2);
        StringBuilder hex = new StringBuilder(hash.length);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString().substring(8,24);
    }

    public static String getMd5UserId(String userId) {
        return md5(userId + "($_$)Glgj($_$)");
    }

    public static String getPassword(String password) {
        return md5(password + "$$ht_zx$$");
    }
}
