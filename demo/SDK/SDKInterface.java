package com.zulong.sdk.core.open;

public abstract interface SDKInterface //extends Proguard
{
  public static abstract interface CompleteCallBack
  {
    public abstract void onComplete();
  }

  public static abstract interface PayCallBack
  {
    public abstract void succeed(String paramString1, String paramString2);

    public abstract void failed(String paramString1, String paramString2);

    public abstract void cancelled(String paramString1, String paramString2);

    public abstract void ordered(String paramString1, String paramString2);
  }

  public static abstract interface LogoutCallBack
  {
    public abstract void succeed();

    public abstract void failed(String paramString);
  }

  public static abstract interface LoginCallBack
  {
    public abstract void succeed(String paramString1, String paramString2, String paramString3, String paramString4);

    public abstract void failed(String paramString);

    public abstract void cancelled();
  }

  public static abstract interface InitCallBack
  {
    public abstract void initSucceed(String paramString);

    public abstract void initFailed(String paramString);
  }
}