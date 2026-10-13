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
                {"Aarav Mehta", "aarav.mehta.demo@example.com", "Engineering", "Software Engineer", "ACTIVE"},
                {"Priya Sharma", "priya.sharma.demo@example.com", "Human Resources", "HR Specialist", "ACTIVE"},
                {"Rohan Reddy", "rohan.reddy.demo@example.com", "Finance", "Financial Analyst", "ACTIVE"},
                {"Ananya Iyer", "ananya.iyer.demo@example.com", "Marketing", "Marketing Executive", "ACTIVE"},
                {"Ishaan Verma", "ishaan.verma.demo@example.com", "Engineering", "Backend Developer", "ACTIVE"},
                {"Diya Nair", "diya.nair.demo@example.com", "Design", "UI/UX Designer", "ACTIVE"},
                {"Kabir Singh", "kabir.singh.demo@example.com", "Sales", "Sales Associate", "ACTIVE"},
                {"Meera Patel", "meera.patel.demo@example.com", "Operations", "Operations Coordinator", "ACTIVE"},
                {"Arjun Rao", "arjun.rao.demo@example.com", "Engineering", "QA Engineer", "ACTIVE"},
                {"Sana Khan", "sana.khan.demo@example.com", "Customer Support", "Support Specialist", "ACTIVE"},
                {"Vivaan Gupta", "vivaan.gupta.demo@example.com", "Finance", "Accounts Executive", "ACTIVE"},
                {"Kavya Menon", "kavya.menon.demo@example.com", "Human Resources", "Talent Acquisition Associate", "ACTIVE"},
                {"Aditya Joshi", "aditya.joshi.demo@example.com", "IT", "System Administrator", "ACTIVE"},
                {"Ira Desai", "ira.desai.demo@example.com", "Marketing", "Content Strategist", "ACTIVE"},
                {"Reyansh Kulkarni", "reyansh.kulkarni.demo@example.com", "Engineering", "Frontend Developer", "ACTIVE"},
                {"Aditi Chawla", "aditi.chawla.demo@example.com", "Legal", "Compliance Associate", "ACTIVE"},
                {"Atharv Bose", "atharv.bose.demo@example.com", "Sales", "Account Executive", "ACTIVE"},
                {"Nisha Thomas", "nisha.thomas.demo@example.com", "Customer Support", "Customer Success Associate", "ACTIVE"},
                {"Krish Malhotra", "krish.malhotra.demo@example.com", "Product", "Product Analyst", "ACTIVE"},
                {"Pooja Das", "pooja.das.demo@example.com", "Operations", "Project Coordinator", "ACTIVE"},
                {"Dev Shah", "dev.shah.demo@example.com", "Engineering", "DevOps Engineer", "ACTIVE"},
                {"Tara Fernandes", "tara.fernandes.demo@example.com", "Design", "Visual Designer", "ON_LEAVE"},
                {"Neil Kapoor", "neil.kapoor.demo@example.com", "IT", "Technical Support Engineer", "ACTIVE"},
                {"Riya Banerjee", "riya.banerjee.demo@example.com", "Research", "Research Associate", "INACTIVE"},
                {"Manav Sethi", "manav.sethi.demo@example.com", "Product", "Business Analyst", "ACTIVE"}
            };

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
