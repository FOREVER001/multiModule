package client.com.baselibs.utils;
/**
 * 配置各个模块的application的全类名
 * @author zxh17
 * @version 1.0
 * */
public class AppConfig {
    //home页面
    private static final String HomeApp = "client.com.module_1.ui.app.HomeApp";
    //公众号页面
    private static final String PublicArticleApp = "client.com.module_2.app.PublicArticleApp";

    public static String[] moduleApps = {
            HomeApp, PublicArticleApp
    };
}
