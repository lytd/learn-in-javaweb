package td.learn.learnj2ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求测试
        System.out.println("-------------------请求行测试");
        System.out.println("协议：" + request.getProtocol());

        System.out.println("path:" + request.getContextPath());
        System.out.println("url:" + request.getRequestURL());
        System.out.println("query:" + request.getQueryString());
        System.out.println("-------------------请求头测试");
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements()){
            System.out.println(headers.nextElement());
        }
        System.out.println("-------------------请求体测试，懒得写");

        System.out.println("---------------------重定向测试");
        String loc=request.getParameter("loc");

        switch(loc){
            case "baidu":
                loc="http://www.baidu.com";
                break;
           default:
               loc="/jsp/index1.jsp";
        }
        System.out.println(loc);
        //响应测试
        response.sendRedirect(loc);



    }
}
