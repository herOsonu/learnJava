import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "AFilter",urlPatterns = "/*",dispatcherTypes = DispatcherType.REQUEST)
/*
* 在web.xml中的执行顺序取决于mapping的顺序
* */
public class AFilter implements javax.servlet.Filter {
    private FilterConfig filterConfig;
    /**
     * 销毁之前执行，服务器关闭时销毁，用来做对非内存资源进行释放
     */
    public void destroy() {
    }

    /**
     * 每次过滤是都会执行
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截器进行拦截");
        req.setCharacterEncoding("utf-8");
        //1.得到application中的map
        //2.从request中得到当前客户端的ip地址
        ServletContext context=filterConfig.getServletContext();
        Map<String,Integer>map=(Map<String, Integer>) context.getAttribute("map");
        String ip=req.getRemoteAddr();
        if(map.containsKey(ip)){
            int cnt=map.get(ip);
            map.put(ip,cnt+1);
        }else {
            map.put(ip,1);
        }
        context.setAttribute("map",map);

        chain.doFilter(req, resp);//放行
        System.out.println("回来了");//放行后的代码会执行
    }

    /**
     * 创建后马上执行，用来做初始化，服务器启动时
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        /*与servletConfig相似，
        * 提供的方法类似
        *
        * */
        System.out.println("f1");

        this.filterConfig=config;

    }

}

//Filter是单例的