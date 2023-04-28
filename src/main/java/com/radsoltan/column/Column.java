package com.radsoltan.column;

import com.radsoltan.core.BaseEntity;
import com.radsoltan.storey.Storey;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Column extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 140)
    private String label;
    @NotNull
    private int width;
    @NotNull
    private int breadth;
    @NotNull
    private double force;
    @ManyToOne
    private Storey storey;

    // TODO: 25/04/2023 Duplicating code for every single entity
    protected Column() {
        super();
    }

    public Column(String label, int width, int breadth, double force) {
        this.label = label;
        this.width = width;
        this.breadth = breadth;
        this.force = force;
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

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public Storey getStorey() {
        return storey;
    }

    public void setStorey(Storey storey) {
        this.storey = storey;
    }
}
