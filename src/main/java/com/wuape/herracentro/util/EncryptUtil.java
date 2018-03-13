package com.wuape.herracentro.util;

import org.springframework.util.DigestUtils;

public class EncryptUtil {


    public static String convertToMd5(String text){
        return new String(DigestUtils.md5Digest(text.getBytes()));
    }
}
