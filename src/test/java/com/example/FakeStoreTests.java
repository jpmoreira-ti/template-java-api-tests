package com.example;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FakeStoreTests {

    @Test
    public void testGetAllProducts() {
        RestAssured.baseURI = "https://fakestoreapi.com";

        given()
            .when()
            .get("/products")
            .then()
            .statusCode(200)
            .body("$", everyItem(hasKey("id")))
            .body("$", everyItem(hasKey("title")))
            .body("$", everyItem(hasKey("price")))
            .body("$", everyItem(hasKey("description")))
            .body("$", everyItem(hasKey("category")))
            .body("$", everyItem(hasKey("image")))
            .body("$", everyItem(hasKey("rating")));
    }

    @Test
    public void testGetProductById() {
        RestAssured.baseURI = "https://fakestoreapi.com";

        given()
            .when()
            .get("/products/1")
            .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"))
            .body("price", equalTo(109.95f))
            .body("description", equalTo("Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday"))
            .body("category", equalTo("men's clothing"))
            .body("image", equalTo("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"))
            .body("rating.rate", equalTo(3.9f))
            .body("rating.count", equalTo(120));
    }

    @Test
    public void testAddProduct() throws IOException {
        RestAssured.baseURI = "https://fakestoreapi.com";

        Path resourceDirectory = Paths.get("src", "test", "resources", "payloads", "newProduct.json");
        String newProductPayload = new String(Files.readAllBytes(resourceDirectory));

        given()
            .header("Content-Type", "application/json")
            .body(newProductPayload)
            .when()
            .post("/products")
            .then()
            .statusCode(200)
            .body("id", notNullValue())
            .body("title", equalTo("new product"))
            .body("price", equalTo(13.5f))
            .body("description", equalTo("lorem ipsum set"))
            .body("image", equalTo("https://i.pravatar.cc"))
            .body("category", equalTo("electronic"));
    }

    @Test
    public void testDeleteProductById() {
        RestAssured.baseURI = "https://fakestoreapi.com";

        given()
            .when()
            .delete("/products/21")
            .then()
            .statusCode(200)
            .body(equalTo("null"));
    }
}