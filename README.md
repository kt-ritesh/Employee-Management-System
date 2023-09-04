<h1 align = "center"> Employee Management System </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
</p>
This is a backend API built using the SpringBoot framework that handles various HTTP requests for Employee and Employee Report entity classes.

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok

<br>

## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.url=jdbc:mysql://localhost:3306/<databaseName>
spring.datasource.username=<userName>
spring.datasource.password=<password>
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>

## Language Used
* Java

---
<br>

## Data Model

The Job data model is defined in the Job class, which has the following attributes:
<br>

* Employee
```
empId (Long)
empName (String)
empEmail (String)
empAddress (String)
empDesignation (Designation);
empSalary (Double)
joiningDate (LocalDate)
```

* Report
```
reportId (Long)
isPresent (Boolean)
date (LocalDate)
rating (Double)
employee (Employee)
```
## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points 

The following endpoints are available in the API:

```
EmployeeController:
/your/details (GET): Employee can see own details. 
/update/personal/details (PUT): Employee can update own personal details.
/mark/attendance (POST): Employee can mark own attendance.
```

HrController:
```
/add/employee (Post): HR can add new Employee.
/remove/employee (Delete): HR can add remove Employee.
/employee/details/{empId} (GET): HR can add get any Employee Details.
/hike/salary (PUT): HR can give the salary hike to the Employee.
/promotion (PUT): HR can give the Deaignatin promotion to the Employee.
/give/rating/{empId} (PUT) : HR can give performance rating to the Employee.
```
EmployeeReport:
```
/get/performance/{empId} (GET) : HR or Employee can see performance details by there empId.
/get/emp/report (GET) : HR can see all details report about any Employee by there id.
/get/attendance/count (GET) : HR and Employee can see there attendance details.
```
<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary

The Employee Management System using Spring Boot is a user-friendly and efficient application that streamlines the management of employee data. This application provides an easy-to-use interface for HR personnel to manage employee information, and also allows employees to view and update their own personal details. With its advanced features such as reporting and user management, this application is a valuable tool for any organisation looking to manage their employee data effectively.


## Author

👤 **Rites kr. Thakur**

* GitHub: [kt-ritesh](https://github.com/kt-ritesh)

* LinkedIn: [Ritesh kr. Thakur](https://www.linkedin.com/in/kt-ritesh/)
    
---
    
## Show your support

Give a ⭐️ if this project helped you!
    
---
