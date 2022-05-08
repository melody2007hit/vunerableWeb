package com.okta.blog.sqlinjection.repository.jdbc;

import com.okta.blog.sqlinjection.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Map;

@Repository
public class EmployeeRepositoryJdbcUnSafe extends EmployeeRepositoryJdbc {

    @Override
    public List<Employee> filterByUsername(String name) {
        System.out.println("select * from employee where name ='" + name + "'");
        return jdbcTemplate.query("select * from employee where name ='" + name + "'", new EmployeeRowMapper());
    }

    public String Login(String name, String pwd) {

        List<Employee> user= jdbcTemplate.query("select * from employee where name ='" + name + "'", new EmployeeRowMapper());
        System.out.println(user.get(0));
        System.out.println(user.get(0).getPassword());
        if (pwd.equals(user.get(0).getPassword())){
            return "login success";
        }else{
            return "login failed";
        }

    }




}
