package com.spring.bootElgamal.employee_task1.service;

import com.spring.bootElgamal.employee_task1.model.Employee;
import com.spring.bootElgamal.employee_task1.repo.EmployeeRepo;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesByIds(List<Long> ids) {
        return employeeRepo.findAllById(ids);
    }

    @Override
    public Employee saveEmployee(Employee employee) throws SystemException {

        if (Objects.nonNull(employee.getId())){
            throw new SystemException("the id must be null");
        }
        Optional<Employee>employee1=employeeRepo.findByName(employee.getName());
        if (employee1.isPresent()){
            throw  new SystemException("the employee with name: "+employee.getName()+" is already exist");
        }
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> saveListOfEmployee(List<Employee> employees) throws SystemException {
        for (Employee employee :employees){
            if (employee.getId()!=null){
                throw new SystemException("Sorry, this list it must contain any id");
            }
        }
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee modifyEmployee(Employee employee) throws SystemException {
        if (Objects.isNull(employee.getId())){
            throw new SystemException("the id must be not null");
        }

        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> modifyListOfEmployee(List<Employee> employees) throws SystemException {
        for (Employee employee :employees){
            if (employee.getId()==null){
                throw new SystemException("Sorry, this list it must contain id");
            }
        }
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee getEmployeeById(long id) throws SystemException {
        Optional<Employee> employee = employeeRepo.findById(id);

        if (employee.isEmpty()){
            throw new SystemException("there is no employee with id: "+id);
        }
        return employee.get();
    }

    @Override
    public void removeEmployee(long id) throws SystemException {
        Optional<Employee> employee = employeeRepo.findById(id);

        if (employee.isEmpty()){
            throw new SystemException("there is no employee with id: "+id);
        }

        employeeRepo.deleteById(id);
    }

    @Override
    public void removeAllEmployee() throws SystemException {
        List<Employee>employees=employeeRepo.findAll();
        if (employees.isEmpty()){
            throw new SystemException("there is no employee now .......");
        }
        employeeRepo.deleteAll();
    }

    @Override
    public List<Employee> getByNameStartingWith(String name) {
        return employeeRepo.findByNameNative(name);
    }


}
