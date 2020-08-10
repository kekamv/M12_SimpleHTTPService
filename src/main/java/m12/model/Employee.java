package m12.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="employees")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotNull
    private String name;
    private Role role;
    private double salary;

    public Employee(){

    }

    public Employee(String name, Role role){
        this.name=name;
        this.role=role;
        salary=role.getSalaryEnum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return role.getSalaryEnum();
    }

    public void setSalary(Role role) {
        this.salary = role.getSalaryEnum();
    }

    @Override
    public String toString() {
        return String.format(
                "Employee [id: '%d', name: '%s', role: '%s', salary: '%.2f%n'", id, name, role, salary);
    }
}
