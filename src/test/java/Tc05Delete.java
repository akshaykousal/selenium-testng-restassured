package test.java;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Tc05Delete extends BaseTest {

    @Test
    public void verifyDelete() {

        String empId = "1";// Hardcoded value.

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.DELETE, "/delete/" + empId);

        System.out.println("Response Body : \n" + response.getBody().asString());
        System.out.println("Response Status : \n" + response.getStatusCode());
        System.out.println("Response StatusLine : \n" + response.getStatusLine());

        //Get all headers
        Headers resHeaders = response.headers();
        for (Header header : resHeaders) {
            System.out.println("Header-Name = " + header.getName() + " --> Header-Value = " + header.getValue());
        }

    }
}
