This application consists of 3 microservices:
user-service
company-service
user-client

Functionality of microservices
user-service:
this microservice has 2 endpoints
/api/users/{userId} --- getting a user by ID
/api/users/{lastName} --- getting a user by Last Name
company-service:
this microservice has 2 endpoints

/api/companies/{companyId} --- getting a company by ID
/api/companies/{name} --- getting a company by name
