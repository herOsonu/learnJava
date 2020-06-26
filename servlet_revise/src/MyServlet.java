import com.sun.security.jgss.GSSUtil;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet implements Servlet {
    private ServletConfig servletConfig;
    /**
     * 生命周期方法，Servlet对象创建之后被执行，只执行一次,由tomcat调用，是这些方法中第一个被调用的
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
        System.out.println("init。。。");
        System.out.println(servletConfig.getServletName());
        System.out.println();
        System.out.println(servletConfig.getInitParameter("p1"));
        Enumeration<String> enumeration=servletConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig...");
        return null;
    }

    /**
     * 生命周期方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service。。。");

    }

    @Override
    public String getServletInfo() {
        System.out.println("getInfo。。。");
        return null;
    }

    /**
     * 生命周期方法,Servlet对象销毁之前被调用（遗言）,只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy。。。");

    }
}
/*
* 特性：
*       单例：1个类只有1个对象,当然可能存在多个Servlet类
*       线程是不安全的,效率高
* Servlet类由我们来写，但由服务器来创建，并由服务器来调用相应的方法
* 安全问题：
*       不创建成员，创建局部变量
*
* */
