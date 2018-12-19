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

import java.util.ArrayList;

@Controller
public class ShoppingController {

    @Autowired
    private ProductRepo repo;
    private shoppingbasket basket= new shoppingbasket();



    @RequestMapping(value = "/shoppingbasket/{id}",method = RequestMethod.GET)
    public String addToBasket(@PathVariable(value = "id") int id){
        Product p = repo.findById(id).get();
        basket.addToBasket(p);
        return "shoppingbasket";
    }

    @ModelAttribute("shoppingbasket")
    public ArrayList<Product> findBasket(){
       return basket.getShoppingbasket();
    }

    @RequestMapping(value = "/shoppingbasket",method = RequestMethod.GET)
    public String showBasket(){
        return "shoppingbasket";
    }



}




    /*@ModelAttribute("shoppingbasket")
    @RequestMapping(value = "/shoppinbasket/{id}",method = RequestMethod.GET)
    public ArrayList<Product> addToBasket(ModelMap shoppingMap, @PathVariable(value = "id") int id ){
        Product p = repo.findById(id).get();
        shoppingMap.addAttribute("product", p);
        return shoppingBasket;
    }

    @ModelAttribute("addToBasket")
    public Product productToSave(){
        return new Product();
    }

    @RequestMapping(value = "/shoppingbasket/{id}", method = RequestMethod.GET)
    public String saveProduct(ModelMap shoppingmap, @PathVariable(value = "id")@ModelAttribute("addToBasket") int id){
        Product p = repo.findById(id).get();
        shoppingbasket.add(p);
        return "shoppingbasket";
    }

    */