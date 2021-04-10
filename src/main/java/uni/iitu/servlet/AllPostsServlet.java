package uni.iitu.servlet;

import uni.iitu.beans.PostBean;
import uni.iitu.dao.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/posts")
public class AllPostsServlet extends HttpServlet {

    public AllPostsServlet() { super(); }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        PostDao postDao = new PostDao();

        try {
            List<PostBean> postList = postDao.getPosts();
            request.setAttribute("postList", postList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("posts.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
