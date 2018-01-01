package com.example.demo.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by qiang on 2017/12/14.
 */
public class StringUtils {
    /**
     * StringUtils工具类方法
     * 获取一定长度的随机字符串，范围0-9，a-z
     * @param length：指定字符串长度
     * @return 一定长度的随机字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomString(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static boolean isNotEmpty(String object){
        if(object!=null && !"null".equals(object) && !"".equals(object)){
            return true;
        }else {
            return false;
        }
    }
}
