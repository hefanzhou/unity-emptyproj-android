package com.zulong.sdk.core.open;

import android.content.Intent;
import android.view.KeyEvent;

public class SDKFoundation
{
  public void onCreate(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onStart(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onRestart(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onPause(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onResume(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onStop(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onDestroy(SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public boolean onKeyDown(int actionCode, KeyEvent action, SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
    return false;
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data, SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }

  public void onNewIntent(Intent intent, SDKInterface.CompleteCallBack completeCallBack)
  {
    completeCallBack.onComplete();
  }
}