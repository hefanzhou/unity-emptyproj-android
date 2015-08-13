package com.zulong.sdk.core.task;

import android.app.Activity;
import java.util.HashMap;
import org.json.JSONObject;

import com.zulong.sdk.core.param.BaseLoginParams;

public class LoginTask
{
  private BaseLoginParams params;
  private LoginCallBack cb;

  public LoginTask(Activity activity, BaseLoginParams params, LoginCallBack callBack)
  {
    this.params = params;
    this.cb = callBack;
  }

	public void doTask() {
		//在这里向unisdkServer发起验证
		HashMap<String, String> extraParams = params.getExtraParams();
		//JSONObject json = new JSONObject(extraParams);
		String msg = "you are welcome"; //this msg come from unisdkserver
		this.cb.succeed(msg);
	}

  public static abstract interface LoginCallBack
  {
    public abstract void succeed(String paramString);

    public abstract void failed(String paramString);
  }
}