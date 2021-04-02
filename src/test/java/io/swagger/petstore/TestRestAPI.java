package io.swagger.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRestAPI {
    @Test
    @Order(1)
    public void createPet(){
        given()
                .contentType("application/json").body("{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"happyDog\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}'")
        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .statusCode(200);
    }
    @Test
    @Order(2)
    public void putPet(){
        given()
                .contentType("application/json").body("{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"Brulick\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}'")
        .when()
                .put("https://petstore.swagger.io/v2/pet")
        .then()
                .statusCode(200);
    }
    @Test
    @Order(3)
    public void getPet(){
        String rs =
                given()
                        .baseUri("https://petstore.swagger.io/v2")
                        .basePath("/pet/1")
                        .contentType(ContentType.JSON)
                .when()
                        .get()
                .then()
                        .statusCode(200)
                        .extract().asString();
        System.out.println(rs);
    }
    @Test
    @Order(4)
    public void deletePet(){
        when()
                .delete("https://petstore.swagger.io/v2/pet/1")
        .then()
                .statusCode(200);
    }
}
