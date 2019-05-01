package com.bigfish.utils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: JDBCUtilTest
 * @Description: jdbc测试类
 * @author: liusheng
 * @date: 2019-05-01 22:52
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-01   liusheng        v1.0.0          Modify reason
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}
    