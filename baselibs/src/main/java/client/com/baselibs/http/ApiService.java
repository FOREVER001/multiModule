package client.com.baselibs.http;

import java.util.Map;

import client.com.baselibs.http.handlereult.HttpResult;
import client.com.baselibs.http.model.module3.MeiziModel;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created on 2018/1/30 17:57.
 *
 * @author zxh
 * @version 1.0
 */

public interface ApiService {
    String GANK_HOST = "use_host:gank";
    String WAN_HOST = "use_host:wan";
    /**
     意见反馈
     * */
    /**
     * 福利
     *
     * @param page page
     * @return List<MeiZi>
     */
    @Headers(GANK_HOST)
    @GET("api/data/福利/" + 20 + "/{page}")
    Observable<MeiziModel> getGankData(@Path("page") int page);
}
