package com.bigfish.dao;

import com.bigfish.domain.Student;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @InterfaceName: StudentDAO
 * @Description: 数据访问接口
 * @author: liusheng
 * @date: 2019-05-01 23:04
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-01   liusheng        v1.0.0          Modify reason
 */
public interface StudentDAO {

    /** jdbc方式查询数据 */
    List<Student> query();

}
