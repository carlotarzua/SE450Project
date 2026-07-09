# SecureCourse

SecureCourse is my SE 450 Object Oriented Software Development project. The goal is to build a secure, role-based learning management system in Java. The project will focus on object-oriented design, modular code, testing, and custom implementations of design patterns.

## Sprint 1 Checklist

- **Are you in a Group?**  
  No, I am not in a group.

- **If so, who else is in your group?**  
  N/A

- **Do you have your GitHub account set up?**  
  Yes, I have my GitHub account set up.

- **Do you have a public repository for your Project?**  
  Yes, I have a public repository for my project.

- **What is the link to your GitHub repository?**  
  https://github.com/carlotarzua/SE450Project

- **If you are in a group, does everyone have write access to the GitHub repo?**  
  N/A

- **Do you have a “Hello World” program that compiles and runs?**  
  Yes. Sprint 1 started with a Hello World program. The project has now been expanded into a Spring Boot application for Sprint 2.

- **Where is the entry point to your project?**  
  `src/main/java/com/carlota/securecourse/SecureCourseApplication.java`

## Sprint 2 Project Proposal

### Project Name

**SecureCourse: Role-Based Learning Management System**

### Project Description

SecureCourse will be a learning management system with different user roles and permissions. The main roles will be Student, Instructor, and Admin. Each role will have access to different features in the application.

The goal is not to recreate a large system like Canvas. I plan to build a smaller working application that clearly demonstrates object-oriented design, security roles, modular classes, JUnit testing, and at least six custom design patterns.

### Planned Users and Features

#### Student

- View available courses
- Enroll in courses
- View assignments
- Submit assignments
- View grades

#### Instructor

- Create and manage courses
- Create assignments
- View enrolled students
- Grade submissions
- Publish course updates

#### Admin

- Manage users
- Assign roles
- View all courses
- Manage system-level settings

### Planned Technologies and Libraries

- Java 21
- Spring Boot
- Spring Security
- PostgreSQL
- Spring Data JPA
- JUnit
- Maven
- GitHub

For Sprint 2, the project includes a Spring Boot starter application, basic role-based security, starter course and user domain classes, and JUnit tests. PostgreSQL persistence and the larger feature set will be added in later sprints.

### Planned Design Patterns

The exact design may change as the application grows, but I currently plan to implement these patterns myself:

1. **Factory Pattern** - create different user types such as Student, Instructor, and Admin
2. **Strategy Pattern** - support different grading strategies
3. **Observer Pattern** - notify students when assignments or course updates are published
4. **State Pattern** - manage course states such as Draft, Open, In Progress, Completed, and Archived
5. **Command Pattern** - represent actions such as enrolling, dropping a course, submitting an assignment, and undoing supported actions
6. **Builder Pattern** - create Course objects with required and optional settings

These patterns will be implemented in my own project code. I will not count design patterns that are already built into Spring or other libraries.

### What I Plan to Demonstrate by the Final Submission

By the final submission, I plan to demonstrate a working application where:

- Users can authenticate
- Different roles have different permissions
- Students can view and enroll in courses
- Instructors can manage courses and assignments
- Admin users can manage users and roles
- Data is stored in PostgreSQL
- JUnit tests verify important behavior
- At least six different design patterns work as part of the application

### Current Sprint 2 Progress

- Converted the project from Hello World into a Spring Boot application
- Added a public application status endpoint
- Added role-based access rules with Spring Security
- Added Student, Instructor, and Admin demo accounts
- Added starter `UserAccount`, `Role`, and `Course` domain classes
- Added an in-memory `CourseService` with demo courses
- Added protected course and dashboard endpoints
- Added JUnit tests for course enrollment behavior

## Current Project Structure

```text
SE450Project/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/com/carlota/securecourse/
│   │   │   ├── SecureCourseApplication.java
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/carlota/securecourse/
└── .gitignore
```

## Running the Project

Requirements:

- Java 21
- Maven

Run the application:

```bash
mvn spring-boot:run
```

Run tests:

```bash
mvn test
```

Then open:

```text
http://localhost:8080/
```

Public status endpoint:

```text
http://localhost:8080/api/status
```

### Demo Accounts

These accounts are only temporary Sprint 2 demo users. They will later be replaced with persistent users.

| Role | Username | Password |
|---|---|---|
| Student | `student` | `student123` |
| Instructor | `instructor` | `instructor123` |
| Admin | `admin` | `admin123` |

Protected endpoints:

```text
/api/student/dashboard
/api/student/courses
/api/instructor/dashboard
/api/instructor/courses
/api/admin/dashboard
```
