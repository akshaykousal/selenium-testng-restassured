package test.java;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Tc02GetSingle extends BaseTest {

    @Test
    public void verifyGetSingle() {

        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/v1/Activities/1");

        System.out.println("Response Body : \n" + response.getBody().asString());
        System.out.println("Response Status : \n" + response.getStatusCode());
        System.out.println("Response StatusLine : \n" + response.getStatusLine());

        //Get all headers
        Headers resHeaders = response.headers();
        for (Header header : resHeaders) {
            System.out.println("Header-Name = " + header.getName() + " --> Header-Value = " + header.getValue());
        }

        //Get values from all json key objects
        JsonPath jpath = response.jsonPath();
        System.out.println("ID = " + jpath.get("id"));
        System.out.println("Title = " + jpath.get("title"));
        System.out.println("DueDate = " + jpath.get("dueDate"));
        System.out.println("Completed = " + jpath.get("completed"));
    }
}