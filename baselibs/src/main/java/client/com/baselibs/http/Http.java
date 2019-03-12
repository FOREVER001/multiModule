package client.com.baselibs.http;

import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import client.com.baselibs.constants.AppConfig;
import client.com.baselibs.constants.SpKey;
import client.com.baselibs.http.interceptor.LoggingInterceptor;
import client.com.baselibs.utils.LogUtils;
import client.com.baselibs.utils.NetworkUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static client.com.baselibs.constants.SpKey.LANGUAGE_KEY;


/**
 * Created on 2018/1/30 17:56.
 *
 * @author pan
 * @version 1.0
 */

public class Http {
    private static ApiService SERVICE;
    private static Context context;
    private static String PreferenceName = "exhibition_sp";
    private static String params;
//    private static boolean isFrom84=false; //true 表示端口号来自8084 false 表示端口号来自8085
    public static void initHttp(Context context) {
        Http.context = context;
    }

    /**
     * 请求超时时间
     */
    private static final int DEFAULT_TIMEOUT = 10000;

    public static ApiService getDefault(final HashMap<String, String> params) {
        Http.params = new Gson().toJson(params);

        if (context == null) {
            throw new NullPointerException("未初始化 http");
        }
        if (SERVICE == null) {
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient httpClient = new OkHttpClient();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            File httpCacheDirectory = new File(context.getCacheDir(), "httpCache");
            // 10 MiB
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(httpCacheDirectory, cacheSize);

            Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    CacheControl.Builder cacheBuilder = new CacheControl.Builder();
                    cacheBuilder.maxAge(0, TimeUnit.SECONDS);
                    cacheBuilder.maxStale(365, TimeUnit.DAYS);
                    CacheControl cacheControl = cacheBuilder.build();
                    Request request = chain.request();

                    if (!NetworkUtil.isNetworkConnected(context)) {
                        request = request.newBuilder()
                                .cacheControl(cacheControl)
                                .build();
                    }

                    Response originalResponse = chain.proceed(request);
                    if (NetworkUtil.isNetworkConnected(context)) {
                        // read from cache
                        int maxAge = 0;
                        return originalResponse.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public ,max-age=" + maxAge)
                                .build();
                    } else {
                        // tolerate 4-weeks stale
                        int maxStale = 60 * 60 * 24 * 28;
                        return originalResponse.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .build();
                    }
                }
            };


            Interceptor tokenInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    SharedPreferences sp = context.getSharedPreferences(PreferenceName,
                            Context.MODE_PRIVATE);
                    String userInfo = sp.getString(SpKey.USER_INFO, "");
                    String language = sp.getString(LANGUAGE_KEY, "zh");
                    String lan = "0";
                    if (language.equals("zh")){
                        lan = "0";
                    }else {
                        lan = "1";
                    }


                    request = request.newBuilder()
                            .header("language", lan)
                            .build();
                    return chain.proceed(request);
                }
            };


            httpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .cache(cache)
                    .addInterceptor(tokenInterceptor)
                    .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
//                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new LoggingInterceptor())
                    .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                    .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                    .build();

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
            SERVICE = new Retrofit.Builder()
                    .client(httpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(AppConfig.BASE_URL_UC)
                    .build().create(ApiService.class);
        }
        return SERVICE;
    }


}
