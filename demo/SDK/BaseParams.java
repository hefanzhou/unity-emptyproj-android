package com.zulong.sdk.core.param;

import java.util.HashMap;

public abstract class BaseParams
{
  public HashMap<String, String> getExtraParams()
  {
    return addExtraParams(new HashMap());
  }

  protected abstract HashMap<String, String> addExtraParams(HashMap<String, String> paramHashMap);
}