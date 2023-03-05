package touristTrip.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    @GetMapping("/addUser")
    public ModelAndView saveUser(ModelAndView mav) {
        mav.addObject("user", new User());
        mav.setViewName("/users/addUser");
        return mav;
    }

    @PostMapping("/addUser")
    public ModelAndView saveUserPost(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("users/addUser");
        }
        try {
            this.detailsService.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            ObjectError error = new ObjectError("DuplicateError", "Username " + user.getUsername() + " already exist!");
            result.addError(error);
            return new ModelAndView("users/addUser");
        }
        return new ModelAndView("redirect:/login");
    }
}