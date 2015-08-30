package com.zulong.unisdk.params;

import com.zulong.sdk.core.param.BaseLoginParams;
import java.util.HashMap;

public class UCLoginParams extends BaseLoginParams
{
  public HashMap<String, String> addExtraParams(HashMap<String, String> paramHashMap)
  {
  	paramHashMap.put("sid", "fuckyou");
    return paramHashMap;
  }
}