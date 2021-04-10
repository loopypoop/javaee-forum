package uni.iitu.dao;

import uni.iitu.beans.CommentBean;
import uni.iitu.beans.PostBean;
import uni.iitu.beans.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDao {

    DbConnection db = new DbConnection();

    public List<CommentBean> getComments()
        throws SQLException, ClassNotFoundException {
        List<CommentBean> comments = new ArrayList<>();
        UserDao userDao = new UserDao();

        String sql = "SELECT * FROM comments";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            Integer likes = resultSet.getInt("like_counter");
            Integer postId = resultSet.getInt("post_id");
            Integer userId = resultSet.getInt("user_id");
            String content = resultSet.getString("content");
            Date publishedDate = resultSet.getDate("published_date");

            UserBean user = userDao.getUserById(userId);

            CommentBean comment = new CommentBean(id, likes, postId, userId, content, publishedDate, user);

            comments.add(comment);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return comments;
    }

    public List<CommentBean> getAllByPostId(Integer pId) throws SQLException, ClassNotFoundException {
        List<CommentBean> comments = new ArrayList<>();
        UserDao userDao = new UserDao();

        String sql = "SELECT * FROM comments WHERE post_id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            Integer likes = resultSet.getInt("like_counter");
            Integer postId = resultSet.getInt("post_id");
            Integer userId = resultSet.getInt("user_id");
            String content = resultSet.getString("content");
            Date publishedDate = resultSet.getDate("published_date");

            UserBean user = userDao.getUserById(userId);

            CommentBean comment = new CommentBean(id, likes, postId, userId, content, publishedDate, user);

            comments.add(comment);
        }

        return comments;
    }
}
