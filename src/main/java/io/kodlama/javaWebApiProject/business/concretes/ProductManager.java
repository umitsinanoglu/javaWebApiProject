package io.kodlama.javaWebApiProject.business.concretes;

import io.kodlama.javaWebApiProject.core.utilities.results.DataResult;
import io.kodlama.javaWebApiProject.core.utilities.results.Result;
import io.kodlama.javaWebApiProject.core.utilities.results.SuccessDataResult;
import io.kodlama.javaWebApiProject.core.utilities.results.SuccessResult;
import io.kodlama.javaWebApiProject.dataAccess.abstracts.ProductDao;
import io.kodlama.javaWebApiProject.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import io.kodlama.javaWebApiProject.business.abstracts.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "All Data List returned");
    }
    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<>(productDao.findAll(sort), "Data List sorted");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<>(productDao.findAll(pageable).getContent(), "Page List returned");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(
                this.productDao.getByProductName(productName), "Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryCategoryId(String productName, Integer categoryId) {
        return new SuccessDataResult<Product>(
                this.productDao.getByProductNameAndCategoryCategoryId(productName, categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryCategoryId(Optional<String> productName, Optional<Integer> categoryId) {
        return new SuccessDataResult<List<Product>>(
                this.productDao.getByProductNameOrCategoryCategoryId(productName, categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(
                this.productDao.getByCategoryCategoryIdIn(categories), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(
                this.productDao.getByProductNameContains(productName), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(
                this.productDao.getByProductNameStartsWith(productName), "Data listelendi");
    }



}
