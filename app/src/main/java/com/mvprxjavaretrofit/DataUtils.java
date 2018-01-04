package com.mvprxjavaretrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Avazu Holding on 2018/1/2.
 */

public class DataUtils {

    public static String getBody(JSONObject headerObj, JSONObject bodyObj) {
        String strRet = "";
        String strHead = "\"headers\":";
        String strBody = "\"body\":";
        String strHeaderJson = "{}";
        if (headerObj != null) {
            strHeaderJson = headerObj.toString();
        }
        String strBodyJson = "{}";
        if (bodyObj != null) {
            strBodyJson = bodyObj.toString();
        }

        strRet = "{" + strHead + strHeaderJson + "," + strBody + strBodyJson + "}";
        Log.d("LuoYU","strRetString is " + strRet);
        return strRet;
    }
    public static JSONObject mergeToJSONObj(HashMap<String, String> tmpMap) {
        JSONObject obj = new JSONObject();
        if (tmpMap == null) return null;
        try {
            Iterator iter = tmpMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                obj.put((String) entry.getKey(), (String) entry.getValue());
                Log.d("LuoYU","key is " + (String) entry.getKey() + "value is " + (String) entry.getValue());

            }
        } catch (JSONException e) {
            Log.e("LuoYU","catch JSONException e" + e);
            e.printStackTrace();
            return null;
        }
        return obj;
    }
    public static HashMap<String, String> getHeaderParameters(Context context) {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("deviceId", encode(getDeviceID(context)));
        map.put("deviceType", encode("android"));
        map.put("deviceBrand", getManufacturer());
        map.put("accessToken", encode(getAccessToken(context)));
        map.put("token", encode(getToken(context)));
        map.put("deviceOs", encode(getOsVersion()));
        map.put("appChannel", "01");

        return map;
    }
    public static String encode(String parameter) {
        if (!TextUtils.isEmpty(parameter)) {
            try {
                parameter = URLEncoder.encode(parameter, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return parameter;
    }
    public static String getDeviceID(Context context){
        return getIMEI(context) + getAndroidId(context);
    }
    public static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }
    public static String getIMEI(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE)).getDeviceId();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }
    public static String getManufacturer() {
        try {
            return android.os.Build.MANUFACTURER;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }
    public static String getAccessToken(Context ctx) {
        SharedPreferences share = ctx.getSharedPreferences("opay", Context.MODE_PRIVATE);
        return share.getString("accessToken", "");
    }

    public static void saveAccessToken(Context ctx, String strToken) {
        Log.e("AndroidTest","save token --- "  + strToken);
        if (strToken == null) return;
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("opay", Context.MODE_PRIVATE); //私有数据
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        editor.putString("accessToken", strToken);
        editor.commit();//提交修改
    }
    public static String getToken(Context ctx) {
        SharedPreferences share = ctx.getSharedPreferences("opay", Context.MODE_PRIVATE);
        return share.getString("token", "");
    }

    public static void setToken(Context ctx, String strToken) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("opay", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", strToken);
        editor.commit();
    }
    public static String getOsVersion() {
        try {
            return android.os.Build.VERSION.RELEASE;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }
    public static String shaEncrypt(String strSrc) {

        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-256");// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
