package com.nexora.hrms.employee;
import jakarta.validation.constraints.*;
public record EmployeeRequest(@NotBlank @Size(max=100) String fullName,@NotBlank @Email String email,@NotBlank String department,@NotBlank String jobTitle,@NotNull EmployeeStatus status) {}
