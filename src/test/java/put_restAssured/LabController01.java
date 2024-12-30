package put_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LabController01 {

    @Test
    public void updateUser() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add query parameters for GET request (username, password, lotDiamondInfo)
        request.queryParam("username", "dhaval.sharma");
        request.queryParam("password", "samyak@2024");
        
        // Add Authorization header for Bearer Token Authentication
        String token = Config.token;  // Get token from the Config class     
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the PUT request
   
        String jsonBody = "{\n" +
        	    "  \"desc\": \"string\",\n" +
        	    "  \"code\": \"string\",\n" +
        	    "  \"srNo\": 0,\n" +
        	    "  \"labId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
        	    "  \"name\": \"string\",\n" +
        	    "  \"count\": 0,\n" +
        	    "  \"createdDate\": \"2024-12-13T09:21:05.197Z\"\n" +
        	    "}";

        
        // Add the JSON body to the request
        request.body(jsonBody);
        
     // String auctionId = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; 
 //  String userId = "7828500F-5781-40D5-9E61-ADF2A09EB993";
      String labId = "cb1674c7-b131-11ef-a57f-c8d3ffbc6ac6"; 
      
      
          // request.pathParam("userId", userId);
         // request.pathParam("auctionId", auctionId);
          request.pathParam("labId", labId);
        
        // Send the PUT request
        Response response = request.put("/lab/{labId}");
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());
        
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        
        // Check if the status code is 200 (OK)
        if (statusCode == 200) {
            System.out.println("Request succeeded: User updated successfully.");
        } else if (statusCode == 400) {
            System.out.println("Bad Request: Invalid input.");
        } else if (statusCode == 403) {
            System.out.println("Forbidden: Access is denied.");
        } else if (statusCode == 404) {
            System.out.println("Not Found: The resource could not be found.");
        } else if (statusCode == 500) {
            System.out.println("Internal Server Error: The server encountered an unexpected condition.");
        }

        // Assert that the status code is 200 (OK)
        Assert.assertTrue(statusCode == 200, "Expected 200 OK, but got: " + statusCode);
    }
}
