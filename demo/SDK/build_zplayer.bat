@echo ""
@echo "Compiling Java..."

@del /F /S /Q  com
@javac ZLPlayerActivity.java -source 1.6  -target 1.6  -bootclasspath classes.jar   -classpath  android.jar  -d .
@javap -s com.zulong.test.ZLPlayerActivity
@jar cvfM ZLPlayerActivity.jar com/


@echo ""
@echo "Done!"
@pause