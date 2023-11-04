package ea.lab5.service;

import ea.lab5.dto.ProductDto;
import ea.lab5.entity.Category;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();
    List<ProductDto> findProductCostGreaterThan(double price);

    public List<ProductDto> getProductsByCategoryAndPriceLessThan(Category category, double maxPrice);

    public List<ProductDto> getProductsByNameContaining(String keyword);
}
