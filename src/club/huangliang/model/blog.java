package club.huangliang.model;

import java.util.Arrays;

/*
* 这是博客实体类
* */
public class blog {
   private String blog_id;
   private String blog_context;
   private String blog_name;
   private String blog_titile;
   private String blog_createtime;
   private String  blog_type;//博客种类
   private Integer blog_keyword;//博客关键词
   private Integer blog_renumber;//博客浏览人数
   private Integer  blog_hot;//点赞人数（还在考虑用不用这个功能）
   private String userid;
   private Integer is_tuijian;//是否推荐的标识位
   public   blog_photo photos = new blog_photo();//这样写不知道有没有问题

    public Integer getBlog_hot() {
        return blog_hot;
    }

    public void setBlog_hot(Integer blog_hot) {
        this.blog_hot = blog_hot;
    }

    @Override
    public String toString() {
        return "blog{" +
                "blog_id='" + blog_id + '\'' +
                ", blog_context='" + blog_context + '\'' +
                ", blog_name='" + blog_name + '\'' +
                ", blog_titile='" + blog_titile + '\'' +
                ", blog_createtime='" + blog_createtime + '\'' +
                ", blog_type='" + blog_type + '\'' +
                ", blog_keyword=" + blog_keyword +
                ", blog_renumber=" + blog_renumber +
                ", blog_hot=" + blog_hot +
                ", userid='" + userid + '\'' +
                ", is_tuijian=" + is_tuijian +
                ", photos=" + photos +
                '}';
    }


    public blog_photo getPhotos() {
        return photos;
    }

    public Integer getIs_tuijian() {
        return is_tuijian;
    }

    public void setIs_tuijian(Integer is_tuijian) {
        this.is_tuijian = is_tuijian;
    }

    public String getBlog_id() {
        return blog_id;
    }

    public String getBlog_context() {
        return blog_context;
    }

    public String getBlog_name() {
        return blog_name;
    }

    public String getBlog_titile() {
        return blog_titile;
    }

    public String getBlog_createtime() {
        return blog_createtime;
    }

    public String getBlog_type() {
        return blog_type;
    }

    public Integer getBlog_keyword() {
        return blog_keyword;
    }

    public void setBlog_keyword(Integer blog_keyword) {
        this.blog_keyword = blog_keyword;
    }

    public Integer getBlog_renumber() {
        return blog_renumber;
    }

    public void setBlog_renumber(Integer blog_renumber) {
        this.blog_renumber = blog_renumber;
    }


    public String getUserid() {
        return userid;
    }

    public void setBlog_id(String blog_id) {
        this.blog_id = blog_id;
    }

    public void setBlog_context(String blog_context) {
        this.blog_context = blog_context;
    }

    public void setBlog_name(String blog_name) {
        this.blog_name = blog_name;
    }

    public void setBlog_titile(String blog_titile) {
        this.blog_titile = blog_titile;
    }

    public void setBlog_createtime(String blog_createtime) {
        this.blog_createtime = blog_createtime;
    }

    public void setBlog_type(String blog_type) {
        this.blog_type = blog_type;
    }




    public void setUserid(String userid) {
        this.userid = userid;
    }

    //构造方法现在先只写这个无参构造
    public blog() {
    }
}
