package com.mvprxjavaretrofit;


/**
 * Created by Avazu Holding on 2017/12/13.
 */

public class BaseResult<T> {
    public Headers headers;
    public T body;

    public class Headers{
        public String errMsg;
        public String errCode;
        public boolean tranStatus;

    }

}
