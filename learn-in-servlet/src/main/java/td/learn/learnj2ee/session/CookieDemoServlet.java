package td.learn.learnj2ee.session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CookieDemoServlet extends HttpServlet {

    private Map<String,String> names=new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断是否有Cookie
        Cookie[] cookies=request.getCookies();

            System.out.println("浏览器中由cookie");
            for (Cookie cookie : cookies) {

                System.out.println("当前cookie的名称为:" + cookie.getName());
                System.out.println("当前cookie的值为:" + cookie.getValue());
                System.out.println("当前cookie的最大过期时间为:" + cookie.getMaxAge());
            }

            //从参数中获取
            String name = request.getParameter("name");
            String value = request.getParameter("value");

            if(Arrays.stream(cookies).filter(c-> c.getName().equals(name)).count()==0){
                Cookie cookie=new Cookie(name,value);
                //设置过期时间
                cookie.setMaxAge(600);
                System.out.println("----------"+cookie.getMaxAge());
                response.addCookie(cookie);
            }






    }

}
