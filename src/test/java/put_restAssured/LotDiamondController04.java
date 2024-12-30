package put_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LotDiamondController04 {

    @Test
    public void loginToSystem() {
        
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
        
        String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3"; 
       // String supplierId= "C2BEE3F2-5B36-4D81-AD16-F184574241F1";
        String lotId = "ece5d964-d27b-434c-839e-3437977b0b0c"; 
      //  boolean active = true; // Set the active field value here
        
        // Add path parameters dynamically
       request.pathParam("auctionId", auctionId);
        // request.pathParam("supplierId", supplierId);
        request.pathParam("lotId", lotId);
       // request.pathParam("active", active);
        
       
        
        // Send the PUT request with query parameters
        Response response = request.put("/lot-diamond/{lotId}/{auctionId}"); 
        
        if (response.getStatusCode() == 401) {
            System.out.println("Token expired. Please generate a new token.");
            Assert.fail("Request failed due to token expiration.");
        } 
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());
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
