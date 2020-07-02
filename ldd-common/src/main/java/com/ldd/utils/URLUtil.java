package com.ldd.utils;


import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author xiaoxiya
 * @date 2020/6/12 22:33
 * @describe
 */
public class URLUtil {

    public static String getPath(String uriStr) {
        URI url = null;
        try {
            url = new URI(uriStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return url.getPath();
    }
}
