package club.huangliang.model;
/*
* 这是用于存放博客照片路径的实体类
* */
public class blog_photo {

    private String photoid;
    private String photo_address;
    private String photo_desc;
    private String photo_time;
    private String blogid;

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getPhoto_address() {
        return photo_address;
    }

    public void setPhoto_address(String photo_address) {
        this.photo_address = photo_address;
    }

    public String getPhoto_desc() {
        return photo_desc;
    }

    public void setPhoto_desc(String photo_desc) {
        this.photo_desc = photo_desc;
    }

    public String getPhoto_time() {
        return photo_time;
    }

    public void setPhoto_time(String photo_time) {
        this.photo_time = photo_time;
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    @Override
    public String toString() {
        return "blog_photo{" +
                "photoid='" + photoid + '\'' +
                ", photo_address='" + photo_address + '\'' +
                ", photo_desc='" + photo_desc + '\'' +
                ", photo_time='" + photo_time + '\'' +
                ", blogid='" + blogid + '\'' +
                '}';
    }
    //先只构造个无参的构造方法

    public blog_photo() {
    }

    public blog_photo(String photoid, String photo_address, String photo_desc, String photo_time, String blogid) {
        this.photoid = photoid;
        this.photo_address = photo_address;
        this.photo_desc = photo_desc;
        this.photo_time = photo_time;
        this.blogid = blogid;
    }
}
