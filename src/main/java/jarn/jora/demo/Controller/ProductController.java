package jarn.jora.demo.Controller;

import jarn.jora.demo.model.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductRepo repo;

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    private String showIndex(ModelMap map){
        return "index";
    }
}
