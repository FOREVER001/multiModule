package client.com.baselibs.provider;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;
/**
 * 项目页面暴露的服务接口
 * @author zxh17
 * @version 1.0
 * */
public interface ProjectService extends IProvider{
      Fragment getProjectFragment();
}
