package client.com.componentbasedproject;

import client.com.baselibs.provider.ChapterService;
import client.com.baselibs.provider.HomeService;
import client.com.baselibs.provider.MeiziService;
import client.com.baselibs.provider.MineService;
import client.com.baselibs.provider.ProjectService;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import java.lang.Object;
import java.lang.Override;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER. */
public class MainActivity$$ARouter$$Autowired implements ISyringe {
  private SerializationService serializationService;

  @Override
  public void inject(Object target) {
    serializationService = ARouter.getInstance().navigation(SerializationService.class);
    MainActivity substitute = (MainActivity)target;
    substitute.mHomeService = (HomeService)ARouter.getInstance().build("/module1/homeFragmentService").navigation();
    substitute.mChapterService = (ChapterService)ARouter.getInstance().build("/module2/publicArticleFragmentService").navigation();
    substitute.mMeiziService = (MeiziService)ARouter.getInstance().build("/module3/meiziFragmentService").navigation();
    substitute.mProjectService = (ProjectService)ARouter.getInstance().build("/module4/projectFragmentService").navigation();
    substitute.mMineService = (MineService)ARouter.getInstance().build("/module5/mineFragmentService").navigation();
  }
}
