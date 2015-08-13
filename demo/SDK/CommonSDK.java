package  com.zulong.unisdk;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.zulong.sdk.core.open.SDKBase;
import com.zulong.sdk.core.open.SDKInterface;
import com.zulong.sdk.core.config.ConfigReader;
import com.zulong.unisdk.params.CommonLoginParams;
import com.zulong.unisdk.CommonLoginTask;



public final class CommonSDK extends SDKBase
{
  private static final int CHANNEL_ID = 9;
  private static final String CHANNEL_NAME = "UniSDK";
  private static final String TAG = CommonSDK.class.getName();
  private static final String VERSION = "0.0.1";

//  private boolean validateOrderParams(OrderParams paramOrderParams)
//  {
//		return true;
//  }

  protected void destroyFloatViewImpl()
  {
    int i = Log.i(TAG, "destroyFloatViewImpl");
  }

  protected void dismissFloatViewImpl()
  {
    int i = Log.i(TAG, "dismissFloatViewImpl");
  }

  protected void doLoginImpl()
  {
  	//Toast.makeText(getActivity(), "loginSucceed", 0).show();
  	Log.i(TAG, "doLoginImpl");
  	
  	SDKBase.instance.getAccount().setToken("thisistoken");
  	SDKBase.instance.getAccount().setUserId("thisuserid");
  	CommonLoginParams params = new CommonLoginParams();
  	SDKBase.instance.loginCommonSDK(getActivity(),params,new CommonLoginTask());
  }

  protected void doLogoutImpl()
  {
    //Toast.makeText(getActivity(), "logoutSucceed", 0).show();
    logoutSucceed();
		Log.i(TAG, "doLogoutImpl");
  }

//  public void doPay(OrderParams paramOrderParams, SDKInterface.PayCallBack paramPayCallBack)
//  {
//		Log.i(TAG, "doPay");
//  }

//  protected void doPayImpl(OrderParams paramOrderParams)
//  {
//    paySucceed("paySucceed");
//  }

  public int getChannelId()
  {
    return 9;
  }

  public String getChannelName()
  {
    return "OneSDK";
  }

  protected ConfigReader getConfigReader()
  {
    Activity localActivity = getActivity();
    return new CommonConfigReader(localActivity);
  }

  protected String getVersion()
  {
    return VERSION;
  }

  public void init(int paramInt, String paramString, SDKInterface.InitCallBack paramInitCallBack)
  {
    super.init(paramInt, paramString, paramInitCallBack);
  }

  protected void initImpl()
  {
    initSucceed("initSucceed");
  }
}