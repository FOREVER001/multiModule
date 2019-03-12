package client.com.baselibs.http;


/**
 * Created on 2018/1/31 14:23.
 *
 * @author pan
 * @version 1.0
 */

public class HttpUtil {
    /**
     * 构造方法私有
     */
    private HttpUtil() {
    }

    /**
     * 在访问HttpUtil时创建单例
     */
    private static class SingletonHolder {
        private static final HttpUtil INSTANCE = new HttpUtil();
    }

    /**
     * 获取单例
     */
    public static HttpUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

}

