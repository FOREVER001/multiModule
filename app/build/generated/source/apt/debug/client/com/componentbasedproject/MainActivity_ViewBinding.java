// Generated code from Butter Knife. Do not modify!
package client.com.componentbasedproject;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165225;

  private View view2131165226;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_module1, "field 'btnModule1' and method 'onViewClicked'");
    target.btnModule1 = Utils.castView(view, R.id.btn_module1, "field 'btnModule1'", Button.class);
    view2131165225 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_module2, "field 'btnModule2' and method 'onViewClicked'");
    target.btnModule2 = Utils.castView(view, R.id.btn_module2, "field 'btnModule2'", Button.class);
    view2131165226 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnModule1 = null;
    target.btnModule2 = null;

    view2131165225.setOnClickListener(null);
    view2131165225 = null;
    view2131165226.setOnClickListener(null);
    view2131165226 = null;
  }
}
