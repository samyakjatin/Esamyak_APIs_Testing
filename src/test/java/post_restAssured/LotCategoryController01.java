package post_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LotCategoryController01 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add Authorization header for Bearer Token Authentication
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJkNmZjNGJjMS0zYjNiLTQ1MzEtODRiNy1kZDlhYzkyNDkyMmUiLCJmaXJzdE5hbWUiOiJESEFWQUwiLCJyb2xlcyI6WyJBdWN0aW9uZWVyIl0sImFjdGl2ZSI6ZmFsc2UsImxhc3ROYW1lIjoiU2hhcm1hIiwic3ViIjoiZGhhdmFsLnNoYXJtYSIsImlhdCI6MTczMzk3Nzg0MCwiZXhwIjoxNzM0MDA3ODQwfQ.a_6mbXlY2BeaVZed_Q5Xi5l9t9K87BkfPkNdlbCoPwA";  // Make sure to use the actual token
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the POST request
        String jsonBody = "{\n" +
                          "  \"name\": \"string\",\n" +
                          "  \"desc\": \"string\",\n" +
                          "  \"code\": \"string\",\n" +
                          "  \"srNo\": 0\n" +
                          "}";
        
        // Add the JSON body to the request
        request.body(jsonBody);
        
        // Send the POST request
        Response response = request.post("/lot-category");
        
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
