package jarn.jora.demo.Controller;

import jarn.jora.demo.model.CustomerRepo;
import jarn.jora.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private CustomerRepo repo;

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String showRegi(ModelMap regiMap){
        return "registration";
    }

    @ModelAttribute("newCustomer")
    public Customer newCustomer() {
        return new Customer();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String newCustomer(@ModelAttribute("newCustomer") @Valid Customer newCustomer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        repo.save(newCustomer);
        return "redirect:/index";
    }
}
