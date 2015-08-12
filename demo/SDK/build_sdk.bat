@echo ""
@echo "Compiling Java..."

@del /F /S /Q  com
@rd com /S /Q
@javac  LogUtil.java Param.java  ConfigReader.java  ConfigFileException.java  SDKInterface.java  SDKFoundation.java  SDKImpl.java  SDKBase.java   -source 1.6  -target 1.6  -bootclasspath classes.jar   -classpath  android.jar  -d .

@javap -s com.zulong.sdk.core.open.SDKInterface
@javap -s com.zulong.sdk.core.open.SDKFoundation
@javap -s com.zulong.sdk.core.open.SDKImpl
@javap -s com.zulong.sdk.core.open.SDKBase
@javap -s com.zulong.sdk.core.param.Param
@javap -s com.zulong.sdk.core.util.LogUtil
@javap -s com.zulong.sdk.core.config.ConfigReader
@javap -s com.zulong.sdk.core.config.ConfigFileException


@jar cvfM SDK.jar com/


@echo ""
@echo "Done!"
@pause