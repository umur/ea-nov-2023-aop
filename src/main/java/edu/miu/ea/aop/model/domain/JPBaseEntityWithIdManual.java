package edu.miu.ea.aop.model.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class JPBaseEntityWithIdManual extends JPBaseEntity {

    @Id
    private Long id;

}
