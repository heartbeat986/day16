package day16;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/demo")
public class HttpDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post请求");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        try {

            boolean result = Data.checkUser(name,password);
            if(result){
                req.getRequestDispatcher("/success").forward(req,resp);
            }else {
                System.out.printf("用户名错误");
                req.getRequestDispatcher("/fail").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

