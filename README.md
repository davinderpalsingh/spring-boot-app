mobile-app-ws is a Spring Boot Application which is intended to showcase the following:

1. How to write a new rest webservice end point.
2. How to use My SQL database with Spring Boot.
3. How to use Spring Data JPA to map entities with DB and persist them.
4. How to configure rest web service end points as public and private by using Spring Security Framework.
5. How to use Spring Security Framework Encryption api to encrypt password before persisting in DB.


As part of this application, 4 end points are implemented:



Http Method           URI                       Access type             Description 
GET                   /users/{userid}           public                  Retrieves user details from database   
POST                  /users                    public                  Create new user: Sign up / Create Account
PUT                   /users/{userid}           private                 Update existing user details
DELETE                /users/{userid}           private                 Deletes existing user  


To see the webservices in action:

1. Clone repo.
2. Install My SQL database Community Edition.


