package touristTrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TripController {


    @GetMapping("/addTrip")
    public ModelAndView getTripView(ModelAndView mav) {
        mav.setViewName("/trip/addTrip");
        return mav;
    }


}
