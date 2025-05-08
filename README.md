# Critter Chronologer 🐾

Critter Chronologer is a scheduling application for a pet service business that allows users to manage customers, pets, employees, and their service schedules. This project is built using **Spring Boot**, and it demonstrates object-relational mapping, RESTful APIs, and full-stack integration with a frontend.

## 🚀 Features

- Manage Customers and their Pets
- Employee management and availability scheduling
- Service appointments linking Pets, Employees, and Customers
- Role-based functionality to retrieve schedules by employee or pet
- RESTful API with persistence using Spring Data JPA
- Backend integration with a provided frontend UI

---

## 🧰 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (in-memory)
- Maven
- Jackson (JSON processing)
- Lombok (for cleaner code)
- Java Bean Validation (JSR 380)
- ModelMapper
- RESTful APIs

---

## 🗂️ Project Structure

critter-chronologer/
│
├── src/
│ ├── main/
│ │ ├── java/com.udacity.jdnd/course3/critter/
│ │ │ ├── controller/ # REST API controllers
│ │ │ ├── entity/ # JPA Entities: Customer, Employee, Pet, Schedule
│ │ │ ├── repository/ # Spring Data JPA Repositories
│ │ │ ├── service/ # Business logic
│ │ │ └── CritterApplication.java # Main class
│ └── test/ # Unit and integration tests
│
├── pom.xml # Maven build file
└── README.md # Project documentation

---

## 📦 How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/critter-chronologer.git
   cd critter-chronologer
mvn clean install
Run the Spring Boot application:
mvn spring-boot:run
