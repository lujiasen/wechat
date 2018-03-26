package com.ljs.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;  


public class SignUtil {
    public static void main(String[] args) {
     /*   String jsapi_ticket = "kgt8ON7yVITDhtdwci0qeS8Whh1euWUoAEv4JTErrfC7YKTbg4UMZkSzG-Y1ZBo4ntQvWnX1poiyiUtQEGXAMA";

        // 注意 URL 一定要动态获取，不能 hardcode
        String url = "http://api2.somur.com/weChat/wssys.html";
        Map<String, String> ret = sign(jsapi_ticket, url,"wx363def7ff51b50df");
        for (Map.Entry entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }*/
    	
    };
    /**
     * 
    * @param jsapi_ticket
    * @param url
    * @param appid
    * @return  
    * @Description: 返回map  
    * @author jiangpeng    
    * @date 2016-9-27 下午05:29:11  
    * @version V1.2
     */
    public static Map<String, String> sign(String jsapi_ticket, String url,String appid) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        ret.put("appid", appid);

        return ret;
    }
    
    
    /**
     * 
    * @param timestamp
    * @param nonce
    * @param token
    * @return  
    * @Description:获取signature 
    * @author jiangpeng    
    * @date 2016-10-12 上午11:27:09  
    * @version V1.2
     */
    public static String getSignature(String timestamp, String nonce,String token) {
    	String signature=null;
    	String[] arr = new String[]{timestamp,nonce,token};
    	//排序
    	Arrays.sort(arr);
    	String string1 = arr.toString();
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return signature;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
