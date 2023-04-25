package com.radsoltan.storey;

import com.radsoltan.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Storey extends BaseEntity {
    private String label;
    private int height;
    private double area;

    protected Storey() {
        super();
    }

    public Storey(String description, int height, double area) {
        this();
        this.label = description;
        this.height = height;
        this.area = area;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
