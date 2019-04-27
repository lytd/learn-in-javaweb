package td.learn.learnj2ee.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class UserSessionServlet extends HttpServlet {

    List<String> users=new ArrayList<>();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取请求中SessionId
        HttpSession session = request.getSession();
        String sid=session.getId();
        if (users.contains(sid)){
            //
            Enumeration<String> names = session.getAttributeNames();
            System.out.println("---------------sid:" + sid);
            while(names.hasMoreElements()){
                String name=names.nextElement();
                System.out.println(name + "属性 :" + session.getAttribute(name));

            }


        }else {
            System.out.println("没有该session信息");
            String name = request.getParameter("name");
            String age = request.getParameter("age");

            session.setAttribute("name", name);
            session.setAttribute("age", age);
            users.add(sid);
        }



        Cookie cookie=new Cookie("jsessionid",sid);

        response.addCookie(cookie);



    }
}
