package touristTrip.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
        jpaTouristService.save(trip);
        model.addAttribute("trip", trip);
        return "/addCustomer/allCustomers";
    }





    @GetMapping("")
    public ModelAndView getTripView(ModelAndView mav) {
        mav.addObject("trip", jpaTouristService.findAllTrips());
        mav.setViewName("/trip/addTrip");
        return mav;
    }

    @GetMapping("/Czech")
    public ModelAndView getCzechTrip(ModelAndView mav) {
        mav.setViewName("/trip/czech");
        mav.addObject("trip", new Trip());
        return mav;
    }

    @PostMapping("/Czech")
    public String postCzechTrip(BindingResult result, @ModelAttribute("trip") @Valid Trip trip, Model model) {
        if (result.hasErrors()) {
            return "/addTrip/Czech";
        }
        return saveTrip(trip, model);
    }


    @GetMapping("/Spain")
    public ModelAndView getSpainTrip(ModelAndView mav) {
        mav.setViewName("/trip/spain");
        mav.addObject("trip", new Trip());
        return mav;
    }

    @PostMapping("/Spain")
    public String postSpainTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addTrip/Spain";
        }
        return saveTrip(trip, model);
    }

    @GetMapping("/Egypt")
    public ModelAndView getEgyptTrip(ModelAndView mav) {
        mav.setViewName("/trip/egypt");
        mav.addObject("trip", new Trip());
        return mav;
    }

    @PostMapping("/Egypt")
    public String postEgyptTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addTrip/Egypt";
        }
        return saveTrip(trip, model);
    }

    @GetMapping("/Turkey")
    public ModelAndView getTurkeyTrip(ModelAndView mav) {
        mav.setViewName("/trip/turkey");
        mav.addObject("trip", new Trip());
        return mav;
    }

    @PostMapping("/Turkey")
    public String postTurkeyTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addTrip/Turkey";
        }
        return saveTrip(trip, model);
    }

    @GetMapping("/Italy")
    public ModelAndView getItalyTrip(ModelAndView mav) {
        mav.setViewName("/trip/italy");
        mav.addObject("trip", new Trip());
        return mav;
    }

    @PostMapping("/Italy")
    public String postItalyTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addTrip/Italy";
        }
        return saveTrip(trip, model);
    }

    @GetMapping("/Bulgaria")
    public ModelAndView getBulgariaTrip(ModelAndView mav) {
        mav.setViewName("/trip/bulgaria");
        mav.addObject("trip", new Trip());
        return mav;
    }

    @PostMapping("/Bulgaria")
    public String postBulgariaTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/addTrip/Bulgaria";
        }
        return saveTrip(trip, model);
    }


}
