# Employee Management Application

This Java application manages employee data in a database table called "Employee". It performs the following tasks:

## Tasks

1. Make a java application to do the following:
   1. Create a table with name “Employee", with fields: Id, F_Name, L_Name, Sex, Age, Address, Phone Number, Vaction_Balance "30 days for each employee".
   2. Insert 5 rows at least- with different data using PreparedStatement object.
2. Using Batching to do the following related to the
   above database:
   1. Modify the Vacation_Balance of employees over 45 years to be increased to 45 days rather than 30.
   2. For those employees, title the F_Name with Mr/Mrs.

## To Run App

``` bash
mvn compile exec:java
```

## Used Technologies

- Java: v19
- Apache Maven: v3.8.7
- MYSQL 8.0
