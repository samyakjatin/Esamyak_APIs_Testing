package post_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LotDiamondController10 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add Authorization header for Bearer Token Authentication
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJsYXN0TmFtZSI6IkRvZSIsInVzZXJJZCI6IjM0NTAwNjAyLTcyNmQtNGViNC05MWI2LTZhZjIxZDllOGRhMiIsImZpcnN0TmFtZSI6IndhZ2giLCJyb2xlcyI6WyJCaWRkZXIiXSwiYWN0aXZlIjpmYWxzZSwic3ViIjoicHJhc2hhbnQiLCJpYXQiOjE3MzM4MDk4MDEsImV4cCI6MTczMzgzOTgwMX0.h_CZ5cRNOBr9_0-REeyW1TP2Vw7GN6dpskfRthP_hv8";  // Make sure to use the actual token
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Define the JSON body
        String jsonBody = "{\n" +
                "  \"diamondName\": \"string\",\n" +
                "  \"stockNumber\": 0,\n" +
                "  \"status\": \"string\",\n" +
                "  \"fancyColor\": \"string\",\n" +
                "  \"weight\": 0,\n" +
                "  \"certNo\": \"string\",\n" +
                "  \"flourColor\": \"string\",\n" +
                "  \"measurement\": \"string\",\n" +
                "  \"length\": 0,\n" +
                "  \"width\": 0,\n" +
                "  \"height\": 0,\n" +
                "  \"rap\": 0,\n" +
                "  \"ppc\": 0,\n" +
                "  \"gettPrice\": 0,\n" +
                "  \"startPrice\": 0,\n" +
                "  \"reservePrice\": 0,\n" +
                "  \"remarks\": \"string\",\n" +
                "  \"origin\": \"string\",\n" +
                "  \"shape\": \"string\",\n" +
                "  \"color\": \"string\",\n" +
                "  \"clarity\": \"string\",\n" +
                "  \"lab\": \"string\",\n" +
                "  \"cut\": \"string\",\n" +
                "  \"polish\": \"string\",\n" +
                "  \"sym\": \"string\",\n" +
                "  \"flour\": \"string\",\n" +
                "  \"diamondId\": \"string\",\n" +
                "  \"shapeList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"colorList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"clarityList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"labList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"cutList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"polishList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"symList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"flourList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"lotIdList\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"user\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                "  \"from\": 0,\n" +
                "  \"to\": 0,\n" +
                "  \"fromRap\": 0,\n" +
                "  \"toRap\": 0,\n" +
                "  \"lotId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                "  \"endTime\": \"string\",\n" +
                "  \"serialNo\": 0,\n" +
                "  \"videoLink\": \"string\",\n" +
                "  \"currentBidAmt\": 0,\n" +
                "  \"minimumBid\": 0,\n" +
                "  \"auctionName\": \"string\",\n" +
                "  \"boxName\": \"string\",\n" +
                "  \"supplierId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                "  \"userName\": \"string\",\n" +
                "  \"imageLink\": \"string\",\n" +
                "  \"sold\": true,\n" +
                "  \"active\": true,\n" +
                "  \"fromStart\": 0,\n" +
                "  \"toStart\": 0,\n" +
                "  \"fromCurrent\": 0,\n" +
                "  \"toCurrent\": 0,\n" +
                "  \"negotiationEndTime\": \"string\",\n" +
                "  \"supplierName\": \"string\",\n" +
                "  \"auctionMode\": \"string\",\n" +
                "  \"isCorrection\": true,\n" +
                "  \"stockNumberCorrection\": \"string\",\n" +
                "  \"measurementCorrection\": \"string\",\n" +
                "  \"remarkCorrection\": \"string\",\n" +
                "  \"shapeCorrection\": \"string\",\n" +
                "  \"colorCorrection\": \"string\",\n" +
                "  \"flourCorrection\": \"string\",\n" +
                "  \"clarityCorrection\": \"string\",\n" +
                "  \"weightCorrection\": \"string\",\n" +
                "  \"labCorrection\": \"string\",\n" +
                "  \"cutCorrection\": \"string\",\n" +
                "  \"polishCorrection\": \"string\",\n" +
                "  \"symCorrection\": \"string\",\n" +
                "  \"rapCorrection\": \"string\",\n" +
                "  \"minimumBidCorrection\": \"string\",\n" +
                "  \"startPriceCorrection\": \"string\",\n" +
                "  \"reservePriceCorrection\": \"string\",\n" +
                "  \"videoLinkCorrection\": \"string\",\n" +
                "  \"endDateTimeCorrection\": \"string\",\n" +
                "  \"negotiationEndTimeCorrection\": \"string\",\n" +
                "  \"certNumber\": \"string\"\n" +
                "}";
        
        // Add the JSON body to the request
        request.body(jsonBody);
        
        // Define the auctionId path parameter
        String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3"; 
        
        // Add path parameters
        request.pathParam("auctionId", auctionId);
        
        // Send the POST request
        Response response = request.post("/lot-diamond/{auctionId}");
        
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
