package com.zulong.sdk.core.util;

import android.content.Context;


public class Toast
{
  public static void makeToast(Context context, String text)
  {
    android.widget.Toast.makeText(context, text, 1).show();
  }

  public static void makeToast(Context context, String text, int length)
  {
    android.widget.Toast.makeText(context, text, length).show();
  }
}