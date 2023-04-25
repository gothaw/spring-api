package com.radsoltan.column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    public String label;
    public int width;
    public int breadth;

    // TODO: 25/04/2023 Duplicating code for every single entity
    protected Column() {
        this.id = null;
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
