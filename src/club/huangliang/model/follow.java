package club.huangliang.model;
/*
* 关注列表的实体类
*
* */
public class follow {
    private String id;
    private String user_name;
    private String qqnumber;
    private String nickname;
    private String desc;
    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "follow{" +
                "id='" + id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", qqnumber='" + qqnumber + '\'' +
                ", nickname='" + nickname + '\'' +
                ", desc='" + desc + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public follow() {
    }
}
