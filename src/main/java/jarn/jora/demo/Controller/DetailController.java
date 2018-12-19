package jarn.jora.demo.Controller;

import jarn.jora.demo.model.Product;
import jarn.jora.demo.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailController {

    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetails(ModelMap detailMap, @PathVariable(value = "id") int id){
        Product prod = repo.findById(id).get();
        detailMap.addAttribute("product", prod);
        return "/details";
    }
}
