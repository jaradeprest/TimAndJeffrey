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
public class ProductController {

    @Autowired
    private ProductRepo repo;
    private shoppingbasket basket= new shoppingbasket();

    @ModelAttribute("all")
    public Iterable<Product> findAll(){
        return repo.findAll();
    }

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }

    @ModelAttribute("counter")
    public int count(){
        return basket.counter();
    }




}
