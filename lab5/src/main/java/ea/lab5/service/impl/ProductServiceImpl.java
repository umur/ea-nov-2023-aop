package ea.lab5.service.impl;

import ea.lab5.aspect.ExecutionTime;
import ea.lab5.dto.ProductDto;
import ea.lab5.entity.Category;
import ea.lab5.entity.Product;
import ea.lab5.repository.ProductRepository;
import ea.lab5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<ProductDto> findAll(){
        List<Product> productList = productRepository.findAll();
        List<ProductDto> results = new ArrayList<>();

        productList.forEach(Product -> {
            ProductDto productDto = modelMapper.map(Product,ProductDto.class);
            results.add(productDto);
        });
        return results;
    }


    @ExecutionTime
    @Override
    public List<ProductDto> findProductCostGreaterThan(double price) {
        List<Product> productList = productRepository.findByPriceGreaterThan(price);
        List<ProductDto> results = new ArrayList<>();

        productList.forEach(Product -> {
            ProductDto productDto = modelMapper.map(Product,ProductDto.class);
            results.add(productDto);
        });
        return results;
    }

    @ExecutionTime
    @Override
    public List<ProductDto> getProductsByCategoryAndPriceLessThan(Category category, double maxPrice) {
        List<Product> productList = productRepository.findByCategoryAndPriceLessThan(category, maxPrice);
        List<ProductDto> results = new ArrayList<>();

        productList.forEach(Product -> {
            ProductDto productDto = modelMapper.map(Product,ProductDto.class);
            results.add(productDto);
        });
        return results;
    }
    @ExecutionTime
    @Override
    public List<ProductDto> getProductsByNameContaining(String keyword) {
        List<Product> productList = productRepository.findByNameContaining(keyword);
        List<ProductDto> results = new ArrayList<>();

        productList.forEach(Product -> {
           ProductDto productDto = modelMapper.map(Product, ProductDto.class);
           results.add(productDto);
        });
        return results;
    }


}
