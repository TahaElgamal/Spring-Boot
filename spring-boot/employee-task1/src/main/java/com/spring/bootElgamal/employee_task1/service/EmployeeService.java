package com.spring.bootElgamal.employee_task1.service;

import com.spring.bootElgamal.employee_task1.model.Employee;
import com.spring.bootElgamal.employee_task1.repo.EmployeeRepo;
import jakarta.transaction.SystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByIds(List<Long> ids);
    Employee saveEmployee(Employee employee) throws SystemException;
    List<Employee> saveListOfEmployee(List<Employee> employees) throws SystemException;
    Employee modifyEmployee(Employee employee) throws SystemException;
    List<Employee> modifyListOfEmployee(List<Employee> employees) throws SystemException;
    Employee getEmployeeById(long id) throws SystemException;
    void removeEmployee (long id) throws SystemException;

    void removeAllEmployee () throws SystemException;

}
