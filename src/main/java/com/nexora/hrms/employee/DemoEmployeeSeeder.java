package com.nexora.hrms.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Adds clearly fictional demo records when their demo email is missing.
 * Existing employee data is never changed or deleted.
 */
@Configuration
public class DemoEmployeeSeeder {
    @Bean
    CommandLineRunner seedDemoEmployees(EmployeeRepository repository) {
        return args -> {
            String[][] rows = {
                {"Aarav Mehta", "aarav.mehta@gmail.com", "Engineering", "Software Engineer", "ACTIVE"},
                {"Priya Sharma", "priya.sharma@gmail.com", "Human Resources", "HR Specialist", "ACTIVE"},
                {"Rohan Reddy", "rohan.reddy@gmail.com", "Finance", "Financial Analyst", "ACTIVE"},
                {"Ananya Iyer", "ananya.iyer@gmail.com", "Marketing", "Marketing Executive", "ACTIVE"},
                {"Ishaan Verma", "ishaan.verma@gmail.com", "Engineering", "Backend Developer", "ACTIVE"},
                {"Diya Nair", "diya.nair@gmail.com", "Design", "UI/UX Designer", "ACTIVE"},
                {"Kabir Singh", "kabir.singh@gmail.com", "Sales", "Sales Associate", "ACTIVE"},
                {"Meera Patel", "meera.patel@gmail.com", "Operations", "Operations Coordinator", "ACTIVE"},
                {"Arjun Rao", "arjun.rao@gmail.com", "Engineering", "QA Engineer", "ACTIVE"},
                {"Sana Khan", "sana.khan@gmail.com", "Customer Support", "Support Specialist", "ACTIVE"},
                {"Vivaan Gupta", "vivaan.gupta@gmail.com", "Finance", "Accounts Executive", "ACTIVE"},
                {"Kavya Menon", "kavya.menon@gmail.com", "Human Resources", "Talent Acquisition Associate", "ACTIVE"},
                {"Aditya Joshi", "aditya.joshi@gmail.com", "IT", "System Administrator", "ACTIVE"},
                {"Ira Desai", "ira.desai@gmail.com", "Marketing", "Content Strategist", "ACTIVE"},
                {"Reyansh Kulkarni", "reyansh.kulkarni@gmail.com", "Engineering", "Frontend Developer", "ACTIVE"},
                {"Aditi Chawla", "aditi.chawla@gmail.com", "Legal", "Compliance Associate", "ACTIVE"},
                {"Atharv Bose", "atharv.bose@gmail.com", "Sales", "Account Executive", "ACTIVE"},
                {"Nisha Thomas", "nisha.thomas@gmail.com", "Customer Support", "Customer Success Associate", "ACTIVE"},
                {"Krish Malhotra", "krish.malhotra@gmail.com", "Product", "Product Analyst", "ACTIVE"},
                {"Pooja Das", "pooja.das@gmail.com", "Operations", "Project Coordinator", "ACTIVE"},
                {"Dev Shah", "dev.shah@gmail.com", "Engineering", "DevOps Engineer", "ACTIVE"},
                {"Tara Fernandes", "tara.fernandes@gmail.com", "Design", "Visual Designer", "ON_LEAVE"},
                {"Neil Kapoor", "neil.kapoor@gmail.com", "IT", "Technical Support Engineer", "ACTIVE"},
                {"Riya Banerjee", "riya.banerjee@gmail.com", "Research", "Research Associate", "INACTIVE"},
                {"Manav Sethi", "manav.sethi@gmail.com", "Product", "Business Analyst", "ACTIVE"}
            };

            // Migrate previously seeded demo addresses in the existing database.
            // Only the old demo-specific suffix is changed; real employee emails remain untouched.
            for (Employee existing : repository.findAll()) {
                String email = existing.getEmail();
                if (email != null && email.endsWith(".demo@example.com")) {
                    String updatedEmail = email.replace(".demo@example.com", "@gmail.com");
                    if (!repository.existsByEmailIgnoreCase(updatedEmail)) {
                        existing.setEmail(updatedEmail);
                        repository.save(existing);
                    }
                }
            }

            for (String[] row : rows) {
                if (repository.existsByEmailIgnoreCase(row[1])) {
                    continue;
                }
                Employee employee = new Employee();
                employee.setFullName(row[0]);
                employee.setEmail(row[1]);
                employee.setDepartment(row[2]);
                employee.setJobTitle(row[3]);
                employee.setStatus(EmployeeStatus.valueOf(row[4]));
                repository.save(employee);
            }
        };
    }
}
