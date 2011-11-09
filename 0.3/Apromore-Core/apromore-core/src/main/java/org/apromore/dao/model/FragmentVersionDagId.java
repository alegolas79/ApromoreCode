package org.apromore.dao.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * FragmentVersionDagId generated by hbm2java
 */
@Embeddable
public class FragmentVersionDagId implements Serializable {

    /** Hard coded for interoperability. */
    private static final long serialVersionUID = -9072538404638415243L;

    private String fragmentVersionId;
    private String childFragmentVersionId;
    private String pocketId;

    public FragmentVersionDagId() {
    }

    public FragmentVersionDagId(String fragmentVersionId, String childFragmentVersionId, String pocketId) {
        this.fragmentVersionId = fragmentVersionId;
        this.childFragmentVersionId = childFragmentVersionId;
        this.pocketId = pocketId;
    }


    @Column(name = "fragment_version_id", nullable = false, length = 40)
    public String getFragmentVersionId() {
        return this.fragmentVersionId;
    }

    public void setFragmentVersionId(String fragmentVersionId) {
        this.fragmentVersionId = fragmentVersionId;
    }


    @Column(name = "child_fragment_version_id", nullable = false, length = 40)
    public String getChildFragmentVersionId() {
        return this.childFragmentVersionId;
    }

    public void setChildFragmentVersionId(String childFragmentVersionId) {
        this.childFragmentVersionId = childFragmentVersionId;
    }


    @Column(name = "pocket_id", nullable = false, length = 40)
    public String getPocketId() {
        return this.pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }


    /**
     * The equals standard method to test if the Fragment Version Dag entity is the same.
     * @param obj the other ID object
     * @return true if the same otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        Boolean result = false;

        if (obj instanceof FragmentVersionDagId) {
            FragmentVersionDagId other = (FragmentVersionDagId) obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(getFragmentVersionId(), other.getFragmentVersionId());
            builder.append(getChildFragmentVersionId(), other.getChildFragmentVersionId());
            builder.append(getPocketId(), other.getPocketId());
            result = builder.isEquals();
        }

        return result;
    }

    /**
     * Determines the hashcode of the object.
     * @return the hashcode
     */
    @Override
	public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getFragmentVersionId());
        builder.append(getChildFragmentVersionId());
        builder.append(getPocketId());
        return builder.toHashCode();
	}

}


