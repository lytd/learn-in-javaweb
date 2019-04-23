package td.learn.learnj2ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //打印初始化参数

        System.out.println("-----------------------全局初始化参数：");
        Enumeration<String> t1 = getServletContext().getInitParameterNames();
        while (t1.hasMoreElements()) {
            String name = t1.nextElement();
            System.out.println("Contextname:" + name + "  Contextvalue:" + getInitParameter(name));

        }

        System.out.println("--------------------共享数据测试");


        Enumeration<String> t2 = getServletContext().getAttributeNames();
        while (t2.hasMoreElements()) {
            String name = t2.nextElement();
            System.out.println("数据名:" + name + "  值:" + getServletContext().getAttribute(name));

        }

        System.out.println("---------------web资源测试");
        try (InputStream in = getServletContext().getResourceAsStream("/WEB-INF/res/my.txt");
             InputStreamReader isr = new InputStreamReader(in);
             BufferedReader br = new BufferedReader(isr);) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("----------------web资源路径测试");

        getServletContext().getResourcePaths("/").stream().forEach(System.out::println);


        System.out.println("---------------转发测试");


        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
