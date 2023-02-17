package com.example.jdbctemplate.controller;

import com.example.jdbctemplate.dao.EmployeeDao;
import com.example.jdbctemplate.model.Employee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeDao employeeDao;

    @PostMapping("/add")
    public void addEmployee(@Valid @RequestBody Employee employee){
        employeeDao.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id){
        return employeeDao.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
    }

    @PutMapping("/update/{id}")
    public int updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee){
        return employeeDao.updateEmployee(id, employee);
    }

    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeDao.deleteEmployee(id);
    }
}
