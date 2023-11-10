package edu.miu.ea.aop.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class JPUser extends JPBaseEntityWithIdAuto {

    private String email;
    private String firstname;
    private String lastname;
    private String password;

    @OneToOne
    private JPAddress address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<JPReview> reviews;

}
