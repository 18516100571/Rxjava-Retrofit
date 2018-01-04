package com.mvprxjavaretrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;


/**
 * Created by Avazu Holding on 2017/12/29.
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;

    private Context context;
    private boolean cancelable;
    private ProgressCancleListener mProgressCancelListener;

    public ProgressDialogHandler(Context context, boolean cancelable, ProgressCancleListener mProgressCancelListener) {
        super();
        this.context = context;
        this.cancelable = cancelable;
        this.mProgressCancelListener = mProgressCancelListener;
    }

    private void initProgressDialog() {
        if (pd == null) {
            pd = new ProgressDialog(context);
        }
        pd.setCancelable(cancelable);
        if (cancelable) {
            pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mProgressCancelListener.cancleProgressDialog();
                }
            });

        }
        if (!pd.isShowing()) {
            pd.show();
        }

    }
    private  void dismissDialog(){
        if(pd.isShowing() || pd != null){
            pd.dismiss();
            pd = null;

        }

    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissDialog();
                break;
        }
    }
}
