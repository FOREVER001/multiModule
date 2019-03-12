package client.com.baselibs.constants;

/**
 * Created on 2018/1/30 17:22.
 *
 * @author pan
 * @version 1.0
 */

public interface Constants {
    String ACTION_MAIN = "com.qmx163.health.health.MAIN";
    String ACTION_LOGIN = "com.qmx163.health.health.LOGIN";
    String ACTION_RELOGIN = "com.qmx163.health.health.RELOGIN";
    String ACTION_MAIN_MAP = "com.qmx163.health.health.MAIN_MAP";
    String ACTION_MAIN_SHOP = "com.qmx163.health.health.MAIN_SHOP";
    String DATA = "data";
    String CURRENT_LEVEL = "current_level";//当前分销等级

    String WX_APP_ID = "wxc0a5cb7f558d0384";
    String WX_APP_SECRET = "aed03ffc2e8d2b8e9d01b84b9cb4b372";
    String QQ_APP_ID = "1106797275";
    String QQ_APP_SECRET = "jCEwcqXm0gqeue18";

    String SINGURE_IMG = "singure_img";
    String ID             = "id";

    //七牛上传图片相关
     String KQINIUACCESSKEY = "_JDHJb6srwohL8QHVDOiuQQzWJBSVIpro3cmp12z";
     String KQINIUSECRETKEY = "Sz4qf2HlC12-18sShfeM8C34HI0SNVALYIUqDjx1";
     String BUCKET          = "pbox";
     String QINIUKEYAUIDO   = "pbox/bzmapp/auido/";
     String QINIUKEYPHOTO   = "pbox/bzmapp/photo/";
//     String PBOX = "http://oupr38wgo.bkt.clouddn.com/";//七牛
     String PBOX = "http://qiniu.bzmaster.cn/";//七牛

    //保险公司类型
    //商业险
    int BUSSINESS_INS=1;
    //交强险
    int COMPLUSORY_INS=2;
    //新车销售电话
    String SALE_MOBILE="13522270111";


    //微信支付相关
    String APP_ID="";



    String[][] MIME_MapTable = {
            // {后缀名，MIME类型}
            {".3gp", "video/3gpp"},
            {".apk", "application/vnd.android.package-archive"},
            {".asf", "video/x-ms-asf"},
            {".avi", "video/x-msvideo"},
            {".bin", "application/octet-stream"},
            {".bmp", "image/bmp"},
            {".c", "text/plain"},
            {".class", "application/octet-stream"},
            {".conf", "text/plain"},
            {".cpp", "text/plain"},
            {".doc", "application/msword"},
            {".docx",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
            {".xls", "application/vnd.ms-excel"},
            {".xlsx",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            {".exe", "application/octet-stream"},
            {".gif", "image/gif"},
            {".gtar", "application/x-gtar"},
            {".gz", "application/x-gzip"},
            {".h", "text/plain"},
            {".htm", "text/html"},
            {".html", "text/html"},
            {".jar", "application/java-archive"},
            {".java", "text/plain"},
            {".jpeg", "image/jpeg"},
            {".jpg", "image/jpeg"},
            {".js", "application/x-javascript"},
            {".log", "text/plain"},
            {".m3u", "audio/x-mpegurl"},
            {".m4a", "audio/mp4a-latm"},
            {".m4b", "audio/mp4a-latm"},
            {".m4p", "audio/mp4a-latm"},
            {".m4u", "video/vnd.mpegurl"},
            {".m4v", "video/x-m4v"},
            {".mov", "video/quicktime"},
            {".mp2", "audio/x-mpeg"},
            {".mp3", "audio/x-mpeg"},
            {".mp4", "video/mp4"},
            {".mpc", "application/vnd.mpohun.certificate"},
            {".mpe", "video/mpeg"},
            {".mpeg", "video/mpeg"},
            {".mpg", "video/mpeg"},
            {".mpg4", "video/mp4"},
            {".mpga", "audio/mpeg"},
            {".msg", "application/vnd.ms-outlook"},
            {".ogg", "audio/ogg"},
            {".pdf", "application/pdf"},
            {".png", "image/png"},
            {".pps", "application/vnd.ms-powerpoint"},
            {".ppt", "application/vnd.ms-powerpoint"},
            {".pptx",
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
            {".prop", "text/plain"}, {".rc", "text/plain"},
            {".rmvb", "audio/x-pn-realaudio"}, {".rtf", "application/rtf"},
            {".sh", "text/plain"}, {".tar", "application/x-tar"},
            {".tgz", "application/x-compressed"}, {".txt", "text/plain"},
            {".wav", "audio/x-wav"}, {".wma", "audio/x-ms-wma"},
            {".wmv", "audio/x-ms-wmv"},
            {".wps", "application/vnd.ms-works"}, {".xml", "text/plain"},
            {".z", "application/x-compress"},
            {".zip", "application/x-zip-compressed"}, {"", "*/*"}};


}
