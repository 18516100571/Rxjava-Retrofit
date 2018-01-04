package com.mvprxjavaretrofit;

/**
 * Created by Avazu Holding on 2017/12/29.
 */

public class HttpUrlManager {
    public static boolean isDebug = true;

    public static final String ON_LINE = "api.sphere.moneyqwe";

    public static final String MOBILE_HOST = "118.193.21.62:924500";
//	public static final String MOBILE_HOST = "192.168.40.126:8081";


    //	public static final String DEVELOP_ENVIRONMENT = "172.16.16.216:9100";
    public static final String DEVELOP_ENVIRONMENT = "118.193.21.174:91450";

    public static String HTTPS = "https://";
    public static String HTTP = "http://";

    public static String getHttp(){
        if (isDebug) {
            return HTTP;
        } else {
            return HTTPS;
        }
    }

    public static String getHost() {
        if (isDebug) {
            return DEVELOP_ENVIRONMENT;
        } else {
            return ON_LINE;
        }
    }
    public static String getToken(){
        String host = getHost();
        return getHttp() + host + "/opay-server/api/getToken";
    }


}
