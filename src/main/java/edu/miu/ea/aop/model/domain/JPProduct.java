package edu.miu.ea.aop.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class JPProduct extends JPBaseEntityWithIdAuto {

    private String name;
    private Double price;
    private Long rating;

    @ManyToOne
    private JPCategory category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<JPReview> reviews;

}
