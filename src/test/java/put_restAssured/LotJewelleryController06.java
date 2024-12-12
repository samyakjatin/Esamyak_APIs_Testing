package put_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LotJewelleryController06 {

    @Test
    public void updateUser() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add query parameters for GET request (username, password, lotDiamondInfo)
        request.queryParam("username", "dhaval.sharma");
        request.queryParam("password", "samyak@2024");
        
        // Add Authorization header for Bearer Token Authentication
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJmaXJzdE5hbWUiOiJ3YWdoIiwidXNlcklkIjoiMzQ1MDA2MDItNzI2ZC00ZWI0LTkxYjYtNmFmMjFkOWU4ZGEyIiwibGFzdE5hbWUiOiJEb2UiLCJhY3RpdmUiOnRydWUsInJvbGVzIjpbIkJpZGRlciJdLCJzdWIiOiJwcmFzaGFudCIsImlhdCI6MTczMzk4NzUzNywiZXhwIjoxNzM0MDE3NTM3fQ.txT7xF74nBBpxBH1uScLZ47W3nXmyDrjHppbmuQg_mk";  // Make sure to use the actual token
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the PUT request
        String jsonBody = "[\n" +
        	    "  {\n" +
        	    "    \"stockNumber\": 0,\n" +
        	    "    \"status\": \"string\",\n" +
        	    "    \"jewelleryType\": \"string\",\n" +
        	    "    \"brand\": \"string\",\n" +
        	    "    \"grossWeight\": 0,\n" +
        	    "    \"startPrice\": 0,\n" +
        	    "    \"certificate\": \"string\",\n" +
        	    "    \"jewelleryMaterial\": \"string\",\n" +
        	    "    \"lab\": \"string\",\n" +
        	    "    \"gemStone\": \"string\",\n" +
        	    "    \"materialType\": \"string\",\n" +
        	    "    \"stoneType\": \"string\",\n" +
        	    "    \"sideStone\": \"string\",\n" +
        	    "    \"stoneWeight\": 0,\n" +
        	    "    \"sideStoneWeight\": 0,\n" +
        	    "    \"size\": \"string\",\n" +
        	    "    \"details\": \"string\",\n" +
        	    "    \"origin\": \"string\",\n" +
        	    "    \"price\": 0,\n" +
        	    "    \"reservePrice\": 0,\n" +
        	    "    \"remarks\": \"string\",\n" +
        	    "    \"lotId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
        	    "    \"endTime\": \"string\",\n" +
        	    "    \"serialNo\": 0,\n" +
        	    "    \"videoLink\": \"string\",\n" +
        	    "    \"currentBidAmt\": 0,\n" +
        	    "    \"minimumBid\": 0,\n" +
        	    "    \"jewelleryId\": \"string\",\n" +
        	    "    \"auctionName\": \"string\",\n" +
        	    "    \"userId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
        	    "    \"labList\": [\n" +
        	    "      \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
        	    "    ],\n" +
        	    "    \"gemStoneList\": [\n" +
        	    "      \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
        	    "    ],\n" +
        	    "    \"jewelleryTypeList\": [\n" +
        	    "      \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
        	    "    ],\n" +
        	    "    \"jewelleryMaterialList\": [\n" +
        	    "      \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
        	    "    ],\n" +
        	    "    \"brandList\": [\n" +
        	    "      \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
        	    "    ],\n" +
        	    "    \"lotIdList\": [\n" +
        	    "      \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
        	    "    ],\n" +
        	    "    \"boxName\": \"string\",\n" +
        	    "    \"supplierId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
        	    "    \"userName\": \"string\",\n" +
        	    "    \"imageLink\": \"string\",\n" +
        	    "    \"active\": true,\n" +
        	    "    \"sold\": true\n" +
        	    "  }\n" +
        	    "]";


        // Add the JSON body to the request
        request.body(jsonBody);
        
      String auctionId = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; 
 //  String userId = "7828500F-5781-40D5-9E61-ADF2A09EB993";
      
      
           request//.pathParam("userId", userId)
         .pathParam("auctionId", auctionId);
        
        // Send the PUT request
        Response response = request.put("/jewellery/srNoUpdate/{auctionId}");
        
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
