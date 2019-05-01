package com.bigfish.dao;

import com.bigfish.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: StudentDAOJdbcImplTest
 * @Description: StudentDAOJdbcImpl测试
 * @author: liusheng
 * @date: 2019-05-02 00:05
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-02   liusheng        v1.0.0          Modify reason
 */
public class StudentDAOJdbcImplTest {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("config/beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery() {

        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("id: " + student.getId() + ", name: " + student.getName() + ", age: " + student.getAge());

        }

    }


}
    