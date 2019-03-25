package client.com.baselibs.http.model.module5;

import java.util.ArrayList;
import java.util.List;

public class LoginModel {

    /**
     * data : {"chapterTops":[],"collectIds":[],"email":"","icon":"","id":20966,"password":"","token":"","type":0,"username":"15225962303"}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * chapterTops : []
         * collectIds : []
         * email :
         * icon :
         * id : 20966
         * password :
         * token :
         * type : 0
         * username : 15225962303
         */

        private String email;
        private String icon;
        private int id;
        private String password;
        private String token;
        private int type;
        private String username;
        private List<?> chapterTops;
        private List<?> collectIds;

        public String getEmail() {
            return email == null ? "" : email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIcon() {
            return icon == null ? "" : icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassword() {
            return password == null ? "" : password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token == null ? "" : token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUsername() {
            return username == null ? "" : username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<?> getChapterTops() {
            if (chapterTops == null) {
                return new ArrayList<>();
            }
            return chapterTops;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public List<?> getCollectIds() {
            if (collectIds == null) {
                return new ArrayList<>();
            }
            return collectIds;
        }

        public void setCollectIds(List<?> collectIds) {
            this.collectIds = collectIds;
        }
    }
}
