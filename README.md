# How to create Spring Boot CRUD application using MVC with REST, JPA, Hibernate + MySQL

## STEP 1: Setup Project
1. Go to https://start.spring.io/
2. Type Group Name, Artifacts and dependencies like below screen.
3. Click on generate project
4. Save project in your workspace
5. Load in to your favorite IDE, mine is IntelliJ IDEA(https://www.jetbrains.com/idea/).

## 2.	STEP2: Setup MySQL
1. Create your database locally.
2. Set below properties in  src\main\resources\application.properties

```
#=============================================================================
#                                    DATA SOURCE
# =============================================================================
# Connection url for the database "democrud"
spring.datasource.url = jdbc:mysql://localhost:3306/democrud?useSSL=false
# Username and password
spring.datasource.username=root
spring.datasource.password=****************
# Keep the connection alive if idle for a long time
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1
# ==========================================================================
#                                  JPA / HIBERNATE
# ==========================================================================
# Show or not log for each sql query
spring.jpa.show-sql = true
# Hibernate ddl auto (create, create-drop, update): with "update" the database
# schema will be automatically updated accordingly to java entities found in
# the project, on production make it none.
spring.jpa.hibernate.ddl-auto = update
```

## 3. STEP 3: Setup Project Structure.
1. Crete Packages controller, entity, model, repository, service(see project structure)

## 4. STEP 4: Create Entity

1. see User entity code https://github.com/kjoshi07/spring-boot-crud-demo/blob/master/src/main/java/com/kj/springbootcruddemo/entity/User.java
2. mark notation @Entity
3. mark notation @Table  //if you need to explicitly define table name then use @Table(name = "user")

## 5. Create repository
 1. Create interface UserRepository under repository package, mark notation @Repository and extend it to JpaRepository.
 2. check code file https://github.com/kjoshi07/spring-boot-crud-demo/blob/master/src/main/java/com/kj/springbootcruddemo/repository/UserRepository.java
 
## STEP 6: Create Service and its implementaion
1.	Create interface UserService under service Package.
2.	Create below methods for CRUD
  
  ```
  User saveUser(User user);

  User findUserById(Long userId);

  List<User> findAllUsers();

  User updateUser(User user);

 void deleteUser(Long userId);

```

3.	Create UserServiceImpl and implement UserService interface.
4.	Mark notation @Service with name = “userService”.
5. check package https://github.com/kjoshi07/spring-boot-crud-demo/tree/master/src/main/java/com/kj/springbootcruddemo/service

## STEP 7:Create controlle
 1. create all required end points. and mark it with @RestController, see https://github.com/kjoshi07/spring-boot-crud-demo/blob/master/src/main/java/com/kj/springbootcruddemo/controller/UserController.java



