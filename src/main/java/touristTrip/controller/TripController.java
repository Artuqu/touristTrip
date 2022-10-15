package touristTrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import touristTrip.entity.CustomerTrips;
import touristTrip.service.JpaTouristService;


@Controller
@RequestMapping("/addTrip")
public class TripController {

    private final JpaTouristService jpaTouristService;

    @Autowired
    TripController(JpaTouristService jpaTouristService) {
        this.jpaTouristService = jpaTouristService;
    }

    @GetMapping("")
    public ModelAndView getTripView(ModelAndView mav) {
        mav.addObject("trip", jpaTouristService.findAllTrips());
        mav.setViewName("/trip/addTrip");
        return mav;
    }

    @GetMapping("/addDestination/{id}")
    public ModelAndView getDestinationTrip(ModelAndView mav, @PathVariable long id) {
        mav.setViewName("trip/destination");
        mav.addObject("customerTrips", new CustomerTrips());
        mav.addObject("customer", jpaTouristService.findAllCustomers());
        mav.addObject("trip", jpaTouristService.findTrip(id));
        mav.addObject("date", jpaTouristService.getAllStartDates(id));
        mav.addObject("conductor", jpaTouristService.findTrip(id).getConductor());
        return mav;
    }


    @PostMapping("/addDestination/{id}")
    public String postDestinationTrip(@ModelAttribute("customerTrips") CustomerTrips customerTrips,
                                       BindingResult result, ModelAndView mav) {
        if (result.hasErrors()) {
            return "trip/destination";
        }
        try {
            this.jpaTouristService.save(customerTrips);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            mav.addObject("message", "Operation failed.");
            return "trip/destination";
        }

        return "redirect:/addCustomer/allCustomers";
    }


}
