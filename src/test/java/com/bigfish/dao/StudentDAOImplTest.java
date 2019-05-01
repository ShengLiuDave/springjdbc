package com.bigfish.dao;

import com.bigfish.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: StudentDAOImplTest
 * @Description: 测试在jdbc下的sql查询
 * @author: liusheng
 * @date: 2019-05-01 23:14
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-01   liusheng        v1.0.0          Modify reason
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id: " + student.getId() + ", name: " + student.getName() + ", age: " + student.getAge());
        }
    }

}
    