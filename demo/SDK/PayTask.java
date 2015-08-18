package com.zulong.sdk.core.task;

import android.app.Activity;
import com.zulong.sdk.core.param.BaseOrderParams;
import java.util.HashMap;

public final class PayTask
{
  private BaseOrderParams params;
  private PayCallBack cb;

  public PayTask(Activity activity, BaseOrderParams params, PayCallBack callback)
  {
    // "下单中，请稍候..."
    this.params = params;
    this.cb = callback;
  }
  
  public void doTask() {
  	//向uniserver获取订单号
  	params.setOrderNum("123456");
  	cb.succeed(params.getOrderNum(),"order success");
  }


  public static abstract interface PayCallBack
  {
    public abstract void succeed(String commonOrderId, String msg);

    public abstract void failed(String msg);
  }
  
}