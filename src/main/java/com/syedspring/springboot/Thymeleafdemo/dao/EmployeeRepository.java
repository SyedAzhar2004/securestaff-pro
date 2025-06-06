package com.syedspring.springboot.Thymeleafdemo.dao;

import com.syedspring.springboot.Thymeleafdemo.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    public List<Employee> findAll(Sort sort);

}
