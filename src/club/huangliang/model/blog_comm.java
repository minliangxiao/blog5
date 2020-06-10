package club.huangliang.model;
/*
* 博客评论的实体类
* */
public class blog_comm {
    private String commid;
    private String blogid;
    private String userid;
    private String re_title;
    private String re_content;
    private String username;
    private  String commtime;

    @Override
    public String toString() {
        return "blog_comm{" +
                "commid='" + commid + '\'' +
                ", blogid='" + blogid + '\'' +
                ", userid='" + userid + '\'' +
                ", re_title='" + re_title + '\'' +
                ", re_content='" + re_content + '\'' +
                ", username='" + username + '\'' +
                ", commtime='" + commtime + '\'' +
                '}';
    }

    public String getCommtime() {
        return commtime;
    }

    public void setCommtime(String commtime) {
        this.commtime = commtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommid() {
        return commid;
    }

    public void setCommid(String commid) {
        this.commid = commid;
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRe_title() {
        return re_title;
    }

    public void setRe_title(String re_title) {
        this.re_title = re_title;
    }

    public String getRe_content() {
        return re_content;
    }

    public void setRe_content(String re_content) {
        this.re_content = re_content;
    }

    //构造方法先只构造个无参构造

    public blog_comm() {
    }
}
