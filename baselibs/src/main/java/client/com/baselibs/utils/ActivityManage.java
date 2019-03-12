package client.com.baselibs.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Name: ActivityManage
 * Author: zxh17
 * Email:
 * Comment: activity的管理类
 * Date: 2018-07-27 09:58
 *
 */public    class ActivityManage   {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
