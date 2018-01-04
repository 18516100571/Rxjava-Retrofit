package com.mvprxjavaretrofit;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.Log;

import com.google.gson.Gson;
import com.mvprxjavaretrofit.service.MyService;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.mvprxjavaretrofit.MyApplication.context;

/**
 * Created by Avazu Holding on 2017/12/26.
 */

public class HttpMothed {
    private  String BASEURL = HttpUrlManager.getHttp()+HttpUrlManager.getHost();
    public Retrofit retrofit;
    public MyService service;
    private static final int DEFAULT_TIMEOUT = 5;




    private HttpMothed(){
        //手动创建一个okHttpClien设置超时shijian
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            retrofit = new Retrofit.Builder().client(httpClient.build()).addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(BASEURL).build();
            service = retrofit.create(MyService.class);

    }
    //在访问HttpMethods时创建单例

    private static class SingletonHolder{
        private static final HttpMothed INSTANCE = new HttpMothed();

    }
    public static HttpMothed getInstance(){

        return SingletonHolder.INSTANCE;
    }
    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<BaseResult<T>,T>{


        @Override
        public T call(BaseResult<T> tBaseResult) {
            if(!tBaseResult.headers.tranStatus){
//                throw new ApiException(tBaseResult.headers.errorCode);
                throw new ApiException(tBaseResult.headers.errCode+tBaseResult.headers.errMsg);

            }
            return tBaseResult.body;
        }
    }

//需要请求Token的接口这样处理
    public void doLogin(final Context context,final Subscriber<BaseResult<LoginResult>> subscriber, final String name, final BaseRequest body){
        BaseRequest tokenBody = new BaseRequest( context,null);
        Log.d("RequestBody-Luoyu---==",new Gson().toJson(body).toString());
        Observable observable = service.getToken("getToken", tokenBody)
                .flatMap(new Func1<BaseResult<getTokenResult>, Observable<?>>() {
                    @Override
                    public Observable<?> call(BaseResult<getTokenResult> getTokenResultBaseResult) {
                        if(getTokenResultBaseResult.headers.tranStatus){
                            DataUtils.setToken(context,getTokenResultBaseResult.body.token);
                            return service.Login(name, body)
                                    .map(new HttpResultFunc<LoginResult>());
                        }else{
                            throw new ApiException(getTokenResultBaseResult.headers.errCode+getTokenResultBaseResult.headers.errMsg);
                        }

                    }
                });
        toSubscribe(observable,subscriber);
//        .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//                .map(new HttpResultFunc<getTokenResult>())
//        toSubscribe(observable,subscriber);

    }
    //不需要的直接如此处理
    public void doLogin(Subscriber<BaseResult<LoginResult>> subscriber,String name,BaseRequest body){
        Log.d("RequestBody-Luoyu---=="+name,new Gson().toJson(body).toString());
        Observable observable = service.Login(name, body)
                .map(new HttpResultFunc<LoginResult>());
        toSubscribe(observable,subscriber);

    }



    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
