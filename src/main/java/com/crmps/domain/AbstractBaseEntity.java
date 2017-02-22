package com.crmps.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	public AbstractBaseEntity() {
		this.uid = UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		return uid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractBaseEntity)) {
			return false;
		}
		AbstractBaseEntity other = (AbstractBaseEntity) obj;
		return getUid().equals(other.getUid());
	}


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}