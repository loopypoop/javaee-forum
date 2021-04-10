package uni.iitu.beans;

import java.util.Date;
import java.util.List;

public class PostBean implements java.io.Serializable {
    private Integer id;
    private String content;
    private Date publishedDate;
    private Integer userId;
    private UserBean user;
    private List<CommentBean> comments;

    public PostBean() {
    }

    public PostBean(Integer id, String content, Date publishedDate, Integer userId, UserBean user) {
        this.id = id;
        this.content = content;
        this.publishedDate = publishedDate;
        this.userId = userId;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<CommentBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentBean> comments) {
        this.comments = comments;
    }
}
