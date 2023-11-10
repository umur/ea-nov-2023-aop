package edu.miu.ea.aop.model.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

@Data
@MappedSuperclass
public class JPBaseEntity extends JPDomainModel {

    private boolean retired = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date retiredAt;

    private Long retiredBy;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp modifiedAt;

    public void setAsRetireFromDatabase(Long userDbId) {
        this.retired = true;
        this.retiredAt = new Date();
        this.retiredBy = userDbId;
    }

    public void setAsUnretiredFromDatabase() {
        this.retired = false;
        this.retiredAt = null;
        this.retiredBy = null;
    }

}
