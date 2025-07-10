# Person App
Dummy client-server app, which was created to have something for playing with OpenShift + Helm.

## Person Server
Dummy server having 4 endpoints:
- GET - all persons
- GET - specific person by its ID
- POST - create a new person
- DELETE - specific person by its ID

## Person Client
Client having 2 endpoints:
- POST /generate
  - generates a new person
  - by calling POST /persons at the server
- GET /generate
  - returns all the generated people
  - by calling GET /persons at the server
