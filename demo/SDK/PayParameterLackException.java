package com.zulong.sdk.core.param;

import android.util.Log;

public class PayParameterLackException extends RuntimeException
{
  private static final long serialVersionUID = -4116024186339844194L;

  public PayParameterLackException()
  {
  }

  public PayParameterLackException(String detailMessage)
  {
    super(detailMessage);
    Log.d("PayParameterLackException", detailMessage);
  }

  public PayParameterLackException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public PayParameterLackException(Throwable cause)
  {
    super(cause == null ? null : cause.toString(), cause);
  }
}