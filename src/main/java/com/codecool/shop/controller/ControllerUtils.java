package com.codecool.shop.controller;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;

class ControllerUtils {
    static Order getCurrentOrder(OrderDao orderDao) {
        // temporary implementation: handle only one order
        return orderDao.find(1);
    }
}
