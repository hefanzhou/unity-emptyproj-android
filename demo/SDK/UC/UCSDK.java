package com.zulong.unisdk;

import org.json.JSONObject;

import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import cn.uc.gamesdk.UCCallbackListener;
import cn.uc.gamesdk.UCCallbackListenerNullException;
import cn.uc.gamesdk.UCFloatButtonCreateException;
import cn.uc.gamesdk.UCGameSDK;
import cn.uc.gamesdk.UCGameSDKStatusCode;
import cn.uc.gamesdk.info.FeatureSwitch;
import cn.uc.gamesdk.info.GameParamInfo;
import cn.uc.gamesdk.info.OrderInfo;
import cn.uc.gamesdk.info.PaymentInfo;

import com.zulong.sdk.core.open.SDKBase;
import com.zulong.sdk.core.open.SDKInterface;
import com.zulong.unisdk.params.UCLoginParams;
import com.zulong.unisdk.UCLoginTask;
import com.zulong.sdk.core.param.OrderParams;
import com.zulong.sdk.core.util.LogUtil;

public final class UCSDK extends SDKBase {
	private static final int CHANNEL_ID = 9;
	private static final String CHANNEL_NAME = "UCSDK";
	private static final String TAG = UCSDK.class.getName();
	private static final String VERSION = "0.0.1";

	private SDKInterface.CompleteCallBack onBackBtCallBack;

	private boolean validateOrderParams(OrderParams paramOrderParams) {
		return true;
	}

	@Override
	protected void doLoginImpl() {
		ucLogin();
	}

	private void ucLogin() {
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				try {
					// 登录接口回调。从这里可以获取登录结果。
					UCCallbackListener<String> loginCallbackListener = new UCCallbackListener<String>() {
						@Override
						public void callback(int code, String msg) {
							Log.e("UCGameSDK", "UCGameSdk登录接口返回数据:code=" + code
									+ ",msg=" + msg);

							// 登录成功。此时可以获取sid。并使用sid进行游戏的登录逻辑。
							// 客户端无法直接获取UCID
							if (code == UCGameSDKStatusCode.SUCCESS) {

								// 获取sid。（注：ucid需要使用sid作为身份标识去SDK的服务器获取）
								Toast.makeText(getActivity(), "loginSucceed", 0)
										.show();
								String sidString = UCGameSDK.defaultSDK()
										.getSid();
								getAccount().setToken(sidString);
								UCLoginParams params = new UCLoginParams();
								loginCommonSDK(getActivity(), params,
										new UCLoginTask());

								ucSdkCreateFloatButton();
								showFloatViewImpl();
							}

							// 登录失败。应该先执行初始化成功后再进行登录调用。
							if (code == UCGameSDKStatusCode.NO_INIT) {
								// 没有初始化就进行登录调用，需要游戏调用SDK初始化方法
								ucSdkInit();
							}

							// 登录退出。该回调会在登录界面退出时执行。
							if (code == UCGameSDKStatusCode.LOGIN_EXIT) {
								// 登录界面关闭，游戏需判断此时是否已登录成功进行相应操作
							}

							if (code == UCGameSDKStatusCode.FAIL) {
								loginFailed(msg);
							}
						}

					};

					UCGameSDK.defaultSDK().login(getActivity(),
							loginCallbackListener);

				} catch (UCCallbackListenerNullException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 必接功能<br>
	 * 提交游戏扩展数据功能，游戏SDK要求游戏在运行过程中，提交一些用于运营需要的扩展数据，这些数据通过扩展数据提交方法进行提交。
	 * 登录游戏角色成功后调用此段
	 */
	private void ucSdkSubmitExtendData(OrderParams orderParams) {
		try {
			JSONObject jsonExData = new JSONObject();
			jsonExData.put("roleId", orderParams.getRoleId());// 玩家角色ID
			jsonExData.put("roleName", orderParams.getRoleName());// 玩家角色名
			jsonExData.put("roleLevel", orderParams.getLv());// 玩家角色等级
			jsonExData.put("zoneId", orderParams.getServerId());// 游戏区服ID
			jsonExData.put("zoneName", orderParams.getServerName());// 游戏区服名称
			UCGameSDK.defaultSDK()
					.submitExtendData("loginGameRole", jsonExData);
			LogUtil.d("UCGameSDK", "提交游戏扩展数据功能调用成功");
		} catch (Exception e) {
			// 处理异常
		}
	}

	@Override
	protected void showFloatViewImpl() {
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				// 显示悬浮图标，游戏可在某些场景选择隐藏此图标，避免影响游戏体验
				try {
					UCGameSDK.defaultSDK().showFloatButton(getActivity(), 100,
							50, true);
				} catch (UCCallbackListenerNullException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void destroyFloatViewImpl() {
		Log.i(TAG, "destroyFloatViewImpl");
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				// 悬浮按钮销毁功能
				UCGameSDK.defaultSDK().destoryFloatButton(getActivity());
			}
		});
	}

	@Override
	protected void dismissFloatViewImpl() {
		// 隐藏图标
		Log.i(TAG, "dismissFloatViewImpl");
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				try {
					UCGameSDK.defaultSDK().showFloatButton(getActivity(), 100,
							50, false);
				} catch (UCCallbackListenerNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private void ucSdkCreateFloatButton() {
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				try {
					// 创建悬浮按钮。该悬浮按钮将悬浮显示在GameActivity页面上，点击时将会展开悬浮菜单，菜单中含有
					// SDK 一些功能的操作入口。
					// 创建完成后，并不自动显示，需要调用showFloatButton(Activity,
					// double, double, boolean)方法进行显示或隐藏。
					UCGameSDK.defaultSDK().createFloatButton(getActivity(),
							new UCCallbackListener<String>() {

								@Override
								public void callback(int statuscode, String data) {
									Log.d("SelectServerActivity`floatButton Callback",
											"statusCode == " + statuscode
													+ "  data == " + data);
								}
							});

				} catch (UCCallbackListenerNullException e) {
					e.printStackTrace();
				} catch (UCFloatButtonCreateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	protected void doLogoutImpl() {
		try {
			UCGameSDK.defaultSDK().logout();
		} catch (UCCallbackListenerNullException e) {
			LogUtil.e("UCSdk", "登出函数调用出错：");
			e.printStackTrace();
		}
	}

	private void InitLogout() {
		try {
			UCGameSDK.defaultSDK().setLogoutNotifyListener(
					new UCCallbackListener<String>() {
						@Override
						public void callback(int statuscode, String msg) {
							// TODO 此处需要游戏客户端注销当前已经登录的游戏角色信息
							String s = "游戏接收到用户退出通知。" + msg + statuscode;
							Log.e("UCGameSDK", s);
							// 退出账号成功
							if (statuscode == UCGameSDKStatusCode.SUCCESS) {
								logoutSucceed();
							} else {
								logoutFailed(statuscode + msg);
							}
						}
					});
		} catch (UCCallbackListenerNullException e) {
			LogUtil.e("UCSdk", "调用登出函数出错");
			e.printStackTrace();
		}
	}

	@Override
	public void doPay(OrderParams paramOrderParams,
			SDKInterface.PayCallBack paramPayCallBack) {
		if (!validateOrderParams(paramOrderParams))
			return;
		super.doPay(paramOrderParams, paramPayCallBack);
		Log.i(TAG, "doPay");
	}

	protected void doPayImpl(OrderParams paramOrderParams) {
		ucSdkPay(paramOrderParams);
	}

	/**
	 * 必接功能<br>
	 * SDK支付功能<br>
	 * 调用SDK支付功能 <br>
	 * 如你在调用支付页面时，没有显示正确的支付页面 <br>
	 * 请参考自助解决方案：http://bbs.9game.cn/thread-6074095-1-1.html <br>
	 * 在联调环境中进行支付，可使用无效卡进行支付，只需符合卡号卡密长度位数即可<br>
	 * 当卡号卡密全部输入为1时，是支付失败的订单，服务器将会收到订单状态为F的订单信息<br>
	 */
	private void ucSdkPay(OrderParams orderParams) {
		PaymentInfo pInfo = new PaymentInfo(); // 创建Payment对象，用于传递充值信息

		// 设置充值自定义参数，此参数不作任何处理，
		// 在充值完成后，sdk服务器通知游戏服务器充值结果时原封不动传给游戏服务器传值，字段为服务端回调的callbackInfo字段
		// zhf此处暂定为不使用，为扩展点
		// pInfo.setCustomInfo("callback");

		// 非必选参数，可不设置，此参数已废弃,默认传入0即可。
		// 如无法支付，请在开放平台检查是否已经配置了对应环境的支付回调地址，如无请配置，如有但仍无法支付请联系UC技术接口人。
		pInfo.setServerId(0);

		pInfo.setRoleId(orderParams.getRoleId()); // 设置用户的游戏角色的ID，此为必选参数，请根据实际业务数据传入真实数据
		pInfo.setRoleName(orderParams.getRoleName()); // 设置用户的游戏角色名字，此为必选参数，请根据实际业务数据传入真实数据
		pInfo.setGrade(orderParams.getLv()); // 设置用户的游戏角色等级，此为可选参数

		// 非必填参数，设置游戏在支付完成后的游戏接收订单结果回调地址，必须为带有http头的URL形式。
		// pInfo.setNotifyUrl("http://192.168.1.1/notifypage.do");

		// 当传入一个amount作为金额值进行调用支付功能时，SDK会根据此amount可用的支付方式显示充值渠道
		// 如你传入6元，则不显示充值卡选项，因为市面上暂时没有6元的充值卡，建议使用可以显示充值卡方式的金额
		pInfo.setAmount(orderParams.getPrice());// 设置充值金额，此为可选参数

		try {
			UCGameSDK.defaultSDK().pay(getActivity().getApplicationContext(),
					pInfo, payResultListener);
		} catch (UCCallbackListenerNullException e) {
			// 异常处理
		}

	}

	private UCCallbackListener<OrderInfo> payResultListener = new UCCallbackListener<OrderInfo>() {
		@Override
		public void callback(int statudcode, OrderInfo orderInfo) {
			try {

				LogUtil.d("UCSdk", "充值回调" + statudcode);
				if (statudcode == UCGameSDKStatusCode.SUCCESS) {
					// 成功充值
					if (orderInfo != null) {
						String ordereId = orderInfo.getOrderId();// 获取订单号
						float orderAmount = orderInfo.getOrderAmount();// 获取订单金额
						int payWay = orderInfo.getPayWay();
						String payWayName = orderInfo.getPayWayName();

						JSONObject jo = new JSONObject();
						jo.put("ordereid", ordereId);
						jo.put("orderAmount", orderAmount + "");
						jo.put("payWayName", payWayName);

						paySucceed(jo.toString());

					}
				} else if (statudcode == UCGameSDKStatusCode.FAIL) {
					payFailed("fail");
				} else if (statudcode == UCGameSDKStatusCode.PAY_USER_EXIT) {
					payCancelled("exit");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	};

	@Override
	public int getChannelId() {
		return CHANNEL_ID;
	}

	@Override
	public String getChannelName() {
		return CHANNEL_NAME;
	}

	@Override
	protected UCConfigReader getConfigReader() {
		Activity localActivity = getActivity();
		return new UCConfigReader(localActivity);
	}

	@Override
	protected String getVersion() {
		return VERSION;
	}

	private void ucSdkInit() {

		try {
			GameParamInfo gpi = new GameParamInfo();
			gpi.setCpId(0);
			gpi.setGameId(getConfigReader().CHANNEL_APPID);
			gpi.setServerId(0); // 参数已经废弃

			// 在九游社区设置显示查询充值历史和显示切换账号按钮，
			// 在不设置的情况下，默认情况情况下，生产环境显示查询充值历史记录按钮，不显示切换账户按钮
			// 测试环境设置无效
			gpi.setFeatureSwitch(new FeatureSwitch(
					getConfigReader().showPayHistory,
					getConfigReader().showChangeAccoutBt));

			// 设置SDK登录界面为竖屏
			UCGameSDK.defaultSDK()
					.setOrientation(getConfigReader().ORIENTATION);

			// 设置登录界面：
			// USE_WIDGET - 简版登录界面
			// USE_STANDARD - 标准版登录界面
			UCGameSDK.defaultSDK()
					.setLoginUISwitch(getConfigReader().loginFace);

			LogUtil.d("UCSdk", "调用SDK初始化函数");
			UCGameSDK.defaultSDK().initSDK(getActivity(),
					getConfigReader().LOG_LEVEL, getConfigReader().DEBUG_MODEL,
					gpi, new UCCallbackListener<String>() {
						@Override
						public void callback(int code, String msg) {
							LogUtil.d("UCGameSDK", "UCGameSDK初始化接口返回数据 msg:"
									+ msg + ",code:" + code + ",debug:"
									+ getConfigReader().DEBUG_MODEL + "\n");
							switch (code) {
							// 初始化成功,可以执行后续的登录充值操作
							case UCGameSDKStatusCode.SUCCESS:
								// 调用oneSdk通知调用成功
								initSucceed(msg);
								break;
							case UCGameSDKStatusCode.FAIL:
								// 调用onesdk调用失败
								initFailed(msg);
							default:
								break;
							}
						}

					});
		} catch (UCCallbackListenerNullException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void initImpl() {
		LogUtil.d("UCSdk", "开始ucsdk的初始化");
		InitLogout();
		ucSdkInit();
	}

	/**
	 * 必接功能<br>
	 * 当游戏退出前必须调用该方法，进行清理工作。建议在游戏退出事件中进行调用，必须在游戏退出前执行<br>
	 * 如果游戏直接退出，而不调用该方法，可能会出现未知错误，导致程序崩溃<br>
	 */
	private void ucSdkExit() {
		UCGameSDK.defaultSDK().exitSDK(getActivity(),
				new UCCallbackListener<String>() {
					@Override
					public void callback(int code, String msg) {
						if (UCGameSDKStatusCode.SDK_EXIT_CONTINUE == code) {
							// 此加入继续游戏的代码

						} else if (UCGameSDKStatusCode.SDK_EXIT == code) {
							onBackBtCallBack.onComplete();

						}
					}
				});
	}

	@Override
	public boolean onKeyDown(int actionCode, KeyEvent action,
			SDKInterface.CompleteCallBack completeCallBack) {
		if (actionCode == KeyEvent.KEYCODE_BACK) {
			ucSdkExit();
			onBackBtCallBack = completeCallBack;
		} else {
			completeCallBack.onComplete();
		}
		return true;
	}
}