package com.miu.lab4aop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.miu.lab4aop.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private AddressDto address;
    private Set<ReviewDto> reviews = new LinkedHashSet<>();
}