package com.zulong.unisdk;

import android.R.integer;
import android.R.string;
import android.content.Context;
import android.util.DebugUtils;

import cn.uc.gamesdk.UCLogLevel;
import cn.uc.gamesdk.UCLoginFaceType;
import cn.uc.gamesdk.UCOrientation;

import com.zulong.sdk.core.config.ConfigReader;
import com.zulong.sdk.core.param.Param;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class UCConfigReader extends ConfigReader
{
  public static  int CHANNEL_APPID;
  public static  String CHANNEL_APPKEY;
  public static  UCOrientation ORIENTATION;
  public static  boolean DEBUG_MODEL;
  public  static UCLogLevel LOG_LEVEL;
  public static boolean showPayHistory = true;
  public static boolean showChangeAccoutBt = false;
  public static UCLoginFaceType loginFace = UCLoginFaceType.DEFAULT;
  
  public UCConfigReader(Context paramContext)
  {
    super(paramContext);
  }

	
  //重载读取json的linit配置 加入自己想读取的数据
  protected HashMap<String, Param> readChannelInitParams(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    String strAppid = paramJSONObject.getString("uc_appId");
    Param localParam1 = new Param("channel_appId", strAppid, true);
    localHashMap.put("uc_appId", localParam1);
    CHANNEL_APPID = Integer.parseInt(strAppid);
    
    CHANNEL_APPKEY = paramJSONObject.getString("uc_appKey");
    Param localParam2 = new Param("channel_appKey", CHANNEL_APPKEY, true);
    localHashMap.put("uc_appKey", localParam2);
    
    String strDebugModel = paramJSONObject.getString("debug_model");
    Param localParam3 = new Param("debug_model", strDebugModel, true);
    localHashMap.put("debug_model", localParam3);
    DEBUG_MODEL = Boolean.parseBoolean(strDebugModel);
   
    String debugLevelStr = paramJSONObject.getString("log_level");
    Param debugLevelParam = new Param("log_level", debugLevelStr, true);
    localHashMap.put("log_levle", debugLevelParam);
    if(debugLevelStr == "debug")
    {
    	LOG_LEVEL = UCLogLevel.DEBUG;
    }else if(debugLevelStr == "error"){
		LOG_LEVEL = UCLogLevel.ERROR;
	}else {
		LOG_LEVEL = UCLogLevel.WARN;
	}
    
    String orginStr = paramJSONObject.getString("orientation");
    localHashMap.put("orientation", new Param("orientation", orginStr, true));
    if(orginStr == "landscape")
    {
    	ORIENTATION = UCOrientation.LANDSCAPE;
    }
    else {
		ORIENTATION = UCOrientation.PORTRAIT;
	}
    
    String strShowHistory = paramJSONObject.getString("showPayHistory");
    localHashMap.put("showPayHistory", new Param("showPayHistory", strShowHistory, true));
    showPayHistory = Boolean.parseBoolean(strShowHistory);
    
    String strshowChangeAccoutBt = paramJSONObject.getString("showChangeAccoutBt");
    localHashMap.put("showChangeAccoutBt", new Param("showChangeAccoutBt", strshowChangeAccoutBt, true));
    showChangeAccoutBt = Boolean.parseBoolean(strshowChangeAccoutBt);
    
    String loginFaceStr = paramJSONObject.getString("loginFaceType");
    localHashMap.put("loginFaceType", new Param("loginFaceType", loginFaceStr, true));
    if(loginFaceStr == "USE_STANDARD")
    {
    	loginFace = UCLoginFaceType.USE_STANDARD;
    }
    else {
    	loginFace = UCLoginFaceType.USE_WIDGET;
	}
    
    return localHashMap;
  }
}