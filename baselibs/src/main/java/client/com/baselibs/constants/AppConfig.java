package client.com.baselibs.constants;


/**
 * Created on 2018/1/30 17:22.
 * <p>
 * 常量
 *
 * @author pan
 * @version 1.0
 */

public interface AppConfig {
//   https://www.wanandroid.com/blog/show/2
   String BASE_URL_MEIZI="http://gank.io/";
   String BASE_URL_Wan="https://www.wanandroid.com/";
   /**
    * 注册
    * */
   String REGIST=BASE_URL_Wan+"user/register";
   /**
    * 登录
    * */
   String LOGIN=BASE_URL_Wan+"user/login";
   /**
    * banner
    * */
   String BANNER=BASE_URL_Wan+"banner/json";
   /**
    * 首页文章列表
    */
   String ARTICLE_LIST=BASE_URL_Wan+"article/list/{page}/json";


}
