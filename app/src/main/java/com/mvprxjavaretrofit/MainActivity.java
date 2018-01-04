package com.mvprxjavaretrofit;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private Button button;
//    private MyManager myManager;
    private Subscriber<BaseResult<LoginResult>> subscriber;
    private SubscriberOnNextListener<getTokenResult> getTokenNext;
    private SubscriberOnNextListener doLoginNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
//        myManager = new MyManager(this);
//        getTokenNext = new SubscriberOnNextListener<getTokenResult>() {
//            @Override
////            public void onNext(getTokenResult o) {
//                DataUtils.setToken(MainActivity.this,o.token);
//                LoginRequest map = new LoginRequest();
//                    map.setLoginType(DataUtils.encode(String.valueOf(1)));
//                    map.setMobilePrefix("+86");
//                    map.setMobile(DataUtils.encode("18516100571"));
////                    map.set("email", DataUtils.encode(""));
////                    map.put("loginId", DataUtils.encode(""));
////                    map.put("smsCode",DataUtils.encode(""));
//                    map.setPassword(DataUtils.encode(DataUtils.shaEncrypt("12345abcde")));
//
//                BaseRequest body = new BaseRequest(MainActivity.this,map);
//                HttpMothed.getInstance().doLogin(new ProgressSubscriber(doLoginNext,MainActivity.this),"login",body);
//
//            }
//        };
        doLoginNext = new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                JSONObject map = new JSONObject();
//                try {
//                    map.put("loginType",DataUtils.encode(String.valueOf(1)));
//                    map.put("mobilePrefix", "+86");
//                    map.put("mobile", DataUtils.encode("18516100571"));
//                    map.put("email", DataUtils.encode(""));
//                    map.put("loginId", DataUtils.encode(""));
//                    map.put("smsCode",DataUtils.encode(""));
//                    map.put("password", DataUtils.encode(DataUtils.shaEncrypt("12345abcde")));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                DataUtils.setToken(MainActivity.this,o.token);
                LoginRequest map = new LoginRequest();
                map.setLoginType(DataUtils.encode(String.valueOf(1)));
                map.setMobilePrefix("+86");
                map.setMobile(DataUtils.encode(""));
//                    map.set("email", DataUtils.encode(""));
//                    map.put("loginId", DataUtils.encode(""));
//                    map.put("smsCode",DataUtils.encode(""));
                map.setPassword(DataUtils.encode(DataUtils.shaEncrypt("")));

                BaseRequest body = new BaseRequest(MainActivity.this,map);

                HttpMothed.getInstance().doLogin(MainActivity.this,new ProgressSubscriber(doLoginNext,MainActivity.this),"",body);
            }
        });


    }


}
