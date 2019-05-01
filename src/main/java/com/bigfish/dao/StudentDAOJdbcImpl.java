package com.bigfish.dao;

import com.bigfish.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 *
 * @ClassName: StudentDAOJdbcImpl
 * @Description: 通过jdbcTemplate方式访问数据库
 * @author: liusheng
 * @date: 2019-05-01 23:56
 * @version: v1.0.0
 * ---------------------------------------------------------*
 * Modification History:
 * Date          Author         Version         Description
 * ---------------------------------------------------------*
 * 2019-05-01   liusheng        v1.0.0          Modify reason
 */
public class StudentDAOJdbcImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {
        final List<Student> students = new ArrayList<>();
        String sql = "select id, name, age from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            Student student = null;
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
            }
        });

        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
    