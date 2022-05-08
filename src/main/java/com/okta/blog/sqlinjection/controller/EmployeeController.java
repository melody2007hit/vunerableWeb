package com.okta.blog.sqlinjection.controller;

import com.okta.blog.sqlinjection.domain.Employee;
import com.okta.blog.sqlinjection.repository.EmployeeRepository;
import com.okta.blog.sqlinjection.repository.jdbc.EmployeeRepositoryJdbcUnSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepositoryJdbcUnSafe repositoryJdbcUnSafe;

    @GetMapping(path ={"/hello"})
    public String HelloSpring(){

        return "hello spring boot";
    }

    @GetMapping("/filterUserJdbcUnSafe")
    public List<Employee> filterByUsernameJdbcUnSafe(@RequestParam(value = "name") String name) {
        return repositoryJdbcUnSafe.filterByUsername(name);
    }

    @PostMapping("/login")
    public String Login(@RequestParam(value = "name") String name,@RequestParam(value = "password") String password) {
        return repositoryJdbcUnSafe.Login(name,password);
    }


}