package club.huangliang.model;
/*
* 这是管理源信息的实体类
* */
public class admin_ba_info {
    private String adminid;
    private String adminname;
    private String adminpwd;
    private String adminsex;
    private String adminlevel;
    private String admin_createtime;

    public admin_ba_info(String adminname, String adminpwd) {
        this.adminname = adminname;
        this.adminpwd = adminpwd;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    public String getAdminsex() {
        return adminsex;
    }

    public void setAdminsex(String adminsex) {
        this.adminsex = adminsex;
    }

    public String getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(String adminlevel) {
        this.adminlevel = adminlevel;
    }

    public String getAdmin_createtime() {
        return admin_createtime;
    }

    public void setAdmin_createtime(String admin_createtime) {
        this.admin_createtime = admin_createtime;
    }

    @Override
    public String toString() {
        return "admin_ba_info{" +
                "adminid='" + adminid + '\'' +
                ", adminname='" + adminname + '\'' +
                ", adminpwd='" + adminpwd + '\'' +
                ", adminsex='" + adminsex + '\'' +
                ", adminlevel='" + adminlevel + '\'' +
                ", admin_createtime='" + admin_createtime + '\'' +
                '}';
    }

    public admin_ba_info() {
    }
}
