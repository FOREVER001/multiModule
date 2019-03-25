package client.com.baselibs.event;
/**
 * event网络变化的事件
 * @author zxh17
 * @version 1.0
 * */
public class NetworkChangeEvent {
    public boolean isConnected; //是否存在网络

    public NetworkChangeEvent(boolean isConnected) {
        this.isConnected = isConnected;
    }
}
