# E-Shopping

Spring Boot Crud Application with JPA, H2 Database 

<ul>
<li>Get all Products</li>
<li>Get product by Id</li>
<li>Add New Product</li>
<li>Update existing Product</li>
<li>Get products based on Category</li>
<li>Get products based on Category and In-stock Availability</li>
</ul>
 
# Product System

This project based on the Spring Boot project and used packages:

<ul>
<li>Spring Boot</li>
<li>Maven</li>
</ul>

## Installation

### 1. Clone the application

<pre> $ git clone https://github.com/anshika04/E-Shopping.git </pre>

### 2. Database Configuration

H2 Database (in-memory) is used as the database.
<ul>
<li> Open src/main/resources/application.properties </li>
<li> If you run the application locally, change the connection properties</li>
<li> If you run the application using any other database, change the connection properties as per new Database installation</li>
</ul>
The project is created with Maven.

### 3. Launch

To run the application locally:

<pre>mvn clean install</pre>

<pre>mvn spring-boot:run</pre>

commands run the application.

<pre>mvn clean test</pre>

command to run JUnit test-cases.

Application runs from localhost:8080/products

Run database through localhost:8080/h2-console
