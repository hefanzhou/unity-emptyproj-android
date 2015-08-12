package com.zulong.test;

import com.unity3d.player.UnityPlayerActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;

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
		Log.d("ZLPlayerActivity","onCreate called!");
		
		LogUtil.setLOG(true);
		SDKBase.sdk = new CommonSDK();
		SDKBase.getInstance(this);
		
		SDKBase.getInstance(this).init(UNISDK_APPID, UNISDK_APPKEY, new SDKInterface.InitCallBack() {
			@Override
			public void initSucceed(String extraJson) {
				Log.d(TAG, "initSucceed");
				Toast.makeText(mContext, "initSucceed, extraJson:" + extraJson, Toast.LENGTH_LONG).show();
			}

			@Override
			public void initFailed(String reason) {
				Log.d(TAG, "initFailed");
				Toast.makeText(mContext, "initFailed, reason:" + reason, Toast.LENGTH_LONG).show();
			}
		});
	}
}