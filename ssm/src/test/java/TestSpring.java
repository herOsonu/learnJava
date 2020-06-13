import dao.IAccountDao;
import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.AccountServiceImpl;

import java.io.InputStream;
import java.util.List;

public class TestSpring {
    @Test
    public void testService(){
        //加载配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountServiceImpl accountService=(AccountServiceImpl) ac.getBean("accountService");

        /*accountService.login();*/
    }
    @Test
    public void test2()throws Exception{
        //加载配置文件
        InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session=factory.openSession();
        //获取到代理对象
        IAccountDao dao=session.getMapper(IAccountDao.class);
        //查询所有数据
        Account account=new Account();
        account.setPassword("sdf");
        account.setUsername("zhangkaixin");
        /*dao.reg(account);*/
        //提交事务
        session.commit();

        session.close();
        in.close();

    }
}
