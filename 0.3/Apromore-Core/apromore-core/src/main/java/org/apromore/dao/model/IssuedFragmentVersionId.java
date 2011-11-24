package org.apromore.dao.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * IssuedFragmentVersionId generated by hbm2java
 */
@Entity
@Table(name = "issued_fragment_version_id")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Configurable("issuedFragmentVersionId")
public class IssuedFragmentVersionId implements Serializable {

    /** Hard coded for interoperability. */
    private static final long serialVersionUID = -1322912504638485548L;

    private int issuedId;


    public IssuedFragmentVersionId() { }


    @Id
    @Column(name = "issued_id", unique = true, nullable = false)
    public int getIssuedId() {
        return this.issuedId;
    }

    public void setIssuedId(final int newIssuedId) {
        this.issuedId = newIssuedId;
    }


}

