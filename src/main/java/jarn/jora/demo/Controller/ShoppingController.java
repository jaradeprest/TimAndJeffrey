package jarn.jora.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingController {

    @RequestMapping(value = "/shoppingbasket",method = RequestMethod.GET)
    public String showBasket(){
        return "shoppingbasket";
    }
}
