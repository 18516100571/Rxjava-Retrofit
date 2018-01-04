package com.mvprxjavaretrofit;

import android.content.Context;

/**
 * Created by Avazu Holding on 2018/1/2.
 */

public class UserLogin
{

    public UserLogin(Context context, BodyBean body) {


        this.headers = new HeadersBean(DataUtils.encode(DataUtils.getOsVersion()),"1",DataUtils.getAccessToken(context),DataUtils.getToken(context)
                ,DataUtils.getDeviceID(context),DataUtils.encode("android"),DataUtils.getManufacturer());
        this.body = body;
    }

    /**
     * headers : {"deviceOs":"4.4.2","appChannel":"01","accessToken":"8318835D90CC4C56BB71CCD7D0D20294","token":"730557","deviceId":"352831060345610750a479eac3ac36d","deviceType":"android","deviceBrand":"samsung"}
     * body : {}
     */


    private HeadersBean headers;
    private BodyBean body;

    public HeadersBean getHeaders() {
        return headers;
    }

    public void setHeaders(HeadersBean headers) {
        this.headers = headers;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class HeadersBean {
        public HeadersBean(String deviceOs, String appChannel, String accessToken, String token, String deviceId, String deviceType, String deviceBrand) {
            this.deviceOs = deviceOs;
            this.appChannel = appChannel;
            this.accessToken = accessToken;
            this.token = token;
            this.deviceId = deviceId;
            this.deviceType = deviceType;
            this.deviceBrand = deviceBrand;
        }

        /**
         * deviceOs : 4.4.2
         * appChannel : 01
         * accessToken : 8318835D90CC4C56BB71CCD7D0D20294
         * token : 730557
         * deviceId : 352831060345610750a479eac3ac36d
         * deviceType : android
         * deviceBrand : samsung
         */


        private String deviceOs;
        private String appChannel;
        private String accessToken;
        private String token;
        private String deviceId;
        private String deviceType;
        private String deviceBrand;

        public String getDeviceOs() {
            return deviceOs;
        }

        public void setDeviceOs(String deviceOs) {
            this.deviceOs = deviceOs;
        }

        public String getAppChannel() {
            return appChannel;
        }

        public void setAppChannel(String appChannel) {
            this.appChannel = appChannel;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceBrand() {
            return deviceBrand;
        }

        public void setDeviceBrand(String deviceBrand) {
            this.deviceBrand = deviceBrand;
        }
    }

    public static class BodyBean {
    }
}
