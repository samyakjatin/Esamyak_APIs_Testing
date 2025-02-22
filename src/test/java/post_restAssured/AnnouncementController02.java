package post_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AnnouncementController02 {

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
        String jsonBody = "[{\n" +
                          "  \"category\": \"string\",\n" +
                          "  \"date\": \"string\",\n" +
                          "  \"title\": \"string\",\n" +
                          "  \"message\": \"string\",\n" +
                          "  \"module\": \"string\",\n" +
                          "  \"notice\": \"string\",\n" +
                          "  \"lotId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                          "  \"lotNo\": \"string\"\n" +
                          "}]";

        // Add the JSON body to the request
        request.body(jsonBody);
        
        String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3"; 
        
        request.pathParam("auctionId", auctionId);
          
        // Send the POST request
        Response response = request.post("/bidding-announcements-all/{auctionId}");
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());
        
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        
        // Check if the status code is 200 (OK) or 201 (Created)
        switch (statusCode) {
            case 200:
                System.out.println("Request succeeded: Data inserted successfully.");
                break;
            case 201:
                System.out.println("Request succeeded: Symmetry created.");
                break;
            case 400:
                System.out.println("Bad Request: Invalid input.");
                break;
            case 403:
                System.out.println("Forbidden: Access is denied.");
                break;
            case 500:
                System.out.println("Internal Server Error: The server encountered an unexpected condition.");
                break;
            default:
                System.out.println("Unexpected status code: " + statusCode);
        }

        // Assert that the status code is 200 (OK) or 201 (Created)
        Assert.assertTrue(statusCode == 200 || statusCode == 201, "Expected 200 OK or 201 Created, but got: " + statusCode);
    }
}
