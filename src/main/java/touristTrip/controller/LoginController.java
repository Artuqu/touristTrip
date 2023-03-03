package touristTrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @PostMapping("/logout")
    public ModelAndView logoutGetPage(ModelAndView mav) {
        mav.setViewName("login/logout");
        return mav;
    }

    @GetMapping("/addUser")
    public ModelAndView saveUser(ModelAndView mav){
        mav.setViewName("/users/addUser");
        return mav;
    }

    @PostMapping("/addUser")
    public ModelAndView saveUserPost(ModelAndView mav, User user) {
        mav.setViewName("redirect:/login");
        mav.addObject(detailsService.saveUser(user));
        return mav;
    }
}
