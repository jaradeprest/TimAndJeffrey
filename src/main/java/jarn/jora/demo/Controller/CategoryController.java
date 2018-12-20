package jarn.jora.demo.Controller;

import jarn.jora.demo.model.Category;
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
public class CategoryController {

    @Autowired
    private ProductRepo repo;
    private shoppingbasket basket = new shoppingbasket();

    //de producten van een bepaalde category weergeven
    @ModelAttribute("category")
    public Iterable<Product> findCat(ModelMap catMap, @PathVariable(value = "category") Category category) {
        return repo.findByCategory(category);

    }

    //category pagina openen van verschillende categories
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public String showCategory() {
        return "category";
    }

    //de hoeveelheid producten in het winkelmandje laten zien
    @ModelAttribute("counter")
    public int count() {
        return basket.counter();
    }
}
