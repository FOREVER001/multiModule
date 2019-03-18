// Generated code from Butter Knife. Do not modify!
package client.com.module_1.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import client.com.module_1.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Module1Activity_ViewBinding implements Unbinder {
  private Module1Activity target;

  private View view2131493033;

  private View view2131493034;

  @UiThread
  public Module1Activity_ViewBinding(Module1Activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Module1Activity_ViewBinding(final Module1Activity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_module1, "field 'tvModule1' and method 'onViewClicked'");
    target.tvModule1 = Utils.castView(view, R.id.tv_module1, "field 'tvModule1'", TextView.class);
    view2131493033 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_test, "field 'tvTest' and method 'onViewClicked'");
    target.tvTest = Utils.castView(view, R.id.tv_test, "field 'tvTest'", Button.class);
    view2131493034 = view;
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
    Module1Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvModule1 = null;
    target.tvTest = null;

    view2131493033.setOnClickListener(null);
    view2131493033 = null;
    view2131493034.setOnClickListener(null);
    view2131493034 = null;
  }
}
