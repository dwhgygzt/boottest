/*
 . * File name：MD5Util.java
 . * Copyright：Copyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description：
 . * Author：bluce
 . * Change date：May 8, 2014
 . * Tracking form ID：
 . * Change request ID：
 . * Change content：
 */
package cn.guzt.boottest.util;


import org.springframework.util.StringUtils;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 *
 */
public class Md5Util {

    /**
     * 利用MD5进行加密
     * @param plainText 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encodeByMd5(String plainText) {
        if (StringUtils.isEmpty(plainText)){
            return "";
        }
        // 确定计算方法
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] digestBytes = digest.digest(plainText.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digestBytes.length * 2);
            for (byte digestByte : digestBytes) {
                int i = digestByte;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}