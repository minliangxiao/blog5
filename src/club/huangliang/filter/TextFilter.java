package club.huangliang.filter;

import javax.servlet.*;
import java.io.IOException;

public class TextFilter implements Filter {
    //全局变量
    String encoding=null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断下字符编码集是否为空
        if (encoding != null) {
            req.setCharacterEncoding(encoding);//设置request字符编码集
            resp.setContentType("text/html;charset="+encoding);//设置response字符编码集
        }
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        /* 获取web.xml里面配置的初始化参数 */
        switch (encoding = config.getInitParameter("encoding")) {
        }
    }

}
