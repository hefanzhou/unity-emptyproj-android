package com.zulong.unisdk;

import com.zulong.sdk.core.task.LoginTask;
import com.zulong.sdk.core.open.SDKBase;


class UCLoginTask implements LoginTask.LoginCallBack {
	
    public void succeed(String paramString) {
    	
    	SDKBase.INSTANCE.loginSucceed(paramString);
    }

    public void failed(String paramString)  {
    	
    	SDKBase.INSTANCE.loginFailed(paramString);
    }
	
	
}