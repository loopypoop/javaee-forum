package uni.iitu.servlet;

import uni.iitu.beans.PostBean;
import uni.iitu.dao.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ParticularPostServlet extends HttpServlet {

    public ParticularPostServlet() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostDao postDao = new PostDao();

        try {
            Integer postId = 0;

            if (req.getParameter("postId") != null) {
                postId = Integer.parseInt(req.getParameter("postId"));
            }
            PostBean post = postDao.getPostById(postId);

            req.setAttribute("post", post);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("particular.jsp");
            requestDispatcher.forward(req, resp);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
