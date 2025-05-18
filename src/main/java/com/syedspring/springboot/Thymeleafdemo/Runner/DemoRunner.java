package com.syedspring.springboot.Thymeleafdemo.Runner;

import com.syedspring.springboot.Thymeleafdemo.dao.EmployeeRepository;
import com.syedspring.springboot.Thymeleafdemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoRunner {
    @Bean
    public CommandLineRunner loadData(EmployeeRepository employeeRepository) {
        return args -> {
            String[] firstNames = {
                    "John", "Emily", "Michael", "Sarah", "David", "Emma", "Daniel", "Olivia", "James", "Sophia",
                    "Robert", "Ava", "William", "Isabella", "Joseph", "Mia", "Charles", "Amelia", "Thomas", "Harper",
                    "Christopher", "Evelyn", "Matthew", "Abigail", "Anthony", "Ella", "Mark", "Elizabeth", "Andrew", "Sofia",
                    "Steven", "Avery", "Paul", "Scarlett", "Joshua", "Grace", "Kevin", "Chloe", "Brian", "Victoria",
                    "George", "Riley", "Edward", "Aria", "Justin", "Lily", "Scott", "Zoey", "Brandon", "Penelope",
                    "Jason", "Layla", "Aaron", "Nora", "Gregory", "Hannah", "Frank", "Lillian", "Raymond", "Addison",
                    "Sean", "Aubrey", "Adam", "Ellie", "Patrick", "Stella", "Walter", "Natalie", "Dennis", "Zoe",
                    "Jerry", "Leah", "Nathan", "Hazel", "Carl", "Violet", "Henry", "Aurora", "Jack", "Savannah",
                    "Lawrence", "Brooklyn", "Roger", "Bella", "Albert", "Claire", "Arthur", "Skylar", "Russell", "Lucy",
                    "Joe", "Anna", "Philip", "Paisley", "Willie", "Caroline", "Wayne", "Genesis", "Billy", "Aaliyah"
            };

            String[] lastNames = {
                    "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
                    "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin",
                    "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson",
                    "Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores",
                    "Green", "Adams", "Nelson", "Baker", "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts",
                    "Gomez", "Phillips", "Evans", "Turner", "Diaz", "Parker", "Cruz", "Edwards", "Collins", "Reyes",
                    "Stewart", "Morris", "Morales", "Murphy", "Cook", "Rogers", "Gutierrez", "Ortiz", "Morgan", "Cooper",
                    "Peterson", "Bailey", "Reed", "Kelly", "Howard", "Ramos", "Kim", "Cox", "Ward", "Richardson",
                    "Watson", "Brooks", "Chavez", "Wood", "James", "Bennett", "Gray", "Mendoza", "Ruiz", "Hughes",
                    "Price", "Alvarez", "Castillo", "Sanders", "Patel", "Myers", "Long", "Ross", "Foster", "Jimenez"
            };


            String[] emails = new String[100];

            for (int i = 0; i < 100; i++) {
                emails[i] = firstNames[i].toLowerCase() + lastNames[i].toLowerCase() + "@example.com";
            }

            for (int i = 0; i < 100; i++) {
                Employee emp = new Employee();
                emp.setFirstName(firstNames[i]);
                emp.setLastName(lastNames[i]);
                emp.setEmail(firstNames[i].toLowerCase() + "." + lastNames[i].toLowerCase() + "@example.com");
                employeeRepository.save(emp);
            }
        };
    }
}
