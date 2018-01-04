package com.mvprxjavaretrofit;

/**
 * Created by Avazu Holding on 2018/1/2.
 */

public class LoginRequest {


    /**
     * loginId :
     * mobilePrefix : +86
     * password : 3c373f4953b85cdea588e0436c134c819f570b72c1db740eb35cfc942baa2bce
     * smsCode :
     * email :
     * loginType : 1
     * mobile : 18516100571
     */

    private String loginId;
    private String mobilePrefix;
    private String password;
    private String smsCode;
    private String email;
    private String loginType;
    private String mobile;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getMobilePrefix() {
        return mobilePrefix;
    }

    public void setMobilePrefix(String mobilePrefix) {
        this.mobilePrefix = mobilePrefix;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
