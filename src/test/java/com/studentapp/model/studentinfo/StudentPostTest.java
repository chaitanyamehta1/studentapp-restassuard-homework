package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Chaitanya
 */
public class StudentPostTest extends TestBase {
    String email = "Chaitanya"+ getRandomString(4)+"@gmail.com";
    String fname = "Chaitanya"+ getRandomString(2);
    String lname = "Mehta"+ getRandomString(2);
    @Test
            public void createNewStudent(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(fname);
        studentPojo.setLastName(lname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void createNewStudentWithEmptyFirstName(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(" ");
        studentPojo.setLastName(lname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
    public void createStudentWithEmptyLastName(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(fname );
        studentPojo.setLastName(" ");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();




    }
@Test
    public void createStudentWithDuplicateEmail(){

    StudentPojo studentPojo = new StudentPojo();
    studentPojo.setFirstName(fname);
    studentPojo.setLastName(lname);
    studentPojo.setEmail("egestas.rhoncus.Proin@massaQuisqueporttitor.org");
    studentPojo.setProgramme("Automation Testing");
    List<String> course = new ArrayList<>();

    course.add("Selenium");
    course.add("Java");
    course.add("Api Testing");
    studentPojo.setCourses(course);

    Response response = given()
            .header("Content-Type","application/json")
            .when()
            .body(studentPojo)
            .post();
    response.then().statusCode(500);
    response.prettyPrint();

}
    @Test
    public void createNewStudentWithNullFirstName(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(fname = null );
        studentPojo.setLastName(lname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500);
        response.prettyPrint();


    }


    }
