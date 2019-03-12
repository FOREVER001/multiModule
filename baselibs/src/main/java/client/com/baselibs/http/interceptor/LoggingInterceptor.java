package client.com.baselibs.http.interceptor;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import client.com.baselibs.utils.LogUtils;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
*
* Name: LoggingInterceptor
* Author: zxh17
* Email: 
* Comment: 日志拦截器
* Date: 2018-07-23 14:47
* 
*/
public  class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获得请求信息，此处如有需要可以添加headers信息
        Request request = chain.request();
        //添加Cookie信息
     // request.newBuilder().addHeader("Cookie","aaaa");
        String method = request.method();
        //打印请求信息
        LogUtils.e("url:======" + request.url());
        LogUtils.e("method:=======" + method);
        LogUtils.e("headers-body:=====" + request.headers().toString());
        /***************请求参数d打印start*****************/
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                sb.append("{");
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + "：" + body.encodedValue(i) + ",");
                }
                sb.append("}");
                sb.delete(sb.length() - 1, sb.length());
                LogUtils.e("=post请求参数==",sb.toString());
            }
        } else {
            LogUtils.e("request-body:===get=="+request.url());
        }

        /***************请求参数d打印end*****************/

        //记录请求耗时
        long startNs = System.nanoTime();
        okhttp3.Response response;
        try {
            //发送请求，获得相应，
            response = chain.proceed(request);
        } catch (Exception e) {
            throw e;
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        //打印请求耗时
        LogUtils.e("耗时:"+tookMs+"ms");
        //使用response获得headers(),可以更新本地Cookie。
        Headers headers = response.headers();
        LogUtils.e(headers.toString());

        //获得返回的body，注意此处不要使用responseBody.string()获取返回数据，原因在于这个方法会消耗返回结果的数据(buffer)
        ResponseBody responseBody = response.body();

        //为了不消耗buffer，我们这里使用source先获得buffer对象，然后clone()后使用
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        //获得返回的数据
        Buffer buffer = source.buffer();
        //使用前clone()下，避免直接消耗
        LogUtils.e("=====response:======" + buffer.clone().readString(Charset.forName("UTF-8")));
        return response;
    }
}
