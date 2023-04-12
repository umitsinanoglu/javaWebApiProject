package io.kodlama.javaWebApiProject.dataAccess.abstracts;


import io.kodlama.javaWebApiProject.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategoryCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryCategoryId(Optional<String> productName, Optional<Integer> categoryId);

    List<Product> getByCategoryCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);


}
