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

            java.sql.Date sqlDate = new java.sql.Date(publishedDate.getTime());

            CommentBean comment = new CommentBean(id, likes, postId, userId, content, sqlDate, user);

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

            java.sql.Date sqlDate = new java.sql.Date(publishedDate.getTime());

            CommentBean comment = new CommentBean(id, likes, postId, userId, content, sqlDate, user);

            comments.add(comment);
        }

        return comments;
    }

    public int createComment(CommentBean comment) {

        String sql = "INSERT INTO comments (content, published_date, like_counter, post_id, user_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        int res = 0;

        try {
            Connection connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, comment.getContent());
            statement.setDate(2, comment.getPublishedDate());
            statement.setInt(3, comment.getLikes());
            statement.setInt(4, comment.getPostId());
            statement.setInt(5, comment.getUserId());

            res = statement.executeUpdate();

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }

    public boolean likeComment(CommentBean comment) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE comments SET like_counter = ? WHERE id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, comment.getLikes());
        statement.setInt(2, comment.getId());

        boolean liked = statement.executeUpdate() > 0;
        statement.close();
        connection.close();

        return liked;
    }

    public CommentBean getCommentById(Integer id) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();

        String sql = "SELECT * FROM comments WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        CommentBean comment = new CommentBean();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        comment.setId(id);
        comment.setUserId(resultSet.getInt("user_id"));
        comment.setContent(resultSet.getString("content"));
        comment.setLikes(resultSet.getInt("like_counter"));
        comment.setPublishedDate(resultSet.getDate("published_date"));
        comment.setPostId(resultSet.getInt("post_id"));

        return comment;
    }
}
