package com.mvprxjavaretrofit;

import android.content.Context;

import com.mvprxjavaretrofit.service.MyService;

import java.util.Map;

import rx.Observable;


/**
 * Created by Avazu Holding on 2017/12/13.
 */

public class MyManager {
    private MyService myService;


    public MyManager(Context context){
        myService = RetrofitHelper.getInstance(context).getServer();
    }

//   public Observable<BaseResult<LoginResult>> doLogin(String name,Map map){
//        return myService.htpPost(name,map);
//
//    }


}
