# H2employeedemo
INSTALLATION
required programs to run this application it is utilized with:
Eclipse IDE Version: 2020-09 (4.17.0)
JDK 8
H2 database dependency
SpringBoot V (2.5.0)
Apache Maven V (3.8.1)
Postman V (8.5.1)

LAUNCHING
Once all programs are installed, run the program in eclipse and open a Postman Tab. 
The url is the local url http://localhost:8080/employees.
With employees being the main end point for this program.
all information is entered in JSON format. only these fields are need to be entered as ID and Status are auto assigned
"firstName": 
"middleInitial": 
"lastName":
"dateOfBirth":
"dateOfEmployment":

to start you must add an employee set the function to a POST request
Set the end point to http://localhost:8080/employees and enter the information listed above.

complete a GET request to retrieve all employees.*

for a specific Employees add a specific add an aditional end point with the Employees ID http://localhost:8080/employees/1 
and run an additional GET request.*

*deleted employees will not appear in active searches. 

to update an employees information you need to set the end point for the employee being updated http://localhost:8080/employees/1 
and run a PUT request after entering to update a specific employee. 

to delete select a specific end point http://localhost:8080/employees/1 and send a DELETE request to set that employees status to INACTIVE 
and hide them From all results.


DESCRIPTION

This is a simple CRUD application developed to keep employee records, administrators can interact with the application and perform these functions listed. 

GET read, POST create, PUT update, and DELETE (Set to Inactive and hide from results) records for Employees

I utilized the MVN design pattern to help separate and divide the organization of this project to its individual working pieces for functionality and organization.

To demonstrate use of new Java 8 technologies I implemented a Stream to put everything into a list from all employees stored and then I have filtered out to create and return a new list only containing the employees with an ACTIVE enum status.

This application was written in Java with Eclipse IDE it is a Maven project with SpringBoot And H2 dependencies, with a connection to a H2 database where the data is stored in memory. I utitlized Postman to test end points for all functions. I do have the Knowledge as well to store these into a MySQL database as well for continued storage.

I have listed a Link to folder in REPO that contains the ScreenShots of functionality below

(https://github.com/skeletoro/H2employeedemo/tree/main/employee-test-h2/employee-test-h2/ScreenShots)

About Me
I am a proud self based Software Developer. With additional Projects on my GitHub linked below. I am always learning new Technologies and Languages. If I ever come across a challenge I have always been able to research extensively to come to a functional resolution. there is also an additional sister version of this application that will also run in memory on my GH that will run without a H2 database.

https://github.com/skeletoro

This application was created as a Coding challenge for Kenzan Technologies. The project requirements are outlined below.
____________________________________________________________________________________________________________________________________________________________________________________________
Employee REST server
All data should be persisted into either memory, or externally. Please include instructions on how to run and interact with the web server.
Please demonstrate use of Java 8
Please demonstrate use of one or more design patterns and add comments as to why you choose that pattern.
Create a web application that exposes REST operations for employees. The API should be able to:

Get employees by an ID
Create new employees
Update existing employees
Delete employees
Get all employees
An employee is made up of the following data:

Employee spec
 
Startup
On startup, the application should be able to ingest an external source of employees, and should make them available via the GET endpoint.
ACTIVE vs INACTIVE employees
By default, all employees are active, but by way of the API, can be switched to inactive. This should be done by the delete API call. This call should require some manner of authorization header.
When an employee is inactive, they should no longer be able to be retrieved in either the get by id, or get all employees calls
____________________________________________________________________________________________________________________________________________________________________________________________