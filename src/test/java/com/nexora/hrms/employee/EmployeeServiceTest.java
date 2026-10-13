package com.nexora.hrms.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock EmployeeRepository repository;
    @InjectMocks EmployeeService service;

    @Test
    void createsEmployeeAndNormalizesEmail() {
        when(repository.existsByEmailIgnoreCase("priya@example.com")).thenReturn(false);
        when(repository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));
        EmployeeRequest request = new EmployeeRequest(" Priya Sharma ", "priya@example.com", " Engineering ", "Software Engineer", EmployeeStatus.ACTIVE);

        Employee result = service.create(request);

        assertEquals("Priya Sharma", result.getFullName());
        assertEquals("priya@example.com", result.getEmail());
        assertEquals("Engineering", result.getDepartment());
        verify(repository).save(any(Employee.class));
    }

    @Test
    void rejectsDuplicateEmail() {
        when(repository.existsByEmailIgnoreCase("priya@example.com")).thenReturn(true);
        EmployeeRequest request = new EmployeeRequest("Priya Sharma", "priya@example.com", "Engineering", "Engineer", EmployeeStatus.ACTIVE);
        assertThrows(DuplicateEmailException.class, () -> service.create(request));
        verify(repository, never()).save(any(Employee.class));
    }

    @Test
    void returnsAllEmployeesWhenSearchIsBlank() {
        Employee employee = new Employee();
        when(repository.findAll()).thenReturn(List.of(employee));
        assertEquals(1, service.findAll(" ").size());
        verify(repository).findAll();
    }

    @Test
    void searchesAcrossEmployeeFields() {
        when(repository.findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrJobTitleContainingIgnoreCase("engineering", "engineering", "engineering", "engineering"))
                .thenReturn(List.of(new Employee()));
        assertEquals(1, service.findAll(" engineering ").size());
    }

    @Test
    void throwsWhenEmployeeDoesNotExist() {
        when(repository.findById(42L)).thenReturn(Optional.empty());
        assertThrows(EmployeeNotFoundException.class, () -> service.findById(42L));
    }
}
