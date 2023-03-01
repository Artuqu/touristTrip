package touristTrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import touristTrip.entity.User;
import touristTrip.service.JpaUserDetailsService;

@Controller
@RequestMapping("/")
public class LoginController {

    private final JpaUserDetailsService detailsService;

    @Autowired
    LoginController(JpaUserDetailsService jpaUserDetailsService) {
        this.detailsService = jpaUserDetailsService;
    }

    @GetMapping("/login")
    public ModelAndView loginGetPage(ModelAndView mav) {
        mav.setViewName("login/login");
        return mav;
    }


    @GetMapping("/logout")
    public ModelAndView logoutGetPage(ModelAndView mav) {
        mav.setViewName("login/logout");
        return mav;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public String saveUser(String username, String password, boolean enabled) {
        User user = new User(username, password, enabled);
        detailsService.saveUser(user);
        return "User with admin authority successful added.";
    }
}
