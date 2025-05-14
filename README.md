# SecureStaff - Spring Boot MVC CRUD Application

This is a Spring Boot application for managing employees. It supports **Employee**, **Manager**, and **Admin** roles, with role-based access control (RBAC). You can run it with an in-memory **H2** database for simplicity or configure it to use your local **MySQL** database for real-world scenarios.

## 🛠️ **Technologies Used**
- Spring Boot
- Spring Security (Authentication & Authorization)
- Spring Data JPA (For interfacing with database)
- Thymeleaf (For UI rendering)
- H2 Database (For in-memory storage)
- MySQL (For local database)

## 🗄️ **Database Setup**

### 1. **H2 (In-Memory Database)**

By default, this project is set up to use the **H2 database**. It will store data in memory and does not require any external setup. The application will automatically create the necessary tables when started.

To use **H2**:
- Simply run the application, and H2 will handle everything.
- You can access the H2 console via:  
  `http://localhost:8080/h2-console`  
  (Login with `jdbc:h2:mem:testdb` and username/password as `sa`).

### 2. **MySQL (Local Database)**

If you want to use a **MySQL** database, follow these steps:
1. Make sure you have **MySQL** installed and running locally.
2. Create a database called `your_db` (or any name you prefer) in MySQL.
3. Update `src/main/resources/application-mysql.properties` with your MySQL credentials.

Example configuration:
```properties
# src/main/resources/application-mysql.properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.profiles.active=mysql
```

## 🔑 **User Roles & Access**

This application supports **role-based access control (RBAC)** with four types of roles. Below are the roles, their access levels, and their associated permissions.

### 1. **Employee**
- **Username**: `john`
- **Password**: `test123`
- **Access**:
    - Can view and update their own profile.
    - Limited access to CRUD operations (only for their personal data).
- **Permissions**:
    - View personal information.
    - Edit personal details.

### 2. **Manager**
- **Username**: `mary`
- **Password**: `test123`
- **Access**:
    - Can view and manage employee profiles, including adding and updating employee details.
- **Permissions**:
    - View all employee profiles.
    - Add and update employee information.

### 3. **Admin**
- **Username**: `susan`
- **Password**: `test123`
- **Access**:
    - Full administrative access, including user and role management.
    - Can manage employees, roles, and other admin functionalities.
- **Permissions**:
    - View and manage employee and manager profiles.
    - Add, update, and delete users and roles.
    - Full access to all CRUD operations on employee data.

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgements

- **Spring Boot** for building the backend.
- **Thymeleaf** for server-side rendering of templates.
- **H2 Database** for in-memory storage.
- **Spring Security** for authentication and authorization.

---

## Contact

For more information, feel free to reach out to:
- **Name**: Syed Azhar
- **Email**: syedpersonal23@gmail.com
- **LinkedIn**: [LinkedIn Profile](https://www.linkedin.com/in/syedazhar001/)

---

## Contributing

We welcome contributions! Please fork this repository, make your changes, and submit a pull request.

Made By Syed Azhar