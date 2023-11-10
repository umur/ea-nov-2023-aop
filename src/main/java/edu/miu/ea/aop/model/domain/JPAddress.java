package edu.miu.ea.aop.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class JPAddress extends JPBaseEntityWithIdAuto {

    private String street;
    private Long zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private JPUser user;

}
