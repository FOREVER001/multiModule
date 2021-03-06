package com.alibaba.android.arouter.routes;

import client.com.module_1.ui.Module1Activity;
import client.com.module_1.ui.provider.HomeServiceImpl;
import client.com.module_1.ui.ui.detail.WebDetailActivity;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER. */
public class ARouter$$Group$$module1 implements IRouteGroup {
  @Override
  public void loadInto(Map<String, RouteMeta> atlas) {
    atlas.put("/module1/articleDetailActivity", RouteMeta.build(RouteType.ACTIVITY, WebDetailActivity.class, "/module1/articledetailactivity", "module1", null, -1, -2147483648));
    atlas.put("/module1/homeFragmentService", RouteMeta.build(RouteType.PROVIDER, HomeServiceImpl.class, "/module1/homefragmentservice", "module1", null, -1, -2147483648));
    atlas.put("/module1/module1Activity", RouteMeta.build(RouteType.ACTIVITY, Module1Activity.class, "/module1/module1activity", "module1", null, -1, -2147483648));
  }
}
