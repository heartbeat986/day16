package day16;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fail")
public class FailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("失败了");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("GET:登录失败了，请重新输入");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("失败了");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("POST:登录失败了，请重新输入");
    }
}
