@echo ""
@echo "Compiling Java..."

@del /F /S /Q  com
@rd com /S /Q
@javac -encoding UTF-8 UCConfigReader.java  UCSDK.java UCLoginParams.java  UCLoginTask.java  -source 1.6  -target 1.6  -bootclasspath android.jar;alipay-20150513.jar;UCGameSDK-3.5.3.1.jar;android-support-v4.jar  -classpath  SDK.jar -d .





@jar cvfM common.jar com/


@echo ""
@echo "Done!"
@pause