package com.zulong.unisdk;

import android.content.Context;
import com.zulong.sdk.core.config.ConfigReader;
import com.zulong.sdk.core.param.Param;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonConfigReader extends ConfigReader
{
  public static final String CHANNEL_APPID = "xiaomi_appId";
  public static final String CHANNEL_APPKEY = "xiaomi_appKey";
  public static final String ORIENTATION = "orientation";

  public CommonConfigReader(Context paramContext)
  {
    super(paramContext);
  }

  protected HashMap<String, Param> readChannelInitParams(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    String str1 = paramJSONObject.getString("xiaomi_appId");
    Param localParam1 = new Param("xiaomi_appId", str1, true);
    Object localObject1 = localHashMap.put("xiaomi_appId", localParam1);
    String str2 = paramJSONObject.getString("xiaomi_appKey");
    Param localParam2 = new Param("xiaomi_appKey", str2, true);
    Object localObject2 = localHashMap.put("xiaomi_appKey", localParam2);
    String str3 = paramJSONObject.getString("orientation");
    Param localParam3 = new Param("orientation", str3, true);
    Object localObject3 = localHashMap.put("orientation", localParam3);
    return localHashMap;
  }
}