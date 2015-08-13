package com.zulong.unisdk;

import com.zulong.sdk.core.task.LoginTask;
import com.zulong.sdk.core.open.SDKBase;


class CommonLoginTask implements LoginTask.LoginCallBack {
	
    public void succeed(String paramString) {
    	
    	SDKBase.instance.loginSucceed(paramString);
    }

    public void failed(String paramString)  {
    	
    	SDKBase.instance.loginFailed(paramString);
    }
	
	
}