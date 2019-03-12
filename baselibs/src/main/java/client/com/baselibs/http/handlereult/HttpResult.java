package client.com.baselibs.http.handlereult;

/**
 * Created on 2018/1/31 10:48.
 *
 * @author zxh
 * @version 1.0
 */

public class HttpResult<T> {

    private int Code;
    private String Msg;
    private T  data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMsg() {
        return Msg == null ? "" : Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
