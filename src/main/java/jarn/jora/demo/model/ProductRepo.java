package jarn.jora.demo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    ArrayList<Product> findByCategory(Category category);
}
