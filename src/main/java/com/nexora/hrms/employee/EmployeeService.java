package com.nexora.hrms.employee;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) { this.repository = repository; }

    @Transactional(readOnly = true)
    public List<Employee> findAll(String search) {
        if (search == null || search.isBlank()) return repository.findAll().stream().sorted((a,b)->Long.compare(b.getId(),a.getId())).toList();
        String q = search.trim();
        return repository.findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCaseOrJobTitleContainingIgnoreCase(q,q,q,q);
    }
    @Transactional(readOnly = true)
    public Employee findById(Long id) { return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)); }
    public Employee create(EmployeeRequest request) {
        if (repository.existsByEmailIgnoreCase(request.email())) throw new DuplicateEmailException(request.email());
        Employee employee = new Employee(); apply(employee, request);
        try { return repository.save(employee); } catch (DataIntegrityViolationException ex) { throw new DuplicateEmailException(request.email()); }
    }
    public Employee update(Long id, EmployeeRequest request) {
        Employee employee = findById(id);
        repository.findByEmailIgnoreCase(request.email()).ifPresent(existing -> { if (!existing.getId().equals(id)) throw new DuplicateEmailException(request.email()); });
        apply(employee, request);
        try { return repository.save(employee); } catch (DataIntegrityViolationException ex) { throw new DuplicateEmailException(request.email()); }
    }
    public void delete(Long id) { repository.delete(findById(id)); }
    private void apply(Employee employee, EmployeeRequest request) {
        employee.setFullName(request.fullName().trim()); employee.setEmail(request.email().trim().toLowerCase()); employee.setDepartment(request.department().trim()); employee.setJobTitle(request.jobTitle().trim()); employee.setStatus(request.status());
    }
}
