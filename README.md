# RawHttpClient

### 1) Building the project

    mvn clean compile assembly:single

### 2) httpc

cURL-like Java HTTP 1.0 client implementation

Running the httpc program:
    
POST a json file: 
    
    java -jar target/httpc-1.0-jar-with-dependencies.jar post -v -h Content-Type:application/octet-stream -f <path to json file> http://httpbin.org/post
    
GET request with headers:

    java -jar target/httpc-1.0-jar-with-dependencies.jar get -v -h Content-Type:text/html -h Accept-Language:en-US
    http://httpbin.org/get?course=networking&assignment=1
    
POST request with inline data:

    java -jar target/httpc-1.0-jar-with-dependencies.jar post -v -h Content-Type:application/json -h Accept:application/json 
    -d '{"assignment":1,"other":{"one":1,"two":2}}' http://httpbin.org/post
    
POST a text file:

    java -jar target/httpc-1.0-jar-with-dependencies.jar post -h Content-Type:application/octet-stream -f <path to text file> http://httpbin.org/post
    
Getting help:

    java -jar target/httpc-1.0-jar-with-dependencies.jar post help
    java -jar target/httpc-1.0-jar-with-dependencies.jar get help
    
