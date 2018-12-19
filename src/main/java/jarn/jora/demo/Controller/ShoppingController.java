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
        return "redirect:/shoppingbasket";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFromBasket (@PathVariable(value = "id") int id){
        Product product = basket.findInBasket(id);
        basket.deleteFromBasket(product);
        return "redirect:/shoppingbasket";
    }

    @ModelAttribute("shoppingbasket")
    public ArrayList<Product> findBasket(){
       return basket.getShoppingbasket();
    }


    @RequestMapping(value = "/shoppingbasket",method = RequestMethod.GET)
    public String showBasket(){
        return "shoppingbasket";
    }

    @ModelAttribute("sum")
    public float Sum(){
        return basket.basketSum();
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String orderBasket(){
        basket.confirmBasket();
        return "confirmOrder";
    }


}
