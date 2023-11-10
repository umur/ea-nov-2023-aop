package edu.miu.ea.aop.model.domain;

import edu.miu.ea.aop.model.JPModel;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class JPDomainModel extends JPModel {
}
