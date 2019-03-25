// Generated code from Butter Knife. Do not modify!
package client.com.module_1.ui.ui.detail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import client.com.baselibs.widget.MyX5WebView;
import client.com.module_1.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebDetailActivity_ViewBinding implements Unbinder {
  private WebDetailActivity target;

  @UiThread
  public WebDetailActivity_ViewBinding(WebDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebDetailActivity_ViewBinding(WebDetailActivity target, View source) {
    this.target = target;

    target.appbarlayout = Utils.findRequiredViewAsType(source, R.id.appbarlayout, "field 'appbarlayout'", AppBarLayout.class);
    target.webviewDetail = Utils.findRequiredViewAsType(source, R.id.webview_detail, "field 'webviewDetail'", MyX5WebView.class);
    target.llContent = Utils.findRequiredViewAsType(source, R.id.ll_content, "field 'llContent'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.appbarlayout = null;
    target.webviewDetail = null;
    target.llContent = null;
  }
}
