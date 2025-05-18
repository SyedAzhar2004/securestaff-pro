package com.syedspring.springboot.Thymeleafdemo.service;

import com.syedspring.springboot.Thymeleafdemo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

    Page<Employee> findPaginated(int page, int size, String sortField, String sortDir);


}
