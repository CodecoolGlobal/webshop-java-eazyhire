package com.codecool.shop.dao;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.implementation.db.DbUtil;

public class DaoUtil {

    public static void setup() {
        if (Configs.dbType == Configs.DbType.JDBC) {
            DbUtil.createDb();
        }
    }

}
