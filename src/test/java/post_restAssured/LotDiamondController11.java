package post_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class LotDiamondController11 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        request.queryParam("username", "dhaval.sharma");
        request.queryParam("password", "samyak@2024");
        
        // Add Authorization header for Bearer Token Authentication
        String token = Config.token;  // Get token from the Config class     
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        
        
        // Set the Content-Type header to multipart/form-data
        request.header("Content-Type", "multipart/form-data");  
        
        // Create the multipart body for the POST request
      File file = new File("C:\\Users\\SAMYAK111\\Desktop\\Test\\LotDiamondController11.xlsx");
        
        // Add the file to the request
       request.multiPart("file", file);
       
      
        
        // Define the auctionId path parameter
        String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3";
        String userId = "7828500F-5781-40D5-9E61-ADF2A09EB993"; 

        
        // Add path parameters
        request.pathParam("userId", userId)
        .pathParam("auctionId", auctionId);
        
        // Send the POST request
        Response response = request.post("/lot-diamond/uploadLotDiamond/{userId}/{auctionId}");
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());  // Added response logging
        System.out.println("---------------Response Details---------------");
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        
        // Check if the status code is 200 (OK) or 201 (Created)
        if (statusCode == 200) {
            System.out.println("Request succeeded: File uploaded successfully.");
        } else if (statusCode == 201) {
            System.out.println("Request succeeded: Symmetry created.");
        } else if (statusCode == 400) {
            System.out.println("Bad Request: Invalid input.");
        }

        // Assert that the status code is 200 (OK) or 201 (Created)
        Assert.assertTrue(statusCode == 200 || statusCode == 201, "Expected 200 OK or 201 Created, but got: " + statusCode);
    }
}
