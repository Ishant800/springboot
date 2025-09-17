package com.example.demo.DTO;
public class EmployeeDto {
//    private Long id;
    private String empname;
    private String empaddress;
    private Long salary;
    private Long empno;


    public EmployeeDto(String empname,String empaddress,Long salary,Long empno){
        this.empname = empname;
        this.empaddress = empaddress;
        this.salary = salary;
        this.empno = empno;
    }

    public String getEmpname(){return empname;}
    public void setEmpname(String empname){this.empname = empname;}

    public String getEmpaddress() {
        return empaddress;
    }
    public void setEmpaddress(String empaddress) { this.empaddress = empaddress; }

    public Long getSalary(){return salary;}
    public void setSalary(Long salary){this.salary = salary;}

    public Long getEmpno(){return empno;}
    public void setEmpno(Long empno){this.empno = empno;}
}
