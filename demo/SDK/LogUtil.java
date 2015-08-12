package com.zulong.sdk.core.util;

import android.util.Log;

public class LogUtil
{
  private static boolean LOG = false;

  public static void v(String tag, String msg)
  {
    if (LOG)
      Log.v(tag, msg);
  }

  public static void d(String tag, String msg)
  {
    if (LOG)
      Log.d(tag, msg);
  }

  public static void w(String tag, String msg)
  {
    if (LOG)
      Log.w(tag, msg);
  }

  public static void e(String tag, String msg)
  {
    if (LOG)
      Log.e(tag, msg);
  }

  public static void e(String tag, String msg, Throwable tr)
  {
    if (LOG)
      Log.e(tag, msg, tr);
  }

  public static void setLOG(boolean lOG)
  {
    LOG = lOG;
  }

  public static boolean isLOG()
  {
    return LOG;
  }
}