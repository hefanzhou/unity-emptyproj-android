package com.zulong.test;

import com.unity3d.player.UnityPlayerActivity;

import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.view.KeyEvent;

import com.zulong.unisdk.CommonSDK;
import com.zulong.sdk.core.open.SDKBase;
import com.zulong.sdk.core.open.SDKInterface;
import com.zulong.sdk.core.util.LogUtil;
import com.zulong.sdk.core.util.Toast;

public class ZLPlayerActivity extends UnityPlayerActivity {
	
	private static final int UNISDK_APPID = 1001;
	private static final String UNISDK_APPKEY = "abcdefg";
	private Context mContext = ZLPlayerActivity.this;
	private static final String TAG = ZLPlayerActivity.class.getName();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LogUtil.setLOG(true);
		SDKBase.sdk = new CommonSDK();
		SDKBase.getInstance(this);
		
		LogUtil.d("ZLPlayerActivity","onCreate called!");
		
		SDKBase.getInstance(this).init(UNISDK_APPID, UNISDK_APPKEY, new SDKInterface.InitCallBack() {
			@Override
			public void initSucceed(String extraJson) {
				LogUtil.d(TAG, "initSucceed");
				Toast.makeToast(mContext, "initSucceed, extraJson:" + extraJson);
			}

			@Override
			public void initFailed(String reason) {
				LogUtil.d(TAG, "initFailed");
				Toast.makeToast(mContext, "initFailed, reason:" + reason);
			}
		});
	}
	
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			LogUtil.d(TAG,"on back button");
			if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)
				Toast.makeToast(mContext, "click me");
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
}