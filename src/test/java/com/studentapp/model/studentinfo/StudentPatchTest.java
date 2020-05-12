package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Chaitanya
 */
public class StudentPatchTest extends TestBase {
    String email = "Amit" + getRandomString(4) +"@gmail.com";

    @Test
    public void updateStudentEmailOnly(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail(email);

        Response response =  given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .patch("/102");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
