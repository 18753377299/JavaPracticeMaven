package com.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;


public class AESUtil {

    //key为16位
    private static String KEY = "_aes_secret_key_";

    private static String IV = "_aes_secret_iv__";

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     */
//    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";
    private static final String CIPHER_ALGORITHM = "AES/CBC/NoPadding";

    /**
     * 加密方法
     *
     * @param data 要加密的数据
     * @param key  加密key
     * @param iv   加密iv
     * @return 加密的结果
     * @throws Exception
     */
    public static String encrypt(String data, String key, String iv) throws Exception {
        try {
            // 初始化
            Security.addProvider(new BouncyCastleProvider());

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);//"算法/模式/补码方式"NoPadding PkcsPadding
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return new Base64().encodeToString(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密方法
     *
     * @param data 要解密的数据
     * @param key  解密key
     * @param iv   解密iv
     * @return 解密的结果
     * @throws Exception
     */
    public static String desEncrypt(String data, String key, String iv) throws Exception {
        try {
            // 初始化
            Security.addProvider(new BouncyCastleProvider());

            byte[] encrypted1 = new Base64().decode(data);
//            byte[] encrypted1 = parseHexStr2Byte(data);

//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM,"BC");

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(),KEY_ALGORITHM);
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,"utf-8");
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用默认的key和iv加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        return encrypt(data, KEY, IV);
    }

    /**
     * 使用默认的key和iv解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String data) throws Exception {
        return desEncrypt(data, KEY, IV);
    }
    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 测试
     */
    public static void main(String args[]) throws Exception {

        String test1 = "123456";
        String test = new String(test1.getBytes(), "UTF-8");
        String data = null;
        String key = KEY;
        String iv = IV;
        // /g2wzfqvMOeazgtsUVbq1kmJawROa6mcRAzwG1/GeJ4=
        data = encrypt(test, key, iv);
        System.out.println("数据：" + test);
        System.out.println("加密：" + data);
//        String result ="OnJ4xI17sBAJ1KcZBhOyQQ==";
        String result ="VHu6sPsOZrbAxxwB/+qYGw==";
//        byte[] decode = parseHexStr2Byte(result);
        String jiemi = desEncrypt(result, key, iv).trim();
        System.out.println("解密：" + jiemi);
    }
}
