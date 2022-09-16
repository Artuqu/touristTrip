package touristTrip.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import touristTrip.entity.Customer;
import touristTrip.entity.Trip;
import touristTrip.service.JpaTouristService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/addTrip")
public class TripController {

    private final JpaTouristService jpaTouristService;

    @Autowired
    TripController(JpaTouristService jpaTouristService) {
        this.jpaTouristService = jpaTouristService;
    }

    public String saveTrip(@ModelAttribute("trip") @Valid Trip trip, Model model) {
        model.addAttribute("trip", trip);
        jpaTouristService.save(trip);
        return "/addCustomer/allCustomers";
    }


    @GetMapping("")
    public ModelAndView getTripView(ModelAndView mav) {
        mav.addObject("trip", jpaTouristService.findAllTrips());
        mav.setViewName("/trip/addTrip");
        return mav;
    }

    @GetMapping("/addDestination/{tripId}")
    public ModelAndView getDestinationTrip(ModelAndView mav, @PathVariable Long tripId) {
        mav.setViewName("/trip/destination");
        mav.addObject("customer", jpaTouristService.findAllCustomers());
        mav.addObject("trip", jpaTouristService.findTrip(tripId));
        mav.addObject("conductor", jpaTouristService.findAllConductors());
        mav.addObject("date", jpaTouristService.getAllStartDates(tripId));
        return mav;
    }

    @PostMapping("/addDestination/{tripId}")
    public String postCzechTrip(BindingResult result, @ModelAttribute("customer") @Valid Customer customer, Model model) {
        if (result.hasErrors()) {
            return "/trip/destination";
        }
        model.addAttribute("customer", customer);
        jpaTouristService.save(customer);
        return "redirect:/addCustomer/allCustomers";
    }


}
