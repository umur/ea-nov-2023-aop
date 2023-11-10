package edu.miu.ea.aop.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class JPCategory extends JPBaseEntityWithIdAuto {

    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<JPProduct> products;

}
