package td.learn.learnj2ee.filter;

import javax.servlet.*;

public class FirstFilter implements Filter {
    @Override
    public void destroy() {
        System.err.println("FirstFilter 被销毁了");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, java.io.IOException {
        System.out.println("FirstFilter 开始过滤");
        chain.doFilter(req, resp);
        System.out.println("FirstFilter 过滤结束");

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.err.println("FirstFilter init");

    }

}
