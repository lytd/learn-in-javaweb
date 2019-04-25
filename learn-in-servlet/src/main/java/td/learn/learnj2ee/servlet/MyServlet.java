package td.learn.learnj2ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet{
    public MyServlet() {
        super();
        System.err.println("创建我的第一个servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.err.println("doget() is start");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.err.println("doget() is start");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.err.println("MyServlet destory()");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.err.println("MyServlet init()");
    }
}
