package com.example.safeyapp.utils;

import android.os.Message;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 似水流年 on 2016/5/17.
 */
public class MD5Utils {
    // 0-9 a-f
    public  static  String  encode(String password){
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(password.getBytes());
            for (byte b : bytes){
                //ff ff ff a1
                int c = b & 0xff;
                String hexString = Integer.toHexString(c);
                System.out.println(hexString);
                if (hexString.length() == 1){
                    hexString = 0 + hexString;
                }
                sb.append(hexString);
            }



        } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
            e.printStackTrace();
        }

               return sb.toString();
    }
}
