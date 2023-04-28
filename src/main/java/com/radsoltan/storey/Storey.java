package com.radsoltan.storey;

import com.radsoltan.column.Column;
import com.radsoltan.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Storey extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 140)
    private String label;
    @NotNull
    private int height;
    private double area;
    @OneToMany(mappedBy = "storey", cascade = CascadeType.ALL)
    private List<Column> columns;

    protected Storey() {
        super();
        columns = new ArrayList<>();
    }

    public Storey(String description, int height, double area) {
        this();
        this.label = description;
        this.height = height;
        this.area = area;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void addColumn(Column column) {
        column.setStorey(this);
        columns.add(column);
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
