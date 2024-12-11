package post_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LotJewelleryController09 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add Authorization header for Bearer Token Authentication
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJsYXN0TmFtZSI6IkRvZSIsInVzZXJJZCI6IjM0NTAwNjAyLTcyNmQtNGViNC05MWI2LTZhZjIxZDllOGRhMiIsImZpcnN0TmFtZSI6IndhZ2giLCJyb2xlcyI6WyJCaWRkZXIiXSwiYWN0aXZlIjpmYWxzZSwic3ViIjoicHJhc2hhbnQiLCJpYXQiOjE3MzM4MTA4MTksImV4cCI6MTczMzg0MDgxOX0.IlMsFYTgfx1Mfx6caqEPE4C2CJVhHIzAo_He_-055MQ";  // Make sure to use the actual token
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the POST request
        String jsonBody = "{\n" +
                          "  \"stockNumber\": 0,\n" +
                          "  \"status\": \"string\",\n" +
                          "  \"jewelleryType\": \"string\",\n" +
                          "  \"brand\": \"string\",\n" +
                          "  \"grossWeight\": 0,\n" +
                          "  \"startPrice\": 0,\n" +
                          "  \"certificate\": \"string\",\n" +
                          "  \"jewelleryMaterial\": \"string\",\n" +
                          "  \"lab\": \"string\",\n" +
                          "  \"gemStone\": \"string\",\n" +
                          "  \"materialType\": \"string\",\n" +
                          "  \"stoneType\": \"string\",\n" +
                          "  \"sideStone\": \"string\",\n" +
                          "  \"stoneWeight\": 0,\n" +
                          "  \"sideStoneWeight\": 0,\n" +
                          "  \"size\": \"string\",\n" +
                          "  \"details\": \"string\",\n" +
                          "  \"origin\": \"string\",\n" +
                          "  \"price\": 0,\n" +
                          "  \"reservePrice\": 0,\n" +
                          "  \"remarks\": \"string\",\n" +
                          "  \"lotId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                          "  \"endTime\": \"string\",\n" +
                          "  \"serialNo\": 0,\n" +
                          "  \"videoLink\": \"string\",\n" +
                          "  \"currentBidAmt\": 0,\n" +
                          "  \"minimumBid\": 0,\n" +
                          "  \"jewelleryId\": \"string\",\n" +
                          "  \"auctionName\": \"string\",\n" +
                          "  \"userId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                          "  \"labList\": [\n" +
                          "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                          "  ],\n" +
                          "  \"gemStoneList\": [\n" +
                          "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                          "  ],\n" +
                          "  \"jewelleryTypeList\": [\n" +
                          "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                          "  ],\n" +
                          "  \"jewelleryMaterialList\": [\n" +
                          "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                          "  ],\n" +
                          "  \"brandList\": [\n" +
                          "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                          "  ],\n" +
                          "  \"lotIdList\": [\n" +
                          "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                          "  ],\n" +
                          "  \"boxName\": \"string\",\n" +
                          "  \"supplierId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                          "  \"userName\": \"string\",\n" +
                          "  \"imageLink\": \"string\",\n" +
                          "  \"active\": true,\n" +
                          "  \"sold\": true\n" +
                          "}";

        // Add the JSON body to the request
        request.body(jsonBody);
        
        String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3"; 
        
        request.pathParam("auctionId", auctionId);
          
        
        // Send the POST request
        Response response = request.post("/lot-jewellery/search/{auctionId}");
        
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
