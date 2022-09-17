package touristTrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import touristTrip.service.JpaTouristService;

@Controller
@RequestMapping("/details")
public class DetailsController {

    private final JpaTouristService jpaTouristService;

    @Autowired
    DetailsController(JpaTouristService jpaTouristService){
        this.jpaTouristService=jpaTouristService;
    }

    @GetMapping("")
    public ModelAndView getDetailsView(ModelAndView modelAndView){
        modelAndView.setViewName("/details");
        modelAndView.addObject("");
        return modelAndView;
    }


}
