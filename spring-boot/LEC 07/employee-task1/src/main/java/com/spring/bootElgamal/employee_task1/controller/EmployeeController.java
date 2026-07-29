package com.spring.bootElgamal.employee_task1.controller;

import com.spring.bootElgamal.employee_task1.model.Employee;
import com.spring.bootElgamal.employee_task1.service.EmployeeService;
import com.spring.bootElgamal.employee_task1.service.EmployeeServiceImpl;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }

    @GetMapping("/allEmployees/ids")
    List<Employee> getEmployeesByIds(@RequestBody List<Long> ids){
        return employeeService.getEmployeesByIds(ids);
    }

    @PostMapping("/employee")
    Employee saveEmployee(@RequestBody Employee employee) throws SystemException{
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/employees")
    List<Employee> saveListOfEmployee(@RequestBody List<Employee> employees) throws SystemException{
        return employeeService.saveListOfEmployee(employees);
    }

    @PutMapping("/employee")
    Employee modifyEmployee(@RequestBody Employee employee) throws SystemException{
        return employeeService.modifyEmployee(employee);
    }

    @PutMapping("/employees")
    List<Employee> modifyListOfEmployee(@RequestBody List<Employee> employees) throws SystemException{
        return employeeService.modifyListOfEmployee(employees);
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable long id) throws SystemException{
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employee/{id}")
    void removeEmployee (@PathVariable long id) throws SystemException{
        employeeService.removeEmployee(id);
    }

    @DeleteMapping("/all")
    void removeAllEmployee () throws SystemException{
        employeeService.removeAllEmployee();
    }

    @GetMapping("/employee")
    public List<Employee> getByNameStartingWith(@RequestParam String name) {
        return employeeService.getByNameStartingWith(name);
    }
}
