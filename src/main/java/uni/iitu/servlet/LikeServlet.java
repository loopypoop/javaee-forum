package uni.iitu.servlet;

import uni.iitu.beans.CommentBean;
import uni.iitu.beans.PostBean;
import uni.iitu.dao.CommentDao;
import uni.iitu.dao.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {

    public LikeServlet() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentDao commentDao = new CommentDao();
        PostDao postDao = new PostDao();

        Boolean isLiked = Boolean.valueOf(req.getParameter("like"));
        Integer commentId = Integer.parseInt(req.getParameter("commentId"));

        try {
            CommentBean comment = commentDao.getCommentById(commentId);
            if (isLiked)
                comment.setLikes(comment.getLikes() + 1);
            commentDao.likeComment(comment);

            PostBean post = postDao.getPostById(comment.getPostId());

            req.setAttribute("post", post);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("particular.jsp");
            requestDispatcher.forward(req, resp);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
