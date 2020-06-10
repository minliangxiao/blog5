package club.huangliang.model;
/*
* 这个公告实体类
*
* */
public class discuss {
    private String discussid;
    private String discuss_title;
    private String discuss_content;
    private String discuss_time;
    private String adminid;
    private Integer is_delete;
    private String adminname;

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    @Override
    public String toString() {
        return "discuss{" +
                "discussid='" + discussid + '\'' +
                ", discuss_title='" + discuss_title + '\'' +
                ", discuss_content='" + discuss_content + '\'' +
                ", discuss_time='" + discuss_time + '\'' +
                ", adminid='" + adminid + '\'' +
                ", is_delete=" + is_delete +
                ", adminname='" + adminname + '\'' +
                '}';
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getDiscussid() {
        return discussid;
    }

    public void setDiscussid(String discussid) {
        this.discussid = discussid;
    }

    public String getDiscuss_title() {
        return discuss_title;
    }

    public void setDiscuss_title(String discuss_title) {
        this.discuss_title = discuss_title;
    }

    public String getDiscuss_content() {
        return discuss_content;
    }

    public void setDiscuss_content(String discuss_content) {
        this.discuss_content = discuss_content;
    }

    public String getDiscuss_time() {
        return discuss_time;
    }

    public void setDiscuss_time(String discuss_time) {
        this.discuss_time = discuss_time;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }


    public discuss() {
    }
}
