package jarn.jora.demo.Controller;

import jarn.jora.demo.model.Category;
import jarn.jora.demo.model.Product;
import jarn.jora.demo.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;

@Controller
public class CategoryController {

    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public String showCategory(ModelMap catMap, @PathVariable(value = "category") Category category){
        Product p = repo.findByCategory(category);
        catMap.addAttribute("Product",p);
        return "category";
    }
}
