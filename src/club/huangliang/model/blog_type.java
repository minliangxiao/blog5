package club.huangliang.model;
/*
* 这是用于存放博客种类的实体类
* */
public class blog_type {
    private String typeid;
    private String typename;
    private String desc;

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "blog_type{" +
                "typeid='" + typeid + '\'' +
                ", typename='" + typename + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    //先构造一个无参的构造方法
    public blog_type() {
    }
}
