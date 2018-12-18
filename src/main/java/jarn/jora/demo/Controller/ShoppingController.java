package jarn.jora.demo.Controller;

import jarn.jora.demo.model.Product;
import jarn.jora.demo.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class ShoppingController {

    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = "/shoppingbasket",method = RequestMethod.GET)
    public String showBasket(){
        return "shoppingbasket";
    }

    @ModelAttribute("addToBasket")
    public Product productToSave(){
        return new Product();
    }

    @RequestMapping(value = "/shoppingbasket", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("addToBasket") Product addToBasket){
        repo.save(addToBasket);
        return "shoppingbasket";
    }





}



//private ArrayList<Product> shoppingBasket = new ArrayList<>();


    /*@ModelAttribute("shoppingbasket")
    @RequestMapping(value = "/shoppinbasket/{id}",method = RequestMethod.GET)
    public ArrayList<Product> addToBasket(ModelMap shoppingMap, @PathVariable(value = "id") int id ){
        Product p = repo.findById(id).get();
        shoppingMap.addAttribute("product", p);
        return shoppingBasket;
    }
    */