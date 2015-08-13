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
		HashMap<String, String> extraParams = params.getExtraParams();
		JSONObject json = new JSONObject(extraParams);
		this.cb.succeed(json.toString());
	}

  public static abstract interface LoginCallBack
  {
    public abstract void succeed(String paramString);

    public abstract void failed(String paramString);
  }
}