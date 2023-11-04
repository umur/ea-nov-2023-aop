package ea.lab5.repository;

import ea.lab5.entity.Category;
import ea.lab5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryAndPriceLessThan(Category category, double price);
    List<Product> findByNameContaining(String keyword);
}
