package com.codecool.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Getter @Setter
public abstract class BaseModel {

    protected int id;
    protected String name;
    protected String description;

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
