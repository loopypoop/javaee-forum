package uni.iitu.dao;

import uni.iitu.beans.PostBean;
import uni.iitu.beans.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDao {

    DbConnection db = new DbConnection();

    public List<PostBean> getPosts()
        throws SQLException, ClassNotFoundException {
        List<PostBean> posts = new ArrayList<>();
        UserDao userDao = new UserDao();

        String sql = "SELECT * FROM posts";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            Date publishedDate = resultSet.getDate("published_date");
            Integer userId = resultSet.getInt("user_id");
            UserBean user = userDao.getUserById(userId);

            PostBean post = new PostBean(id, content, publishedDate, userId, user);

            posts.add(post);
        }

        resultSet.close();
        statement.close();;
        connection.close();

        return posts;
    }

    public PostBean getPostById(Integer id) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();
        CommentDao commentDao = new CommentDao();

        String sql = "SELECT * FROM posts WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        PostBean post = new PostBean();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        post.setUserId(resultSet.getInt("user_id"));
        post.setPublishedDate(resultSet.getDate("published_date"));
        post.setContent(resultSet.getString("content"));
        post.setUser(userDao.getUserById(resultSet.getInt("user_id")));
        post.setId(id);
        post.setComments(commentDao.getAllByPostId(id));

        return post;
    }
}
