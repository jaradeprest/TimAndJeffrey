package jarn.jora.demo.model;

import javax.persistence.Entity;
import java.util.ArrayList;

public class shoppingbasket {

    private ArrayList<Product> shoppingbasket = new ArrayList<Product>();

    public shoppingbasket() {
    }

    public ArrayList<Product> getShoppingbasket() {
        return shoppingbasket;
    }

    public void setShoppingbasket(ArrayList<Product> shoppingbasket) {
        this.shoppingbasket = shoppingbasket;
    }

    public void addToBasket(Product p){
        shoppingbasket.add(p);
    }
}
