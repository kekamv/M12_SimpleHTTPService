package m12.model;

public enum Role {

    RECEPTIONIST (27000),
    RESEARCHER (34000),
    DEVELOPER (34500),
    MKTGASSISTANCE (25000);

    private double salary;

    public double getSalaryEnum(){
        return this.salary;
    }

    Role(double salary){
        this.salary=salary;
    }
}