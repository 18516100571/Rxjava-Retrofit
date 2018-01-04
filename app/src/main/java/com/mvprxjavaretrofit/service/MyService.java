package com.mvprxjavaretrofit.service;

import com.mvprxjavaretrofit.BaseRequest;
import com.mvprxjavaretrofit.BaseResult;
import com.mvprxjavaretrofit.HttpUrlManager;
import com.mvprxjavaretrofit.LoginResult;
import com.mvprxjavaretrofit.getTokenResult;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Avazu Holding on 2017/12/13.
 */

public interface MyService {
//    @FormUrlEncoded
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("/opay-server/api/{info}")
    Observable<BaseResult<getTokenResult>> getToken(@Path("info") String name, @Body BaseRequest body);
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("/opay-server/api/{info}")
    Observable<BaseResult<LoginResult>> Login(@Path("info") String name,@Body BaseRequest body);
}
