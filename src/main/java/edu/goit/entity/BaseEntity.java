package edu.goit.entity;

import java.io.Serializable;

public interface BaseEntity<ID> extends Serializable {
    public ID getId();
    public void setId(ID id);
}
