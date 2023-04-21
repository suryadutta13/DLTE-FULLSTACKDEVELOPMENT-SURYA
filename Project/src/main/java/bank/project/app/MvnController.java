package bank.project.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//request mapping for url's
@RequestMapping("/web")//url
public class MvnController {
    @GetMapping("/login") //url for login page
    public String login(){
        return "login";
    }
    @GetMapping("/dashboard") //url for dashboard page
    public String dashboard(){
        return "dashboard";
    }
    @GetMapping("/profile") //yrl for updating profile
    public String profile(){return "profile";}
}

