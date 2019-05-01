package com.bigfish.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: JDBCUtil
 * @Description: jdbc工具类
 *                  1. 获取Connection
 *                  2. 释放资源
 * @author: liusheng
 * @date: 2019-05-01 21:18
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-01   liusheng        v1.0.0          Modify reason
 */
public class JDBCUtil {

    /**
     * @MethodName: getConnection
     * @Description: 获取Connection连接
     * @return：java.sql.Connection 所获的到的JDBC的Connection
     * @version: v1.0.0
     * @author: liusheng
     * @date: 2019-05-01 22:07
     *
     * Modification History:
     * Date          Author         Version         Description
     *---------------------------------------------------------*
     * 2019-05-01   liusheng        v1.0.0          Modify reason
     */
    public static Connection getConnection() {

        Map<String, String> map = ReadPropertiesUtil.getResourceBundle();
        Connection connection = null;
        try {
            Class.forName(map.get("driverClass"));
            connection = DriverManager.getConnection(map.get("url"), map.get("user"), map.get("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    /**
     * @MethodName: release
     * @Description: 释放jdbc连接资源
     * @param: [resultSet, statement, connection]
     * @version: v1.0.0
     * @author: liusheng
     * @date: 2019-05-01 23:00
     *
     * Modification History:
     * Date          Author         Version         Description
     *---------------------------------------------------------*
     * 2019-05-01   liusheng        v1.0.0          Modify reason
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
    