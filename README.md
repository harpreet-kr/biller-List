# biller-List
RESTFUL web service using Spring Boot which gives biller list based on search input provided by user.

POST API endpoint created:
/biller-list/search

Request param : String value (for example - BSE)

To run it on local:
1. Clone the repository.
2. Import it as a Maven project in any IDE.
3. Get the dependencies installed using mvn clean install;
4. Run it as a java application. By default, Springboot application will start up on port 8080.
5. Using POSTMAN or any tool, hit the endpoint:
    http://localhost:8080/biller-list/search
    In request body, pass any string value as search parameter

