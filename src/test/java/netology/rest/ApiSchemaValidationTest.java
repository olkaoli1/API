package netology.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiSchemaValidationTest {

    @Test
    public void shouldValidateResponseAgainstSchema() {
        RestAssured.baseURI = "http://localhost:9999/api/v1";

        given()
                .when()
                .get("/demo/accounts") // Исправлено на корректный путь
                .then()
                .statusCode(200) // Проверка, что статус ответа 200
                .body(matchesJsonSchemaInClasspath("accounts.schema.json")); // Проверка по JSON-схеме
    }
}