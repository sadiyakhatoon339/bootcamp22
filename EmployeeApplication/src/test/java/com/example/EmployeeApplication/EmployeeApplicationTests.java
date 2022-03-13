package com.example.EmployeeApplication;

import com.example.EmployeeApplication.Repository.EmployeeRepository;
import com.example.EmployeeApplication.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testCreate() {
		Employee employee1 = new Employee();
		employee1.setName("Vareesha hussain");
		employee1.setId(1);
		employee1.setAge(34);
		employee1.setLocation("Hyederabad");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setName("Hiba alvi");
		employee2.setId(2);
		employee2.setAge(25);
		employee2.setLocation("Bangalore");

		employeeRepository.save(employee2);


		Employee employee3 = new Employee();
		employee3.setName("Alisha alvi");
		employee3.setId(3);
		employee3.setAge(45);
		employee3.setLocation("Mumbai");
		employeeRepository.save(employee3);

	}

	@Test
	public void testUpdate() {
		Employee employee = employeeRepository.findById(1).get();
		employee.setLocation("Uttar Pradesh");
		employeeRepository.save(employee);
	}

	@Test
	public void testDelete() {
		employeeRepository.deleteById(2);
	}

	@Test
	public void testRead() {
		Employee employee = employeeRepository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Vareesha Hussain", employee.getName());
	}

	@Test
	public void testCount() {
		System.out.println("Total employees ==>>  " + employeeRepository.count());
	}

	@Test
	public void findAllPaging() {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Employee> results = employeeRepository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getAge()));
	}

	@Test
	public void findAllSorting() {
		employeeRepository.findAll(Sort.by("age")).forEach(p -> System.out.println(p.getAge()));
	}

	@Test
	public void testFindByName() {
		List<Employee> employeeList = employeeRepository.findByName("Alvi");
		employeeList.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByNameLikeA() {
		List<Employee> employees = employeeRepository.findByNameLike("H%");
		employees.forEach(e -> System.out.println(e.getId()));
	}

	@Test
	public void testFindByAgeBetween() {
		List<Employee> employees = employeeRepository.findByAgeBetween(30, 50);
		employees.forEach(e -> System.out.println(e.getId()));
	}
}
