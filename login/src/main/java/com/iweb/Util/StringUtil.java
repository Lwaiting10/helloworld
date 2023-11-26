package com.iweb.Util;

import java.util.Random;

/**
 * @author Liu Xiong
 * @date 10/11/2023 下午2:18
 */
public class StringUtil {
    private static final String STR_POOL = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static final Random RANDOM = new Random();

    public static String getCaptchaCode() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = RANDOM.nextInt(3) + 4;
        for (int i = 0; i < count; i++) {
            stringBuilder.append(STR_POOL.charAt(RANDOM.nextInt(STR_POOL.length())));
        }
        return stringBuilder.toString();
    }

}
