package ea.lab5.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private int id;
    private String name;
    @JsonManagedReference
    private List<ProductDto> product;
}
