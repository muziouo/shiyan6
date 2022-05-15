package muzi;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter{

    private String encoding;

    @Override
    public void destroy() {
        this.encoding =null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (encoding != null) {
            request.setCharacterEncoding(this.encoding);/*相应的数据编码格式*/
            response.setContentType("text/html;charset=" + encoding);/*告诉浏览器本次相应的数据类型*/
        }
        /*
         * 在过滤器对象的doFilter()方法中，业务逻辑处理完成之后，
         * 需要通过FilterChain对象的doFilter()方法将请求传递到下一过滤器或目标资源，否则将出现错误。
         */
        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

}

