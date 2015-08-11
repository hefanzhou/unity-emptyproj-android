@echo ""
@echo "Compiling Java..."

@del /F /S /Q  com
@javac SDKInterface.java  SDKFoundation.java -source 1.6  -target 1.6  -bootclasspath classes.jar   -classpath  android.jar  -d .

@javap -s com.zulong.sdk.core.open.SDKInterface
@javap -s com.zulong.sdk.core.open.SDKFoundation




@jar cvfM SDK.jar com/


@echo ""
@echo "Done!"
@pause