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

    public void deleteFromBasket(Product product) {shoppingbasket.remove(product);}

    public Product findInBasket(int id){
        for (Product i:shoppingbasket){
            if (i.getId()==id){
                return i;
            }
        }return null;
    }

    public float basketSum(){
        float sum=0;
        for(Product product:shoppingbasket){
            sum = sum + product.getPrice();
        }return sum;
    }

}
