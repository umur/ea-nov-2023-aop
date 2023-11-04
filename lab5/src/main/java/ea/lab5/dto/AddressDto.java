package ea.lab5.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private int id;
    private String street;
    private String zip;
    private String city;
    private UserDto userDto;

}
