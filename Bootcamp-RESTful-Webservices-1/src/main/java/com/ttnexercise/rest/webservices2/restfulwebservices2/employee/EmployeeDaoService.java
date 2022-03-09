package com.ttnexercise.rest.webservices2.restfulwebservices2.employee;

//Create an Employee Bean(id, name, age) and service to  perform different operations related to employee.

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {

    private static Integer empCount = 2000;

    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1,"Abiha",22));
        employees.add(new Employee(2,"Sammy",38));
        employees.add(new Employee(3,"Aura",21));
        employees.add(new Employee(4,"Love",40));
        employees.add(new Employee(5,"Quinn",25));

    }

    public List<Employee> getEmployeeList(){
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        if(employee.getId() == null)
            employee.setId(++empCount);
        employees.add(employee);

        return employee;
    }

    public Employee getOneEmployee(int id){
        for (Employee employee: employees) {
            if(employee.getId()==id)
                return employee;
        }
        return null;
    }

    public Employee deleteEmployeeById(int id){
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getId() == id){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }

    public Employee updateEmployee(Employee employee){
        Integer empId = employee.getId();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employeeTemp = iterator.next();
            if(employeeTemp.getId() == empId){
                employeeTemp.setAge(employee.getAge());
                employeeTemp.setName(employee.getName());
                return employeeTemp;
            }
        }
        return null;
    }





}
