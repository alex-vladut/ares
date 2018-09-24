package org.ares.domain.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 643167219565846000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long              id;
    private String            uuid;

    public AbstractEntity() {
	this.uuid = UUID.randomUUID().toString();
    }

    @Column(name = "id")
    public long getId() {
	return id;
    }

    @Column(name = "uuid", unique = true, nullable = false)
    public String getUuid() {
	return uuid;
    }

    @Override
    public int hashCode() {
	return this.uuid.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj instanceof AbstractEntity) {
	    if (getUuid().equals(((AbstractEntity) obj).getUuid())) {
		return true;
	    } else {
		return false;
	    }
	} else {
	    return false;
	}
    }

}
