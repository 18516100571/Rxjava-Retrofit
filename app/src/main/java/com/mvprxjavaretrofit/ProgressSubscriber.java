package com.mvprxjavaretrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import rx.Subscriber;

/**
 * Created by Avazu Holding on 2017/12/29.
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancleListener{

    private SubscriberOnNextListener mSubscriberOnNextListener;
    private Context context;
    private ProgressDialogHandler progressDialogHandler;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener,Context context) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
        progressDialogHandler = new ProgressDialogHandler(context,true,this);
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    private void showProgressDialog() {
        if(progressDialogHandler!= null){
            progressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();

        }
    }

    @Override
    public void onCompleted() {
        dismissDialog();
        Toast.makeText(context, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
    }

    private void dismissDialog() {
        if(progressDialogHandler!= null){
            progressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();

        }
    }

    @Override
    public void onError(Throwable e) {
        dismissDialog();
        Log.d("ResultBody-Luoyu---==",new Gson().toJson(e));
        Toast.makeText(context, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(Object o) {
        Log.d("ResultBody-Luoyu---==",new Gson().toJson(o));
        mSubscriberOnNextListener.onNext(o);

    }

    @Override
    public void cancleProgressDialog() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
