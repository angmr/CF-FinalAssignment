# CF-FinalAssignment
### Fullstack Web App with JDBC

## Doctors Appointment Management System

A Java EE web application for managing doctors and patients, developed as a final assignment for the Coding Factory program.
The system follows the MVC pattern using JSP for views, Servlets for controllers, and DAO + Service layers for business logic and persistence.

### Features
= User registration and login
- Add, update, delete doctors
- Add, update, delete patients
- Book and manage appointments
- Input validation and error handling
- Layered architecture (Controller → Service → DAO → DB)

### Technologies Used
- Java EE (Servlets, JSP)
- JDBC (MySQL / H2 depending on configuration)
- HTML, CSS, Bootstrap
- Apache Tomcat (tested with Tomcat 9)
- Maven (for dependency management and build)

### Project Structure
src/main/java/gr/aueb/cf/doctorsapp/
    controller/   → Servlets (handle HTTP requests)
    dao/          → Data access objects (JDBC)
    service/      → Business logic
    model/        → Entities (Doctor, Patient, Appointment)
    dto/          → Data transfer objects

src/main/webapp/
    jsps/         → JSP views
    static/       → CSS, JS, images
    WEB-INF/      → web.xml configuration

    
### ⚙️ Installation & Setup

##### Clone the repository
git clone https://github.com/angmr/CF-FinalAssignment.git
cd CF-FinalAssignment

##### Build with Maven
mvn clean package

##### Deploy to Tomcat
Copy the generated .war file from target/ into Tomcat’s webapps/ folder
Start Tomcat and access the app at: http://localhost:8080/doctorsapp

###### Database Setup
Import the SQL schema (see resources/schema.sql) into MySQL (or configure H2)
Update DB credentials in dao/DBUtil.java if needed
