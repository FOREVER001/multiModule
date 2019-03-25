package client.com.module_5.data;

public class UpdateInfoEvent {
    private String username;

    public UpdateInfoEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username == null ? "" : username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
