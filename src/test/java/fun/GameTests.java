package fun;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void testGetGame() {
        given()
            .param("name", "John")
        .when()
            .get("http://localhost:8080/game")
        .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("game-schema.json"));
    }
}
