package get_restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LotController09 {

    @Test
    public void loginToSystem() throws IOException {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add query parameters for GET request (username, password)
        request.queryParam("username", "dhaval.sharma");
        request.queryParam("password", "samyak@2024");
        
        // Add Authorization header for Bearer Token Authentication
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJmaXJzdE5hbWUiOiJ3YWdoIiwidXNlcklkIjoiMzQ1MDA2MDItNzI2ZC00ZWI0LTkxYjYtNmFmMjFkOWU4ZGEyIiwibGFzdE5hbWUiOiJEb2UiLCJhY3RpdmUiOmZhbHNlLCJyb2xlcyI6WyJCaWRkZXIiXSwic3ViIjoicHJhc2hhbnQiLCJpYXQiOjE3MzM4MDY3NDMsImV4cCI6MTczMzgzNjc0M30.-jqeg59WPNlNTBqj8kOXYLLjjPaJkm_OW9m5ZmvTyJU";
        request.header("Authorization", "Bearer " + token);
        
        // Optional: Set headers if required
        request.header("Content-Type", "application/json");
        
        // Define path parameters
        String auctionId = "ACFFE150-2857-4A32-A25C-B262BBDB9DA3";
        request.pathParam("auctionId", auctionId);
        
        // Send the GET request with path and query parameters
        Response response = request.get("/download-lot-excel/{auctionId}");
        
        // Print the status line for debugging
        System.out.println("The status received: " + response.statusLine());
        
        // Save the binary response to the specified path
        if (response.getStatusCode() == 200) {
            byte[] fileData = response.asByteArray();  // Get the response as a byte array
            
            // Define the file path
            String filePath = "C:\\Auction_workspace\\output_lot_excel.xlsx";
            
            // Ensure the directory exists
            File directory = new File("C:\\Auction_workspace");
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directory created: " + directory.getAbsolutePath());
                } else {
                    System.err.println("Failed to create directory: " + directory.getAbsolutePath());
                    return;
                }
            }
            
            // Write the file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(fileData);
                System.out.println("File successfully saved to: " + filePath);
            } catch (IOException e) {
                System.err.println("Error saving the file: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to download the file. HTTP Status Code: " + response.getStatusCode());
        }

        // Assert that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK, but got: " + response.getStatusCode());
    }
}