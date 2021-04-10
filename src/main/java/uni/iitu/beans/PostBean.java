package uni.iitu.beans;

public class PostBean implements java.io.Serializable {
    private Integer id;
    private String title;
    private String content;
    private String userId;

    public PostBean(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
