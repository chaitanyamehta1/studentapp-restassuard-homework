package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by Chaitanya
 */
public class StudentPutTest extends TestBase {
    String email = "Chaitanya"+ getRandomString(4)+"@gmail.com";
    @Test
    public void updateStudentById(){


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Chaitanya");
        studentPojo.setLastName("Mehta");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

        given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .put("/63")
                .then();
                 get("/list")
                        .then()
                        .body("[62].id",equalTo(63))
                         .body("[62].firstName",equalTo("Chaitanya"))
                         .body("[62].lastName",equalTo("Mehta"));



    }
}
