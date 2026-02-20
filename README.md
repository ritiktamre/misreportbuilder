# 📊 Dynamic MIS Report Builder

A Spring Boot-based Management Information System (MIS) that dynamically generates employee performance reports using filter-based query building and aggregation.

---

## 🚀 Features

- Dynamic report generation with multiple filter combinations
- Aggregated metrics:
  - Total Attendance
  - Total Sales
  - Average Performance Score
- Safe query construction (parameterized queries)
- MySQL database integration
- REST API support
- Thymeleaf-based UI
- CSV export functionality
- Optimized queries using indexing
- Clean layered architecture (Controller → Service → Repository)

---

## 🏗 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Thymeleaf
- Maven

---

## 📂 Project Structure


com.example.misreport
│
├── controller
├── service
├── repository
├── entity
├── dto
├── util
└── MisreportApplication.java


---

## 🗄 Database Schema

### Tables:

- Department
- Employee
- Attendance
- Sales_Record

### Relationships:

- Employee → Many-to-One → Department
- Attendance → Many-to-One → Employee
- Sales_Record → Many-to-One → Employee

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone <your-repo-url>
cd misreport
2️⃣ Create Database
CREATE DATABASE misdb;
3️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/misdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
4️⃣ Run Application
mvn clean install
mvn spring-boot:run

Application runs at:

http://localhost:8080
🌐 UI Access

Open in browser:

http://localhost:8080/report-ui

Generate dynamic reports using filters.

📡 REST API
Generate Report
POST /api/reports

Sample Request:

{
  "departmentId": 1,
  "role": "Developer"
}

Sample Response:

[
  {
    "employeeName": "Manoj",
    "totalAttendance": 20,
    "totalSales": 150000,
    "averagePerformance": 4.5
  }
]

📤 CSV Export

Export report data in CSV format for external analysis.
