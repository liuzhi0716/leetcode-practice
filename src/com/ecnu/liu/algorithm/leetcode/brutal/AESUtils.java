package com.ecnu.liu.algorithm.leetcode.brutal;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

    private static final String ALGORITHM_CFB = "AES";

    private static final String CIPHER_ALGORITHM_AES_CFB = "AES/ECB/PKCS5Padding";

    private static final String CHARSET_NAME = "utf-8";

    //secret长度必须为16
    public static void main (String[] args) {
        String encrypt = encrypt("123", "MTnextpms-pmsops");
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt, "MTnextpms-pmsops");
        System.out.println(decrypt);
    }

    /**
     * @param plainText 需要加密的明文, 如果为空, 则返回原值
     * @param secret    加密密钥, 不能为空
     * @return BASE64编码后的密文字符串
     */
    public static String encrypt (String plainText, String secret) {

        if (plainText == null || "".equals(plainText)) {
            return plainText;
        }
        try {
            Cipher aesCipher = Cipher.getInstance(CIPHER_ALGORITHM_AES_CFB);
            byte[] plainArray = plainText.getBytes(CHARSET_NAME);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(CHARSET_NAME), ALGORITHM_CFB);

            aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] doFinal = aesCipher.doFinal(plainArray);
            return new BASE64Encoder().encode(doFinal);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @param secureText 需要解密的密文, 如果为空, 则返回原值
     * @param secret     加密密钥, 不能为空
     * @return 解密后的明文
     */
    public static String decrypt (String secureText, String secret) {
        if (secureText == null || "".equals(secureText)) {
            return secureText;
        }
        try {
            byte[] secureArray = new BASE64Decoder().decodeBuffer(secureText);
            if (secureArray == null || secureArray.length == 0) {
                return secureText;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(CHARSET_NAME), ALGORITHM_CFB);
            Cipher AesCipher = Cipher.getInstance(CIPHER_ALGORITHM_AES_CFB);
            AesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] doFinal = AesCipher.doFinal(secureArray);
            return new String(doFinal);
        } catch (Exception e) {
            return "";
        }
    }
}
