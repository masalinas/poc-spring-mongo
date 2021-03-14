# Description
Spring MongoDB Keycloak Swagger Integration PoC

# Dependencies
Java Runtime (Spring Keycloak 11.x not works with upper version)
- JVM 11

Spring Boot dependencies:
- Spring Boot 2.4.0

Spring Boot Web dependencies:
- Spring Boot Web 2.4.0

Spring Security and IAM dependencies
- Spring Boot Security 2.4.0
- Spring Boot Keycloak: 11.0.3

Spring Data dependencies
- Spring Boot Data MongoDB 2.4.0
- Spring Boot Validation 2.4.0

Spring Swagger dependecies
- Spring Swagger 2.9.2
- Spring Swagger UI 2.9.2
- Spring Swagger Validation 2.9.2

# Scaffolding 
[Spring initializr](https://start.spring.io)

# IAM URI
[http://localhost:8080](http://localhost:8080)

![image](https://user-images.githubusercontent.com/1216181/111074714-914bb580-84e4-11eb-99b8-afd19b0c27fe.png)

# Swagger UI URI
[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

![image](https://user-images.githubusercontent.com/1216181/111074726-a7597600-84e4-11eb-8034-74bc00c1b415.png)

# Create realm
Create a new oferto realm with name Oferto

![image](https://user-images.githubusercontent.com/1216181/111074509-8e03fa00-84e3-11eb-8fd2-54b88f38cc74.png)

# Create roles
Create two roles named: admin and user

![image](https://user-images.githubusercontent.com/1216181/111074571-cefc0e80-84e3-11eb-966e-d8f1fbe45144.png)

# Create users
Create two users:
- **Admin user**: with username masalinas and role admin
- **Test user**: with username test and role user

![image](https://user-images.githubusercontent.com/1216181/111074602-ff43ad00-84e3-11eb-92aa-4af74ad83ee5.png)