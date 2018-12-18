package jarn.jora.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    Product findByCategory(Category category);
}
