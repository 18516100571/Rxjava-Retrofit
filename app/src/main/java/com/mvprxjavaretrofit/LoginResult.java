package com.mvprxjavaretrofit;

/**
 * Created by Avazu Holding on 2017/12/13.
 */

public class LoginResult {

    /**
     * body : {"userId":"0000099351","defaultCurrency":"SGD","loginId":null,"mobilePrefix":"+86","mobile":"18516100571","email":null,"countryCode":"CN","userThumbnail":null,"userStatus":"N","acctStatus":"0","isPasswordSetting":"Y","isBindCard":"Y","balance":"1833.97","frozenBalance":"606.00","canUseBalance":"1227.97","refreshToken":"69BF89397A7C4A99819744A8F13CD508","accessToken":"B320442A061A48B0BF564A142D4DD2EB"}
     * headers : {"tranStatus":true,"errCode":null,"errMsg":null}
     */

        /**
         * userId : 0000099351
         * defaultCurrency : SGD
         * loginId : null
         * mobilePrefix : +86
         * mobile : 18516100571
         * email : null
         * countryCode : CN
         * userThumbnail : null
         * userStatus : N
         * acctStatus : 0
         * isPasswordSetting : Y
         * isBindCard : Y
         * balance : 1833.97
         * frozenBalance : 606.00
         * canUseBalance : 1227.97
         * refreshToken : 69BF89397A7C4A99819744A8F13CD508
         * accessToken : B320442A061A48B0BF564A142D4DD2EB
         */

        private String userId;
        private String defaultCurrency;
        private Object loginId;
        private String mobilePrefix;
        private String mobile;
        private Object email;
        private String countryCode;
        private Object userThumbnail;
        private String userStatus;
        private String acctStatus;
        private String isPasswordSetting;
        private String isBindCard;
        private String balance;
        private String frozenBalance;
        private String canUseBalance;
        private String refreshToken;
        private String accessToken;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getDefaultCurrency() {
            return defaultCurrency;
        }

        public void setDefaultCurrency(String defaultCurrency) {
            this.defaultCurrency = defaultCurrency;
        }

        public Object getLoginId() {
            return loginId;
        }

        public void setLoginId(Object loginId) {
            this.loginId = loginId;
        }

        public String getMobilePrefix() {
            return mobilePrefix;
        }

        public void setMobilePrefix(String mobilePrefix) {
            this.mobilePrefix = mobilePrefix;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Object getUserThumbnail() {
            return userThumbnail;
        }

        public void setUserThumbnail(Object userThumbnail) {
            this.userThumbnail = userThumbnail;
        }

        public String getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus;
        }

        public String getAcctStatus() {
            return acctStatus;
        }

        public void setAcctStatus(String acctStatus) {
            this.acctStatus = acctStatus;
        }

        public String getIsPasswordSetting() {
            return isPasswordSetting;
        }

        public void setIsPasswordSetting(String isPasswordSetting) {
            this.isPasswordSetting = isPasswordSetting;
        }

        public String getIsBindCard() {
            return isBindCard;
        }

        public void setIsBindCard(String isBindCard) {
            this.isBindCard = isBindCard;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getFrozenBalance() {
            return frozenBalance;
        }

        public void setFrozenBalance(String frozenBalance) {
            this.frozenBalance = frozenBalance;
        }

        public String getCanUseBalance() {
            return canUseBalance;
        }

        public void setCanUseBalance(String canUseBalance) {
            this.canUseBalance = canUseBalance;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
}
