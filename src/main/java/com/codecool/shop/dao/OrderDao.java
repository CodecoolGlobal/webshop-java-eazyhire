package com.codecool.shop.dao;

import com.codecool.shop.model.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {
    default void update(Order currentOrder) {}
}
