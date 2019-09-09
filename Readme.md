# Getting Started

This service provides apis to manage survey and support following features :
* submit survey
* retrieve submitted survey

### Code Usage 
**Build it** : *mvnw.cmd clean install*

**Run It** : *java -jar target\survey-submission-service-0.0.1-SNAPSHOT.jar*

**API Documentation** http://localhost:8083/api/swagger-ui.html

**API Usage (via Postman)**
 * Create Submission 
     * Request URL : http://localhost:8083/api/survey/submission
     * Request Body:
        ```
        {
        	"surveyId":"{surveyId}",
        	"questionSubmissions":[
        	    {
        		    "questionId": "{questionId}",
        		    "answerId":"{answerId}"
        	    }]
        }
        ```
     * Response Header:
        ```
        Location : http://localhost:8083/api/survey/submission/{submissionId}  
        ```
     * Response Status:
        ```
        201
        ```
        
 * Retrieve Submission 
    * Request URL : http://localhost:8083/api/survey/submission/{submissionId}
    * Response Body:
        ```
         {
               "surveyId":"{surveyId}",
                "questionSubmissions":[
                 {
                    "questionId": "{questionId}",
                    "answerId":"{answerId}"
                }]
         }
        ```
                    
**Publish Sonar Results** : *mvnw.cmd clean install sonar:sonar -Dsonar.projectKey={projectKey}  -Dsonar.organization={organization}  -Dsonar.host.url={host}  -Dsonar.login={login}*

**Build Docker Container** : *mvnw.cmd clean install dockerfile:build*

### Dev Operations
[Survey Submission Service Travis CI Build](https://travis-ci.org/MLS-CS/survey-submission-service)
: Have integrated code repo with Travis CI which builds the app does following :

* perform and publish, code analysis and code coverage result to sonar cloud.
    * [Survey Submission Service Sonar Report](https://sonarcloud.io/dashboard?id=MLS-CS_survey-submission-service)
* build and publish docker container to docker hub
    * [Survey Submission Service Docker Hub](https://cloud.docker.com/u/mlscs/repository/docker/mlscs/survey-submission-service)
* deployment of docker container is done manually as of now.

### Guides
Refereed following guide's for development:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)