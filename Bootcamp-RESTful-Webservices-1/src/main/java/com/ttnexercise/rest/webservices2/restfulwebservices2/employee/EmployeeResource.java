package com.ttnexercise.rest.webservices2.restfulwebservices2.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    EmployeeDaoService service;


    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return service.getEmployeeList();

    }


    // GET /employees/{id}

    @GetMapping("/employees/{id}")
    public Employee retrieveOneEmployee(@PathVariable int id){
        Employee employee = service.getOneEmployee(id);

        if(employee== null){
            throw new EmployeeNotFoundException("id-" + id);
        }
        return employee;

    }


    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employee = service.deleteEmployeeById(id);
        if(employee == null)
            throw new EmployeeNotFoundException("id-" + id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee){
        Employee addingEmployee = service.addEmployee(employee);

        //created
        // /employees/4-> {id}   addingEmployee.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addingEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee)
    {
        Employee addedEmployee= service.updateEmployee(employee);

        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedEmployee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }




}
