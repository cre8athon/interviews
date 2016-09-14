package com.amazon.decryption;

import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by gnowakow on 9/13/16.
 */
public class EncryptDecrypt {

        public static String encrypt(String key, String initVector, String value) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

                byte[] encrypted = cipher.doFinal(value.getBytes());
                System.out.println("encrypted string: "
                        + Base64.encodeBase64String(encrypted));

                return Base64.encodeBase64String(encrypted);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        public static String decrypt(String key, String initVector, String encrypted) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

                byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

                return new String(original);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        public static void main(String[] args) {
            String key = "Bar12345Bar12345"; // 128 bit key
            String initVector = "RandomInitVector"; // 16 bytes IV

            String message = "rO0ABXNyACZjb20uYW1hem9uLmNvcmFsLmVudmVsb3BlLkVudmVsb3BlSW1wbCNkqAHDWKltAwAJWgAFZGlydHlMAA5hZGFwdGVyRmFjdG9yeXQAKkxjb20vYW1hem9uL2NvcmFsL2VudmVsb3BlL0FkYXB0ZXJGYWN0b3J5O0wADmNvbnRlbnRzSG9sZGVydAAoTGNvbS9hbWF6b24vY29yYWwvZW52ZWxvcGUvT2JqZWN0SG9sZGVyO0wAB2NvbnRleHR0ACRMY29tL2FtYXpvbi9jb3JhbC9zZXJpYWxpemUvQ29udGV4dDtMAAJpZHQAJExjb20vYW1hem9uL2NvcmFsL3NjaGVtYS9JZGVudGlmaWVyO0wABWluZGV4dAApTGNvbS9hbWF6b24vY29yYWwvZW52ZWxvcGUvRW52ZWxvcGVJbmRleDtMABFzZXJpYWxpemVyRmFjdG9yeXQALkxjb20vYW1hem9uL2NvcmFsL3NlcmlhbGl6ZS9TZXJpYWxpemVyRmFjdG9yeTtMAAx3aXJlRW52ZWxvcGV0AChMY29tL2FtYXpvbi9jb3JhbC9lbnZlbG9wZS9XaXJlRW52ZWxvcGU7TAAYd3JhcHBlclNlcmlhbGl6ZXJGYWN0b3J5cQB+AAZ4cHoAAAL3AVMAAAAEanNvbkkAAAAlY29tLmFtYXpvbi5hdWRpYmxlc3RhdHMjQ3VzdG9tZXJTdGF0c1AAAAK+eyJTdGF0cyI6W3siYXNpbiI6IkIwMUU5RkhORU0iLCJhc2luX293bmVkIjp0cnVlLCJib29rbWFya19wb3NpdGlvbiI6MCwiY29udGVudF9kaXNjb3Zlcnlfc291cmNlIjpudWxsLCJkZWxpdmVyeV90eXBlIjoiRG93bmxvYWQiLCJldmVudF9lbmRfcG9zaXRpb24iOjAsImV2ZW50X2VuZF90aW1lc3RhbXAiOiIyMDE2LTA5LTEzVDA3OjQwOjU5WiIsImV2ZW50X3N0YXJ0X3Bvc2l0aW9uIjowLCJldmVudF90aW1lc3RhbXAiOiIyMDE2LTA5LTEzVDA3OjM4OjI5WiIsImV2ZW50X3R5cGUiOiJMaXN0ZW5pbmciLCJsZW5ndGhfb2ZfYm9vayI6NDY1MzI2OTYsImxpc3RlbmluZ19tb2RlIjpudWxsLCJsb2NhbF90aW1lem9uZSI6IkFtZXJpY2EvRGV0cm9pdCIsIm5hcnJhdGlvbl9zcGVlZCI6MS4wLCJwbGF5aW5nX2ltbWVyc2lvbl9yZWFkaW5nIjpmYWxzZSwic29jaWFsX25ldHdvcmtfc2l0ZSI6bnVsbCwic3RhdF9pZCI6IjdlMzZhMzdlLTc5ODUtMTFlNi04YzExLWIzYWM5Y2Y5NmFiNS0wIiwic3RvcmUiOiJBdWRpYmxlIiwic3Vic2NyaXB0aW9uX2lkIjpudWxsLCJ2ZXJzaW9uX29mX2FwcCI6IjIuNC4wIn1dLCJjdXN0b21lcklkIjoiQVFWWUZJRjRNUjFLQiIsImRldmljZUFjY291bnRJZCI6IkEyUEs5Q0wxQ05TMkhLIiwiZGV2aWNlVHlwZUlkIjoiQTEwS0lTUDJHV0YwRTQiLCJtYXJrZXRQbGFjZUlkIjoiQUYyTTBLQzk0UkNFQSJ9eA==\\\",\\n  \\\"Timestamp\\\" : \\\"2016-09-13T07:41:33.675Z\\\",\\n  \\\"SignatureVersion\\\" : \\\"1\\\",\\n  \\\"Signature\\\" : \\\"eouFwQe0VphjGdlGLpZpL4KjGhuAp+heRaQV5icU3BU5idsdhR+mxPp3o9R435xR8Uivi5LeojcR1jD1mxp0lsGBjfYJKmBlleh1SlkeLhph9b1EFWD677HGYzJDM2+qNyQz0uADG0LOAwiDFbbFf6oLtfUTo/34jVlZ0e9zap3aSefitqzK6wbm6mgdK/BKscXXfSziBVH10g8HM5vnvFhXr1442BaPLo86eqSQXHytDxwBj/3qdaK0eFJUxJiSRVFUELiIczuvfDlDwINX16RMLTVaBZYr+KA/B1pK+F2gXpe64nlGwui6f/c+rBMWxdUk3MSjwBExg8Jr6rjvaQ==";

            System.out.println(decrypt(key, initVector,
                    encrypt(key, initVector, "Hello World")));
        }
    }
