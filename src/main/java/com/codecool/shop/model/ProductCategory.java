package com.codecool.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductCategory extends BaseModel {
    private String department;

    public ProductCategory(String name, String department, String description) {
        super(name, description);
        this.department = department;
    }

    public String toString() {
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.department,
                this.description);
    }
}