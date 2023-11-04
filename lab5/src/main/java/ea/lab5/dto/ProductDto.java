package ea.lab5.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
    @JsonBackReference
    private CategoryDto category;
    @JsonBackReference
    private List<ReviewDto> review;
}
