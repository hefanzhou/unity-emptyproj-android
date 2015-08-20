# unity-emptyproj-android

UniSDK的代码在demo/SDK目录下

按以下步骤接入自己的sdk

.	把UniSDK.config的内容替换成自己的内容，格式参加此文件原始内容
	以"channel"为key的value，可以通过SDKBase.getXXXConfig获取
	
. 从SDKBase派生自己的子类，取名CommonXXX  （XXX自己定义）

. 重载initImpl函数，需要接入的sdk所需参数请从getInitConfig里获取

. 重载doLoginImpl函数，在接入的sdk返回token和userid后，需要调用：
				  	getAccount().setToken(token);
  					getAccount().setUserId(userid);
  并自己实现loginTask接口，额外参数通过msg返回
  
. 重载doLogoutImpl函数

. 重载doPayImpl函数

. UniSDK的使用方法见ZLPlayerActivity.java


所有为接入sdk而派生的子类都以Common开头，并且添加到build_common.bat中。编译生成的common.jar替换Assets/Plugins/Android下的common.jar 。
其他框架源代码如无必要，请不要修改。