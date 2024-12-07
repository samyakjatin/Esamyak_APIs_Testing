package post_restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SymmetryController02 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add Authorization header for Bearer Token Authentication
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJCaWRkZXIiXSwiYWN0aXZlIjpmYWxzZSwibGFzdE5hbWUiOiJEb2UiLCJ1c2VySWQiOiIzNDUwMDYwMi03MjZkLTRlYjQtOTFiNi02YWYyMWQ5ZThkYTIiLCJmaXJzdE5hbWUiOiJ3YWdoIiwic3ViIjoicHJhc2hhbnQiLCJpYXQiOjE3MzM1NDYzNDQsImV4cCI6MTczMzU3NjM0NH0.xNFAH4C_aSJmbpgZD6a98Gyqr6jfYTZJ_x-LwbbRD7s";  // Make sure to use the actual token
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the POST request
        String jsonBody = "{\n" +
                          "  \"desc\": \"string\",\n" +
                          "  \"code\": \"string\",\n" +
                          "  \"srNo\": 0,\n" +
                          "  \"symmetryId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                          "  \"name\": \"string\",\n" +
                          "  \"count\": 0,\n" +
                          "  \"createdDate\": \"string\"\n" +
                          "}";
        
        // Add the JSON body to the request
        request.body(jsonBody);
        
        // Send the POST request
        Response response = request.post("/symmetry");
        
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
