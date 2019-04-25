package td.learn.learnj2ee.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AllFilter implements Filter {
    @Override
    public void destroy() {
        System.err.println("AllFilter 被销毁了");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, java.io.IOException {
        System.out.println("AllFilter 开始过滤");
        System.out.println("请求:"+((HttpServletRequest) req).getRequestURL());
        chain.doFilter(req, resp);
        System.out.println("AllFilter 过滤结束");

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.err.println("AllFilter init");

    }

}
