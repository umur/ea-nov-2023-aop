package edu.miu.ea.aop.model.dto;

import edu.miu.ea.aop.model.JPModel;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class JPDtoModel extends JPModel {

    private Long id;

}
