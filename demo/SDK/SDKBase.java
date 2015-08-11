package com.zulong.sdk.core.open;

public abstract class SDKBase extends SDKImpl
{
  private static final String TAG = SDKBase.class.getName();
  //private static final String DEFAULT_CONFIG_FILE_NAME = "OneSDK.config";
  private static final long INTERVAL = 2000L;
  private static Activity mActivity;
  private int mAppId;
  private String mAppKey;
  private int mChannelId;
  private String mChannelName;
  private volatile boolean mHasLogin = false;
  //private volatile InitState mChannelInitState = InitState.process;
  //private volatile InitState mOnesdkInitState = InitState.process;
  private volatile String mInitMsg;
  protected SDKInterface.InitCallBack mInitCallBack;
  protected SDKInterface.LoginCallBack mLoginCallBack;
  protected SDKInterface.PayCallBack mPayCallBack;
  protected SDKInterface.LogoutCallBack mLogoutCallBack;
  //private ConfigReader mConfigReader;
  //private String mConfigFilePath;
  private static volatile SDKBase INSTANCE;
  private String commonOrderMsg;
  private static final String FLASH_PIC_PORTRAIT = "common_flash_portrait.png";
  private static final String FLASH_PIC_LANDSCAPE = "common_flash_landscape.png";
  private static final int FLASH_TIMER_TIME_MILLISECEND = 3000;
  //private HashMap<IntervalType, Long> lastTimeHashMap = new HashMap();


  public void init(int appId, String appKey, SDKInterface.InitCallBack initCallBack)
  {
    init(appId, appKey, "OneSDK.config", initCallBack);
  }

  public void init(int appId, String appKey, String configFileName, SDKInterface.InitCallBack initCallBack)
  {

  }  
  
  
}