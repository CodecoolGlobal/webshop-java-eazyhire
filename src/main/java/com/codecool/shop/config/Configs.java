package com.codecool.shop.config;

import com.codecool.shop.dao.implementation.db.DbCreator;

public class Configs {
    public static DbType dbType = DbType.MEM;

    public enum DbType { MEM, JDBC }
}
