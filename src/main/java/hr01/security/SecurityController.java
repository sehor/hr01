package hr01.security;

import hr01.security.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/showme")
    public User showMe(Authentication authentication){

        User user= (User) authentication.getPrincipal();
        return user;
    }

    @GetMapping("/admin")
    String testAdminAccess(){
        return "here admin can access!";
    }

    @GetMapping("/db")
    String testDBAdminAccess(){
        return "here DBAdmin can access!";
    }

    @GetMapping("/vipUser")
    String testVpiUsrAccess(){
        return "here VpiUsers can access!";
    }

    @GetMapping("/user")
    String testUserAccess(){
        return "here normal users can access?";
    }

    @GetMapping("/guest")
    String testGuestAccess(){
        return "here guests can access?";
    }
}
