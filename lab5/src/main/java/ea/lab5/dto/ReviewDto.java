package ea.lab5.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private int id;
    private String comment;
    private UserDto user;
    @JsonManagedReference
    private ProductDto product;
}
