package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Chaitanya
 */

public class StudentDeleteTest extends TestBase {
    @Test
    public void deleteStudentById(){
      given()
                   .when()
                .delete("/111")
                 .then();
      get("/list")
              .then()
              .body("[110].id",equalTo(111));




    }
}
