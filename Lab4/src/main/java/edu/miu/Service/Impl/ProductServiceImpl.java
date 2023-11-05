package edu.miu.Service.Impl;

import com.example.lab4.Aspect.ExecutionTime;
import com.example.lab4.Model.Category;
import com.example.lab4.Model.Product;
import com.example.lab4.Repository.ProductRepo;
import edu.miu.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }
@ExecutionTime
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productRepo.updateById(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getProductsMoreThan(double minPrice) {
        return productRepo.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(Category category, double price) {
        return productRepo.findAllByCategoryAndPriceLessThan(category,price);
    }

    @Override
    public List<Product> findAllByNameContainsKeyword(String keyword) {
        return productRepo.findAllByNameContains(keyword);
    }
}
