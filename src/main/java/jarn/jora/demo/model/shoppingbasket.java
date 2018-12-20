package jarn.jora.demo.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.round;

public class shoppingbasket {

    private static ArrayList<Product> shoppingbasket = new ArrayList<Product>();

    public shoppingbasket() {
    }

    public ArrayList<Product> getShoppingbasket() {
        return shoppingbasket;
    }

    public void setShoppingbasket(ArrayList<Product> shoppingbasket) {
        this.shoppingbasket = shoppingbasket;
    }

    public void addToBasket(Product p) {
        shoppingbasket.add(p);
    }

    public void deleteFromBasket(Product product) {
        shoppingbasket.remove(product);
    }

    public Product findInBasket(int id) {
        for (Product i : shoppingbasket) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public float basketSum() {
        float sum = 0;
        float sum2 = 0;
        for (Product product : shoppingbasket) {
            sum = sum + product.getPrice();
            sum2 = round(sum * 100);
        }
        return sum2 / 100;
    }

    public void confirmBasket() {
        shoppingbasket.removeAll(shoppingbasket);

    }

    public float XmasSale() {
        float sale = basketSum() / 2;
        float sale2 = round(sale * 100);
        return sale2 / 100;
    }

    public int counter(){
        return shoppingbasket.size();
    }


}




