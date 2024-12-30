package put_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PolishController01 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add Authorization header for Bearer Token Authentication
        String token = Config.token;  // Get token from the Config class     
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the POST request
        String jsonBody = "{\n" +
                "  \"desc\": \"string\",\n" +
                "  \"code\": \"string\",\n" +
                "  \"srNo\": 0,\n" +
                "  \"polishId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                "  \"name\": \"string\",\n" +
                "  \"count\": 0,\n" +
                "  \"createdDate\": \"string\"\n" +
                "}";


        // Add the JSON body to the request
        request.body(jsonBody);
        
       // String userId = "7828500F-5781-40D5-9E61-ADF2A09EB993";
       // String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3"; 
         String polishId = "cc4e6bcf-b131-11ef-a57f-c8d3ffbc6ac6";
        
        // Add path parameters dynamically
       // request.pathParam("userId", userId);
       // request.pathParam("auctionId", auctionId);
          request.pathParam("polishId", polishId);
        
        // Send the POST request
        Response response = request.put("/polish/{polishId}");
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());  // Added response logging
        System.out.println("---------------Response Details---------------");
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        
        // Check if the status code is 200 (OK) or 201 (Created)
        if (statusCode == 200) {
            System.out.println("Request succeeded: Data inserted successfully.");
        } else if (statusCode == 201) {
            System.out.println("Request succeeded: Symmetry created.");
        } else if (statusCode == 400) {
            System.out.println("Bad Request: Invalid input.");
        } else if (statusCode == 403) {
            System.out.println("Forbidden: Access is denied.");
        } else if (statusCode == 500) {
            System.out.println("Internal Server Error: The server encountered an unexpected condition.");
        }

        // Assert that the status code is 200 (OK) or 201 (Created)
        Assert.assertTrue(statusCode == 200 || statusCode == 201, "Expected 200 OK or 201 Created, but got: " + statusCode);
    }
}
