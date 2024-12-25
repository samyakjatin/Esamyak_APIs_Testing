package get_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BidController06{
 
    @Test
    public void loginToSystem() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add query parameters for GET request (username, password)
        request.queryParam("username", "dhaval.sharma");
        request.queryParam("password", "samyak@2024");
        
        // Add Authorization header for Bearer Token Authentication
        // Replace 'your_token_here' with the actual Bearer token you received
        String token = Config.token;  // Get token from the Config class     
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Optional: Set headers if required
        request.header("Content-Type", "application/json");
        
       String userId="7828500F-5781-40D5-9E61-ADF2A09EB993";
       String auctionId="d68848a2-67a3-453f-85af-2a0aaa14b9e2";
      // String countryId = "435a09ab-ad6e-11ef-8d40-c8d3ffbc6ac6"; 
    //  String supplierId = "88be816b-c3e9-432b-9111-45af8ba70bfb"; 
     // String boxNo = "BOX1"; 
       
         	
        // Add path parameters dynamically
        request.pathParam("userId", userId);
        request.pathParam("auctionId", auctionId);
        //request.pathParam("countryId", countryId);
      //request.pathParam("supplierId", supplierId);
      //request.pathParam("boxNo", boxNo);
      
        
        // Send the GET request with query parameters
        Response response = request.get("/bids/{userId}/{auctionId}"); 
        
        if (response.getStatusCode() == 401) {
			System.out.println("Token expired. Please generate a new token.");
			Assert.fail("Request failed due to token expiration.");
		}
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());  // Added response logging
        System.out.println("---------------Response Details---------------");
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        
        // Check if the status code is 200 (OK) or 403 (Forbidden)
        if (statusCode == 403) {
            System.out.println("Access denied: Invalid credentials or permissions.");
        } else if (statusCode == 200) {
            System.out.println("Request succeeded: Access granted.");
        }

        // Assert that the status code is 200 (OK), or change the expectation if 403 is valid
        Assert.assertEquals(statusCode, 200, "Expected 200 OK, but got: " + statusCode);
    }
}
