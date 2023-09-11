package com.zpark.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

/**
 * MD5 加密算法
 */
public class MD5 {

    private static MessageDigest messageDigest;

    private MD5(){
        throw new AssertionError("No com.zpark.utils.MD5 instance for you");
    }

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    /**
     * MD5密码加密
     * @param password 用户传来要加密的明文
     * @return 加密后的密文
     */
    public static String encrypt(String password){
        Objects.requireNonNull(password);
        //随机盐 12位数组
        byte[] salt = new byte[12];
        //获取密码的byte数组
        byte[] bytes = password.getBytes();
        //生成12位随机盐
        new SecureRandom().nextBytes(salt);
        //将盐拿去加密
        messageDigest.update(salt);
        //将密码拿去加密
        messageDigest.update(bytes);
        //得到md5算法加密后的byte数组
        byte[] digest = messageDigest.digest();
        //将 明文盐和加密后的盐密码数组 组合到一起
        byte[] encryptBytes = new byte[12 + digest.length];

        System.arraycopy(salt, 0, encryptBytes, 0, 12);
        System.arraycopy(digest, 0, encryptBytes, 12, digest.length);

        return Base64.getEncoder().encodeToString(encryptBytes);
    }


    /**
     * 验证密码
     * @param password 用户传进来的密码
     * @param encrty 数据库里要比对的加密密文
     * @return 比对是否成功
     */
    public static boolean validate(String password, String encrty){
        //非空检查
        Objects.requireNonNull(password);
        Objects.requireNonNull(encrty);

        //将加密字符串转成byte数组
        byte[] decode = Base64.getDecoder().decode(encrty);
        //取出前12位随机盐
        byte[] salt = Arrays.copyOf(decode, 12);
        //取出后部分MD5加密后的 盐密码组合
        byte[] encryptBytes = Arrays.copyOfRange(decode, 12, decode.length);
        //加密盐
        messageDigest.update(salt);
        //加密密码
        messageDigest.update(password.getBytes());
        //得到MD5密码
        byte[] digest = messageDigest.digest();
        //比较当次加密和前次加密
        return Arrays.equals(encryptBytes, digest);
    }

}
