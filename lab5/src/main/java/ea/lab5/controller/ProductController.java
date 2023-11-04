package ea.lab5.controller;

import ea.lab5.dto.ProductDto;
import ea.lab5.entity.Category;
import ea.lab5.service.ProductService;
import ea.lab5.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;


    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/byPriceGreaterThan/{minPrice}")
    public List<ProductDto> findProductCostGreaterThan(@PathVariable double minPrice) {
     return productService.findProductCostGreaterThan(minPrice);
    }

    @GetMapping("/byCategoryAndPriceLessThan")
    public List<ProductDto> getProductsByCategoryAndPriceLessThan(@RequestParam Category category, @RequestParam double maxPrice) {
        return productService.getProductsByCategoryAndPriceLessThan(category, maxPrice);
    }

    @GetMapping("/byNameContaining")
    public List<ProductDto> getProductsByNameContaining(@RequestParam String keyword) {
        return productService.getProductsByNameContaining(keyword);
    }
}
