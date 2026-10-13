package com.nexora.hrms.employee;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="employees") public class Employee {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false) private String fullName;
@Column(nullable=false,unique=true) private String email;
@Column(nullable=false) private String department;
@Column(nullable=false) private String jobTitle;
@Enumerated(EnumType.STRING) @Column(nullable=false) private EmployeeStatus status=EmployeeStatus.ACTIVE;
private LocalDateTime createdAt=LocalDateTime.now();
public Employee(){} public Long getId(){return id;} public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public String getJobTitle(){return jobTitle;} public void setJobTitle(String v){jobTitle=v;} public EmployeeStatus getStatus(){return status;} public void setStatus(EmployeeStatus v){status=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}
