package edu.ea.springaop.dto;


import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FullUserDto {

    private Integer id;
    private String email;
    private String  password;
    private String  firstName;
    private String  lastname;
    private FullAddressDto address;
    private List<FullReviewDto> reviews;
}
