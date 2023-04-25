package com.radsoltan.column;

import com.radsoltan.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Column extends BaseEntity {
    public String label;
    public int width;
    public int breadth;

    // TODO: 25/04/2023 Duplicating code for every single entity
    protected Column() {
        super();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
}
