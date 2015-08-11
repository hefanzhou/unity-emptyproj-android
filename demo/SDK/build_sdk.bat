@echo ""
@echo "Compiling Java..."

@del /F /S /Q  com
@javac SDKInterface.java  SDKFoundation.java  SDKImpl.java  SDKBase.java  CommonSDK.java  -source 1.6  -target 1.6  -bootclasspath classes.jar   -classpath  android.jar  -d .

@javap -s com.zulong.sdk.core.open.SDKInterface
@javap -s com.zulong.sdk.core.open.SDKFoundation
@javap -s com.zulong.sdk.core.open.SDKImpl
@javap -s com.zulong.unisdk.CommonSDK


@jar cvfM SDK.jar com/


@echo ""
@echo "Done!"
@pause