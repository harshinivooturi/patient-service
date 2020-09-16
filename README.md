# patient-service

Swagger Documentation
   
    http://localhost:8080/swagger-ui.html
    
Sample json data for post patient: 
End point : /patient

       {
           "firstName": "John",
           "lastName": "Doe",
           "address": "123 Street Unit 3",
           "city": "new York",
           "state": "NY",
           "zipCode": "45367",
           "phoneNumber": "123.456.7890",
           "email": "jdoe@xyz.com"
         }

Endpoint : /datapoint

Files uploaded using this endpoint are saved in user's home directory with filename - "myFile.xml" [Hardcoded filename since filename can't be retrieved from the binary stream] 

Use below curl command to upload a file in binary


    curl --data-binary @<FILE-PATH> http://localhost:8080/datapoint
    
    
Endpoint: /multipartDataPoint

Files uploaded using this endpoint are saved in user's home directory with uploaded filename. 

Use below curl command to upload a multipart file
 
    curl -F 'file=@<FILE-PATH>' http://localhost:8080/multipartDataPoint