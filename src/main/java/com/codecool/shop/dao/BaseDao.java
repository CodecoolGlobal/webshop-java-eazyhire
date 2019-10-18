package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.List;

public interface BaseDao<T> {
    void add(T t);
    T find(int id);
    void remove(int id);
    List<T> getAll();
}
