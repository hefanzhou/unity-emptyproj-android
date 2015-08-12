@echo ""
@echo "Compiling Java..."

@del /F /S /Q  com
@javac  LogUtil.java Param.java  ConfigReader.java  ConfigFileException.java  SDKInterface.java  SDKFoundation.java  SDKImpl.java  SDKBase.java  CommonSDK.java  -source 1.6  -target 1.6  -bootclasspath classes.jar   -classpath  android.jar  -d .

@javap -s com.zulong.sdk.core.open.SDKInterface
@javap -s com.zulong.sdk.core.open.SDKFoundation
@javap -s com.zulong.sdk.core.open.SDKImpl
@javap -s com.zulong.unisdk.CommonSDK
@javap -s com.zulong.sdk.core.param


@jar cvfM SDK.jar com/


@echo ""
@echo "Done!"
@pause