package com.radsoltan.storey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Storey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String description;
    private int height;
    private double area;

    protected Storey() {
        this.id = null;
    }

    public Storey(String description, int height, double area) {
        this();
        this.description = description;
        this.height = height;
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
