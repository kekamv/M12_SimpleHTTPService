package m12.controller;

import m12.model.Employee;
import m12.model.Role;
import m12.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    //get all
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.findAllEmployee());
    }

    //get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable(name="id")  Long id){
        return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
    }

    //get employees by role
    @GetMapping("/r/{role}")
    public ResponseEntity<List<Employee>> getEmployeesByRole (@PathVariable(name="role") Role role){
        return ResponseEntity.ok().body(employeeService.findEmployeeByRole(role));
    }

    //get employees by name
    @GetMapping("/n/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByName (@PathVariable(name="name") String name){
        return ResponseEntity.ok().body(employeeService.findEmployeeByName(name));
    }

    //create employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    //update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee,
                                                   @PathVariable("id") long id){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee, id));

    }

    //delete employee by id
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable("id") long id){

        employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

}
