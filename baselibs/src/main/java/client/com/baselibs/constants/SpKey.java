package client.com.baselibs.constants;

/**
 * Created on 2018/1/30 17:22.
 *
 * sharepreference 的 key
 * @author pan
 * @version 1.0
 */

public interface SpKey {
    String LANGUAGE_KEY = "language_key";

    /**
     * 用户信息相关
     * */
    String USR_ID = "USR_ID";
    String USR_TYPE = "USR_TYPE";
    String USR_NAME = "USR_NAME";
    String USR_MOBILE = "USR_MOBILE";
    String USR_REAL_NAME = "USR_REAL_NAME";
    String ORG_NO = "ORG_NO";
    String USR_TITLE = "USR_TITLE";
    String COMPANY_NAME = "COMPANY_NAME";
    String USR_AVATAR_PATH  = "USR_AVATAR_PATH";
    String BU_NO = "BU_NO";
    String BU_NAME = "BU_NAME";
    String BG_NO  = "BG_NO";
    String BG_NAME = "BG_NAME";
    String BRAND_LIST  = "BRAND_LIST";
    String USER_INFO  = "result";

    String ACTION_RELOGIN="com.bzt.gecko.geckocar.RELOGIN";

    String HAS_LOGIN = "has_login";//是否登录
    String FIRST_OPEN = "first_open"; //是否是第一次打开
    String INGORE_NOTIFICATION = "ingore_notification"; //是否忽略通知


    String WEB_TITLE = "web_title"; //网页标题
    String WEB_URL = "web_url"; //网页标题
    /**
     * action相关的
     * */

    //userInof 失效
    int Code=401;
    //请求成功
    int Sucess_Code=0;

    //选择客户的request_code
    int SELECT_CUSTOMER_CODE=111;

}
