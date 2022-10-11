package touristTrip.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import touristTrip.entity.Customer;
import touristTrip.service.JpaTouristService;

@Controller
@RequestMapping("/addCustomer")
public class CustomerController {

    private final JpaTouristService jpaTouristService;

    @Autowired
    public CustomerController(JpaTouristService jpaTouristService) {
        this.jpaTouristService = jpaTouristService;
    }


    @GetMapping("/allCustomers")
    public ModelAndView showAllCustomers(ModelAndView mav) {
        mav.addObject("customers", jpaTouristService.findAllCustomers());
        mav.setViewName("customer/allCustomers");
        return mav;
    }

    @GetMapping("")
    public ModelAndView addCustomerWithTrip(ModelAndView mav) {
        mav.addObject("customer", new Customer());
        mav.setViewName("customer/addCustomer");
        return mav;
    }

    @PostMapping("")
    public String addCustomerPostWithTrip(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/addCustomer";
        }
        this.jpaTouristService.save(customer);
        return "redirect:/addCustomer/allCustomers";
    }

    //    edit
    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", jpaTouristService.findCustomer(id));
        return "customer/editCustomer";
    }

    @PostMapping("/edit")
    public String editCustomerPost(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/editCustomer";
        }
        Customer newCustomer = jpaTouristService.findCustomer(customer.getId());
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setPassportNumber(customer.getPassportNumber());
        this.jpaTouristService.save(newCustomer);
        return "redirect:allCustomers";

    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@ModelAttribute("customer") @PathVariable Long id, Model model) {
        try {
            Thread thread = new Thread(() -> {
            this.jpaTouristService.deleteAllCustomerTrips(id);
            });
            thread.start();
            this.jpaTouristService.deleteCustomer(id);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            model.addAttribute("message", "Operation failed");
        }
        return "redirect:/addCustomer/allCustomers";
    }

}