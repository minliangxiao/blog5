package club.huangliang.model;

/*
 * 用于存放用户的基础信息的实体类
 */
public class User_da_info {
    private String userid;
    private String username;
    private String userpwd;
    private String userstatus;
    private String user_createtime;
    private String user_lock;
    private String userdelet;
    private String email;
    private String qq;

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

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getUser_createtime() {
        return user_createtime;
    }

    public void setUser_createtime(String user_createtime) {
        this.user_createtime = user_createtime;
    }

    public String getUser_lock() {
        return user_lock;
    }

    public void setUser_lock(String user_lock) {
        this.user_lock = user_lock;
    }

    public String getUserdelet() {
        return userdelet;
    }

    public void setUserdelet(String userdelet) {
        this.userdelet = userdelet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "User_da_info [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", userstatus="
                + userstatus + ", user_createtime=" + user_createtime + ", user_lock=" + user_lock + ", userdelet="
                + userdelet + ", email=" + email + ", qq=" + qq + "]";
    }

    /*
     * 构造方法方面可以多思考思考
     */
    public User_da_info(String username, String userpwd) {
        super();
        this.username = username;
        this.userpwd = userpwd;
    }

    public User_da_info() {

    }


}
