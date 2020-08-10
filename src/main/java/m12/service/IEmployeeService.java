package m12.service;

import m12.model.Employee;
import m12.model.Role;

import java.util.List;


public interface IEmployeeService {

    List <Employee> findAllEmployee();

    List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeeByRole (Role role);

    Employee findEmployeeById (long employeeId);

    Employee createEmployee(Employee employee);


    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);

}
