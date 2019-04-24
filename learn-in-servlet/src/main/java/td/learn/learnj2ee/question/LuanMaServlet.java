package td.learn.learnj2ee.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LuanMaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("设置UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println("接收到参数name：" + name);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("接收到参数name：" + name);


        //System.out.println("由于tomcat默认使用ISO8859-1,所以使用ISO8859-1字符集进行解码,获得原始码");
       /* byte[] base = name.getBytes("ISO8859-1");

        System.out.println("然后使用UTF-8进行编码");
        System.out.println("解码后name:" + new String(base, "UTF-8"));*/


        //处理时,会抛异常
        //response.getOutputStream().print("测试");
        //response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这样就没有问题
        //response.getOutputStream().write(name.getBytes("UTF-8"));
        //通知tomcat使用此字符集
        System.out.println("utf-8");
        //response.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=utf-8");
        //
        response.getWriter().print(name);


    }
}
