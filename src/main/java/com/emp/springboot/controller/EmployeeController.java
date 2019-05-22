package com.emp.springboot.controller;

import com.emp.springboot.dao.EmployeeDao;
import com.emp.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工的返回列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees= employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认就会拼串
        //classpath:/thymelates/xxx.html
        return "emp/list";
    }

}
