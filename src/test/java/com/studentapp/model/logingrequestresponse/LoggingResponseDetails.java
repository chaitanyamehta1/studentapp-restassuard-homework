package com.studentapp.model.logingrequestresponse;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Chaitanya
 */
public class LoggingResponseDetails {


    /**
     * This test will print out all the Response Headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");
        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().headers();

    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");
        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().status();
    }


    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");
        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().body();

    }


}
