package client.com.baselibs.http.handlereult;

/**
 * Created on 2018/1/31 10:48.
 *
 * @author zxh
 * @version 1.0
 */

public class HttpResult<T> {

    private int errorCode;
    private String errorMsg;
    private T  data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg == null ? "" : errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
