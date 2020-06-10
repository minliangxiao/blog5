package club.huangliang.model;

public class useravatar {
    private String id;
    private String userid;
    private String username;
    private String useravatar;

    @Override
    public String toString() {
        return "useravatar{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", useravatar='" + useravatar + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    public useravatar() {
    }
}
