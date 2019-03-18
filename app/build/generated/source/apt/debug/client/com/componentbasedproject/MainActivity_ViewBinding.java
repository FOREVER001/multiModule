// Generated code from Butter Knife. Do not modify!
package client.com.componentbasedproject;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", ViewPager.class);
    target.bottomnavigation = Utils.findRequiredViewAsType(source, R.id.bottomnavigation, "field 'bottomnavigation'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.bottomnavigation = null;
  }
}
