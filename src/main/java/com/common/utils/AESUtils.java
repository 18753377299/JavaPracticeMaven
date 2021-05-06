package com.common.utils;

import com.google.gson.Gson;
//import com.sinosoft.credit.utils.vo.AESDataVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Arrays;

/**
 * AES加密
 * @version 1.0
 * @create 2021-04-04 16:08
 * @update 2021-04-04 16:08
 */
public class AESUtils {
    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     */
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";
//    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static byte[] keyFormat(String key) {
        byte[] keyBytes = key.getBytes();
        //java不支持pkcs7 补齐方式，因此需要人为补齐
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());

        return keyBytes;
    }

    /**
     * 用于加密操作
     * @param source 源数据
     * @param encodeing 编码格式
     * @return 加密后16进制结果
     */
    /*public static String encryptAll(String source,String encodeing){
        Gson gson = new Gson();
        byte[] encr = encrypt(source,"输入自己的密文",encodeing);
        String encrStr = ParseSystemUtil.parseByte2HexStr(encr);
        AESDataVo vo = new AESDataVo();
        vo.setData(encrStr);
        return gson.toJson(vo);
    }*/

    /**
     * AES 加密操作
     *
     * @param source 待加密内容
     * @param key    加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static byte[] encrypt(String source, String key,String encodeing) {
        try {
            byte[] sourceBytes = source.getBytes(encodeing);
            byte[] keyBytes = keyFormat(key);
            SecretKeySpec sKey = new SecretKeySpec(keyBytes, CIPHER_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            byte[] decrypted = cipher.doFinal(sourceBytes);
            return decrypted;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "err".getBytes();
    }

    /**
     * AES 加密操作
     *
     * @param source 待加密内容
     * @param key    加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static byte[] encrypt(String source, String key) {
        try {
            byte[] sourceBytes = source.getBytes("UTF-8");
            byte[] keyBytes = keyFormat(key);
            SecretKeySpec sKey = new SecretKeySpec(keyBytes, CIPHER_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            byte[] decrypted = cipher.doFinal(sourceBytes);
            return decrypted;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "err".getBytes();
    }

    /**
     * 解密
     * @param content 字符串内容
     * @param encoding 解密后的字符编码
     * @return 解密后的字符串
     */
    /*public static String decryptAll(String content,String encoding){
        Gson gson = new Gson();
        AESDataVo vo = gson.fromJson(content, AESDataVo.class);
        byte[] cont = ParseSystemUtil.parseHexStr2Byte(vo.getData());
        String decr = decrypt(cont, "输入自己的密文",encoding);
        return decr;
    }*/

    /**
     * AES 解密操作
     *
     * @param content 内容
     * @param key
     * @param encoding 编码方式
     * @return 解密后字符串
     */
    public static String decrypt(byte[] content, String key,String encoding) {
        try {
            byte[] keyBytes = keyFormat(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, KEY_ALGORITHM));
            byte[] decoded = cipher.doFinal(content);
            return new String(decoded, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return "err";
    }
    /**
     * AES 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(byte[] content, String key) {
        try {
            String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

            byte[] keyBytes = keyFormat(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, KEY_ALGORITHM));
            byte[] decoded = cipher.doFinal(content);
            return new String(decoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return "err";
    }
    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    @ApiOperation(value="base64转码")
    public static byte [] base64Decode(String base64Decode){
        return Base64.decodeBase64(base64Decode);
    }

    @ApiOperation(value="base64解码")
    public static String base64Encode(byte [] bytes){
        return Base64.encodeBase64String(bytes);
    }

    public static void main(String[] args) {
//        String ss = "{\"managercode\":\"12346\",\"managername\":\"请求\"}";
        String ss ="Fcfk2021";
        byte[] jiami = encrypt(ss,"abcdefgabcdefg1");
//        byte[] jiami = encrypt(ss,"123456789","ISO-8859-1");
//        byte[] jiami = encrypt(ss,"123456789","GBK");
//        System.out.println("加密："+new String(jiami));
        //传输过程,不转成16进制的字符串，就等着程序崩溃掉吧
//        String code = parseByte2HexStr(jiami);
        String code = base64Encode(jiami);

        System.out.println("密文字符串：" + code);
        code ="m7FuzmoDefzAiVC2zMwXMQ==";
//        code ="2293f1ef60cb77b7990c41bdd0f56095";

//        byte[] decode = parseHexStr2Byte(code);
        byte[] decode =  base64Decode(code);
        // 解密
//        byte[] decryptResult = decrypt(decode, "123456789");
//        System.out.println("解密后：" + new String(decryptResult, "UTF-8")); //不转码会乱码
//        String hex = ParseSystemUtil.parseByte2HexStr(jiami);
//        System.out.println("16:"+hex);
//        String jiemi = decrypt(decode,"abcdefgabcdefg12");
        String jiemi = decrypt(decode,"R2iskC0onT2rol18");
        System.out.println("解密："+jiemi);
        String jmm = "624e6341706b455a7a6a4a7148654b4c7045454755584355385143316a365534524a484e6963547a504c773d0a";
//        byte[] two = ParseSystemUtil.parseHexStr2Byte(jmm);
        String an = "bNcApkEZzjJqHeKLpEEGUXCU8QC1j6U4RJHNicTzPLw=";
//        String jmi = decrypt(an.getBytes(),"123456789");
//        System.out.println("解密2："+jmi);
    }
}
