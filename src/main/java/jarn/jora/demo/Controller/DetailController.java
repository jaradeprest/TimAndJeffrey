package jarn.jora.demo.Controller;

import jarn.jora.demo.model.Product;
import jarn.jora.demo.model.ProductRepo;
import jarn.jora.demo.model.shoppingbasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailController {
    private shoppingbasket basket = new shoppingbasket();
    @Autowired
    private ProductRepo repo;

    //details pagina openenen voor verschillende id's
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetails(ModelMap detailMap, @PathVariable(value = "id") int id) {
        Product prod = repo.findById(id).get();
        detailMap.addAttribute("product", prod);
        return "/details";
    }

    //de hoeveelheid producten in het winkelmandje laten zien
    @ModelAttribute("counter")
    public int count() {
        return basket.counter();
    }
}
