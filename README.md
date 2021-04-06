## User management system API gateway
Implement an API gateway that is the single entry point for all clients.
the API gateway receives user requests and handles them. 

good luck.
___
## Curl endpoints
 To get all users : 
 
 `curl -X GET http://localhost:8082/api/users`
 
 To add a user :
 
 `curl -X POST -d 'firstName'='ali' -d 'lastName'='ahmadi' -d 'emailAddress'='hello@gmail.com' http://localhost:8082/api/users`
 
 To get a user by id :
 
 `curl -X GET -G http://localhost:8082/api/user -d 'id'='1' `
 
 To delete a user by id:
 
 `curl -X DELETE -G http://localhost:8082/api/users -d 'id'='1' `