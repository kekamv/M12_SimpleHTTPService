package m12.service.implement;

import m12.model.Employee;
import m12.model.Role;
import m12.repository.EmployeeRepository;
import m12.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {

        List<Employee> employeesByName=
                employeeRepository.findByName(name);
        if(!employeesByName.isEmpty()){
            return employeesByName;
        }else{
            throw new ResourceAccessException("Record not found with name: " +name);
        }
    }

    @Override
    public List<Employee> findEmployeeByRole(Role role) {

        List<Employee> employeesByRole=
                employeeRepository.findByRole(role);
        if(!employeesByRole.isEmpty()){
            return employeesByRole;
        } else{
            throw new ResourceAccessException("Record not found with name: " +role);
        }
    }


    @Override
    public Employee findEmployeeById(long employeeId) {
        Optional<Employee> employeeDb=employeeRepository.findById(employeeId);

        if(employeeDb.isPresent()){
            return employeeDb.get();
        }else{
            throw new ResourceAccessException("Record not found with id: "+employeeId);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {

        Employee newEmployee= employee;
        newEmployee.setName(employee.getName());
        newEmployee.setRole(employee.getRole());
        newEmployee.setSalary(employee.getRole());

        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Optional<Employee> employeeDb=employeeRepository.findById(id);

        if(employeeDb.isPresent()){
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setName(employee.getName());
            employeeUpdate.setRole(employee.getRole());
            employeeUpdate.setSalary(employee.getRole());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }else{
            throw new ResourceAccessException("Record not found with id: "+employee.getId());
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employeeDb=employeeRepository.findById(id);

        if(employeeDb.isPresent()){
            employeeRepository.delete(employeeDb.get());
        }else{
            throw new ResourceAccessException("Record not found with id: "+id);
        }

    }

}
