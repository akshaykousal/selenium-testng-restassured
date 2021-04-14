package test.java;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Tc03Post extends BaseTest {

    @Test
    public void verifyPost() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject map = new JSONObject();
        map.put("name","ABC PQR XYZ");
        map.put("salary","2000000");
        map.put("age","33");

        httpRequest.header("content-type","application/json");
        httpRequest.body(map.toJSONString());

        Response response = httpRequest.request(Method.POST,"/create");

        System.out.println("Response Body : \n" + response.getBody().asString());
        System.out.println("Response Status : \n" + response.getStatusCode());
        System.out.println("Response StatusLine : \n" + response.getStatusLine());

        //Get all headers
        Headers resHeaders = response.headers();
        for(Header header: resHeaders){
            System.out.println("Header-Name = " + header.getName() + " --> Header-Value = " + header.getValue());
        }

        //Get status from body
        JsonPath jpath = response.jsonPath();
        System.out.println(jpath.get("status").toString());

        //Get value of ID generated
        System.out.println("ID = " + jpath.get("data.id"));
    }
}
