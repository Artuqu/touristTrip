package touristTrip.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    public ModelAndView addCustomerPostWithTrip(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("customer/addCustomer");
        }
        try {
            this.jpaTouristService.save(customer);
        } catch (DataIntegrityViolationException e) {
            ObjectError error = new ObjectError("DuplicateError", "Passport number already exist!");
            result.addError(error);
            return new ModelAndView("customer/addCustomer");
        }
        return new ModelAndView("redirect:/addCustomer/allCustomers");
    }

    //    edit
    @GetMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable Long id, ModelAndView mav) {
        mav.addObject("customer", jpaTouristService.findCustomer(id));
        mav.setViewName("customer/editCustomer");
        return mav;
    }

    @PostMapping("/edit")
    public ModelAndView editCustomerPost(@Valid Customer customer, BindingResult result, ModelAndView mav) {
        mav.setViewName("customer/editCustomer");
        if (result.hasErrors()) {
            return mav;
        }
        try {
            Customer newCustomer = jpaTouristService.findCustomer(customer.getId());
            newCustomer.setFirstName(customer.getFirstName());
            newCustomer.setLastName(customer.getLastName());
            newCustomer.setPassportNumber(customer.getPassportNumber());
            this.jpaTouristService.save(newCustomer);
        } catch (DataIntegrityViolationException e) {
            ObjectError error = new ObjectError("DuplicateError", "Passport number already exist!");
            result.addError(error);
            return mav;
        }
        return new ModelAndView("redirect:allCustomers");

    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") @PathVariable Long id, ModelAndView mav) {
        try {
            this.jpaTouristService.deleteCustomer(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            mav.addObject("message", "Operation failed");
        }
        return new ModelAndView("redirect:/addCustomer/allCustomers");
    }

}