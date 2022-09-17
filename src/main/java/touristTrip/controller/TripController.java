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

    @GetMapping("/addDestination/{id}")
    public ModelAndView getDestinationTrip(ModelAndView mav, @PathVariable Long id) {
        mav.setViewName("trip/destination");
        mav.addObject("customer", jpaTouristService.findAllCustomers());
        mav.addObject("trip", jpaTouristService.findTrip(id));
        mav.addObject("date", jpaTouristService.getAllStartDates(id));
        return mav;
    }

    @PostMapping("/addDestination/{tripId}")
    public String postCzechTrip(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model, @PathVariable List<Trip> tripId, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "trip/destination";
        }

        model.addAttribute("customer", customer);
        Trip searchTrip = jpaTouristService.findTrip(id);
        System.out.println(searchTrip);
        Customer customerToSave = jpaTouristService.findCustomer(customer.getId());
        System.out.println(customerToSave.getId());
        customerToSave.setTrips(tripId);
        customerToSave.setPrice(searchTrip.getPrice());
        jpaTouristService.save(customerToSave);

        try {
            jpaTouristService.save(customerToSave);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            model.addAttribute("message", "Operation failed.");
            return "trip/destination";
        }

        return "redirect:/addCustomer/allCustomers";
    }


}
