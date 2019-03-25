package client.com.baselibs.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import client.com.baselibs.event.NetworkChangeEvent;
import client.com.baselibs.utils.NetUtils;

/**
 * 网络连接状态变化广播
 * @author zxh17
 * @version 1.0
 * */
public class NetworkConnectChangedReceiver extends BroadcastReceiver{
    private static final String TAG = "NetworkConnectChanged";
    @Override
    public void onReceive(Context context, Intent intent) {
        //**判断当前的网络连接状态是否可用*/
        boolean isConnected = NetUtils.isConnected(context);
        Log.d(TAG, "onReceive: 当前网络 " + isConnected);
        EventBus.getDefault().post(new NetworkChangeEvent(isConnected));
    }
}
