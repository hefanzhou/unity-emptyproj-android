package com.zulong.test;

import com.unity3d.player.UnityPlayerActivity;

import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.Toast;

import com.zulong.unisdk.CommonSDK;
import com.zulong.sdk.core.open.SDKBase;
import com.zulong.sdk.core.open.SDKInterface;
import com.zulong.sdk.core.util.LogUtil;


public class ZLPlayerActivity extends UnityPlayerActivity {
	
	private static final int UNISDK_APPID = 1001;
	private static final String UNISDK_APPKEY = "abcdefg";
	private Context mContext = ZLPlayerActivity.this;
	private static final String TAG = ZLPlayerActivity.class.getName();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LogUtil.setLOG(true);
		SDKBase.instance = new CommonSDK();
		SDKBase.getInstance(this);
		
		LogUtil.d("ZLPlayerActivity","onCreate called!");
		
		SDKBase.getInstance(this).init(UNISDK_APPID, UNISDK_APPKEY, new SDKInterface.InitCallBack() {
			@Override
			public void initSucceed(String extraJson) {
				LogUtil.d(TAG, "initSucceed");
				Toast.makeText(mContext, "initSucceed, extraJson:" + extraJson, Toast.LENGTH_LONG).show();
			}

			@Override
			public void initFailed(String reason) {
				LogUtil.d(TAG, "initFailed");
				Toast.makeText(mContext, "initFailed, reason:" + reason, Toast.LENGTH_LONG).show();
			}
		});
		
		SDKBase.getInstance(this).setLogoutCallBack(new SDKInterface.LogoutCallBack() {

			@Override
			public void succeed() {
				Toast.makeText(getApplicationContext(), "logout succeed", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void failed(String msg) {
				Toast.makeText(getApplicationContext(), "logout failed,msg: " + msg, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	protected void login() {
		SDKBase.getInstance(this).doLogin(new SDKInterface.LoginCallBack() {

			@Override
			public void succeed(String userId, String token, String password, String msg) {

				Toast.makeText(
						mContext,
						"userId: " + userId + "\n" + "token: " + token + "\n" + "password: " + password + "\n"
								+ "msg: " + msg, Toast.LENGTH_LONG).show();
			}

			@Override
			public void failed(String msg) {
				Toast.makeText(mContext, "login failed, msg:" + msg, Toast.LENGTH_LONG).show();
			}

			@Override
			public void cancelled() {
				Toast.makeText(mContext, "login cancelled", Toast.LENGTH_LONG).show();
			}
		});		
		
		
	}
	
	protected void logout() {
		SDKBase.getInstance(this).doLogout();
	}
	
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			LogUtil.d(TAG,"on back button");
			if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)
				Toast.makeText(mContext, "click me", Toast.LENGTH_LONG).show();
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
}