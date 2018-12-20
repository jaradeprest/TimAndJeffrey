package jarn.jora.demo.Controller;

import jarn.jora.demo.model.shoppingbasket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {
    private shoppingbasket basket = new shoppingbasket();

    //about pagina openen
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAbout() {
        return "about";
    }

    //de hoeveelheid producten in het winkelmandje laten zien
    @ModelAttribute("counter")
    public int count() {
        return basket.counter();
    }
}

