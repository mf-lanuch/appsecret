package com.app.secret.core.util;

import com.app.secret.entity.AppUsers;
import com.app.secret.entity.TokenUsers;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class TokenUtil {

    public static TokenUsers genderToken(AppUsers users){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = JWT.create().withAudience(users.getUuid()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(users.getUserPswd()));
        return new TokenUsers(users.getUuid(), users.getUserName(), token);
    }

    public final static String getMD5(String s) {
        if(s==null){
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    public final static String genUUID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String []agrs) {
        System.out.println(getMD5("admin"));
    }

}
