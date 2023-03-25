# URLShortener
This is a simple URL shortener project that allows you to create short URLs for long ones. It consists of a front-end client built with React and a back-end server built with Spring Boot.

# Installation
## Front-end
To install the front-end client, navigate to the frontRnd directory and run npm install to install the required dependencies 
by using the following command you can run the application:
npm start   

## Back-end
To install the back-end server, navigate to the backEnd/Service directory and run mvn install to build the project and download the required dependencies
by using the following command you can run the application
mvn spring-boot:run

##Env variables
Please provide .env file in react with REACT_API_END_POINT pointing to the local server address ex: "http://localhost:8080/"
In application.properties please provide mongodb connection uri

##MongoDB Schema:
{
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'url',
      'shortenedUrl',
      'timestamp'
    ],
    properties: {
      url: {
        bsonType: 'string'
      },
      shortenedUrl: {
        bsonType: 'string'
      },
      timestamp: {
        bsonType: 'date'
      }
    }
  }
}

##Contributors
Srichandan Yerragudi
