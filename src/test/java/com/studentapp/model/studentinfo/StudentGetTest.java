package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Chaitanya
 */
public class StudentGetTest extends TestBase {
    @Test
    public void getAllStudentDetails(){
       Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void searchStudentById(){
        Response response = given()
                .when()
                .get("85");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test

    public void searchStudentByProgramme(){
        Response response = given()
                .param("programme","Financial Analysis")
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void searchStudentByProgrammeAndLimit(){
      Response response = given()
      .param("programme","Financial Analysis")
      .param("limit", 4)
              .when()
              .get("/list");
      response.then().statusCode(200);
      response.prettyPrint();

    }
}
