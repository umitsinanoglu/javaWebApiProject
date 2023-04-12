package io.kodlama.javaWebApiProject.business.abstracts;

import io.kodlama.javaWebApiProject.core.utilities.results.DataResult;
import io.kodlama.javaWebApiProject.core.utilities.results.Result;
import io.kodlama.javaWebApiProject.entities.concretes.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted();

    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryCategoryId(String productName, Integer categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryCategoryId(Optional<String> productName, Optional<Integer> categoryId);

    DataResult<List<Product>> getByCategoryCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);


}
