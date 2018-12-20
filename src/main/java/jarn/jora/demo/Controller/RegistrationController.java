package jarn.jora.demo.Controller;

import jarn.jora.demo.model.CustomerRepo;
import jarn.jora.demo.model.Customer;
import jarn.jora.demo.model.Product;
import jarn.jora.demo.model.shoppingbasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private shoppingbasket basket = new shoppingbasket();

    @Autowired
    private CustomerRepo repo;

    //registratie pagina openenen
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegi(ModelMap regiMap) {
        return "registration";
    }

    //nieuwe klant aanspreken
    @ModelAttribute("newCustomer")
    public Customer newCustomer() {
        return new Customer();
    }

    //nieuwe klant opslaan in de database
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String newCustomer(@ModelAttribute("newCustomer") @Valid Customer newCustomer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        repo.save(newCustomer);
        return "redirect:/index";
    }

    //de hoeveelheid producten in het winkelmandje laten zien
    @ModelAttribute("counter")
    public int count() {
        return basket.counter();
    }
}
