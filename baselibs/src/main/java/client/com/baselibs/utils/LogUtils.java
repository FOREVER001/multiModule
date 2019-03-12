package client.com.baselibs.utils;

import android.os.Environment;
import android.util.Log;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import client.com.baselibs.BuildConfig;

/**
 * Created by DEV-81 on 2018/4/12.
 */

public class LogUtils {
    /**
     * true用于开发阶段，false用于正式版本
     */
    public static final boolean TEST_FLAG = BuildConfig.DEBUG;
    //    public static final boolean TEST_FLAG = false;
    public static final boolean TEST_FLAG1 = false;
    public static void syso(String str) {
        if (TEST_FLAG)
            System.out.println(str);
    }

    public static void syso(int i) {
        if (TEST_FLAG)
            System.out.println(i);
    }

    public static void syso1(String str){
        if(TEST_FLAG1)
            System.out.println(str);
    }
    public static void string2Local(String str){
        if(!TEST_FLAG)return;
        File file = new File(Environment.getExternalStorageDirectory(),"json.txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        syso("json本地化结束");
    }

    //定义全局的标志
    public static boolean isOpen = true;

    public static  void info(String msg) {
        if (isOpen) {
            Log.i("oschina info message:", msg);
        }
    }

    private LogUtils() { throw new UnsupportedOperationException("cannot be instantiated"); }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "way";

    /**
     * 默认tag的函数
     * @param msg 打印信息
     */
    public static void v(String msg) { if (isDebug) Log.v(TAG, msg); }
    public static void d(String msg) { if (isDebug) Log.d(TAG, msg); }
    public static void i(String msg) { if (isDebug) Log.i(TAG, msg); }
    public static void w(String msg) { if (isDebug) Log.w(TAG, msg); }
    public static void e(String msg) { if (isDebug) Log.e(TAG, msg); }

    /**
     * 自定义lag的函数
     * @param tag tag
     * @param msg 打印信息
     */
    public static void v(String tag, String msg) { if (isDebug) Log.v(tag, msg); }
    public static void d(String tag, String msg) { if (isDebug) Log.d(tag, msg); }
    public static void i(String tag, String msg) { if (isDebug) Log.i(tag, msg); }
    public static void w(String tag, String msg) { if (isDebug) Log.w(tag, msg); }
    public static void e(String tag, String msg) { if (isDebug) Log.e(tag, msg); }

    /**
     * 自定义lag的函数
     * @param clazz 类
     * @param msg 打印信息
     */
    public static void v(Class<?> clazz, String msg) { if(isDebug) Log.v(clazz.getSimpleName(), msg); }
    public static void d(Class<?> clazz, String msg) { if(isDebug) Log.d(clazz.getSimpleName(), msg); }
    public static void i(Class<?> clazz, String msg) { if(isDebug) Log.i(clazz.getSimpleName(), msg); }
    public static void w(Class<?> clazz, String msg) { if(isDebug) Log.w(clazz.getSimpleName(), msg); }
    public static void e(Class<?> clazz, String msg) { if(isDebug) Log.e(clazz.getSimpleName(), msg); }

}
