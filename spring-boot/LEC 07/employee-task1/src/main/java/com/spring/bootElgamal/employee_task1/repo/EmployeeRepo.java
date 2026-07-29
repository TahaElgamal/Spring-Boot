package com.spring.bootElgamal.employee_task1.repo;

import com.spring.bootElgamal.employee_task1.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findByName(String name);

    // Function Name
    List<Employee> findByNameStartingWith(String name);

    @Query(value = "select * from employee where name like :name%",nativeQuery = true)
    List<Employee> findByNameNative(String name);

    @Query(value = "SELECT e FROM Employee e WHERE e.name LIKE CONCAT(:name,'%')")
    List<Employee> findByNameWithoutNative(String name);


}
