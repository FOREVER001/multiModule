// Generated code from Butter Knife. Do not modify!
package client.com.module_1.ui.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import client.com.module_1.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  @UiThread
  public HomeFragment_ViewBinding(HomeFragment target, View source) {
    this.target = target;

    target.rvMain = Utils.findRequiredViewAsType(source, R.id.rv_main, "field 'rvMain'", RecyclerView.class);
    target.smartRefresh = Utils.findRequiredViewAsType(source, R.id.smart_refresh, "field 'smartRefresh'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvMain = null;
    target.smartRefresh = null;
  }
}
