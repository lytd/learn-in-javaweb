package td.learn.learnj2ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.stream.Stream;

public class InitParamServlet extends HttpServlet {
    public InitParamServlet() {
        System.err.println("InitParamServlet启动");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.err.println("获取初始化参数开始");

        System.out.println("servletName:" + getServletName());
        Enumeration<String> t = getInitParameterNames();
       while(t.hasMoreElements()){
           String name=t.nextElement();
           System.out.println("name:" + name + "  value:" + getInitParameter(name));

       }

        System.out.println("全局初始化参数：");
        Enumeration<String> t1 = getServletContext().getInitParameterNames();
        while(t1.hasMoreElements()){
            String name=t1.nextElement();
            System.out.println("Contextname:" + name + "  Contextvalue:" + getServletContext().getInitParameter(name));

        }
        long l=System.currentTimeMillis();
        getServletContext().setAttribute("InitParamServlet",l);

    }
}
