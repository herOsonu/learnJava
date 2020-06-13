package controller;

import domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IAccountService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/accountController")
public class AccountController {

    @Resource
    private IAccountService accountService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,Model model,HttpServletRequest request){
        Account account=new Account();
        account.setUsername(username);
        account.setPassword(password);
        if(accountService.login(account)!=null){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            return "success";
        }else{
            model.addAttribute("error","账号或密码错误");
            return "error";
        }
    }
    @RequestMapping("/register")
    public String register(String username,String password){
        Account account=new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountService.register(account);
        return "login";
    }
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/infoModify")
    public String infoModify(String password,HttpServletRequest request){
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        Account account=new Account();
        account.setUsername(username);
        account.setPassword(password);
        System.out.println(username);
        System.out.println("---------------------------------------------------------");
        accountService.infoModify(account);
        return "login";
    }
}
