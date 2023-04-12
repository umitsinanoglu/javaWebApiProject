package io.kodlama.javaWebApiProject.api.controllers;


import io.kodlama.javaWebApiProject.business.abstracts.ProductService;
import io.kodlama.javaWebApiProject.core.utilities.results.DataResult;
import io.kodlama.javaWebApiProject.core.utilities.results.Result;
import io.kodlama.javaWebApiProject.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getAllSortedDesc")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return this.productService.getAll(pageNo, pageSize);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
       return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryCategoryId")
    public DataResult<Product> getByProductNameAndCategoryCategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return this.productService.getByProductNameAndCategoryCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryCategoryId(@RequestParam Optional<String> productName, @RequestParam Optional<Integer> categoryId) {
        return this.productService.getByProductNameOrCategoryCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryCategoryIdIn")
    public DataResult<List<Product>> getByCategoryCategoryIdIn(@RequestParam List<Integer> categories) {
        return this.productService.getByCategoryCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }



}
