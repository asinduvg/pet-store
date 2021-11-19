package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class PetResourceTest {

    @Test
    public void testPetEndpoint() {
        given()
                .when().get("/v1/pets")
                .then()
                .statusCode(200);
//             .body(hasItem(
// 		            allOf(
//    		                hasEntry("pet_id", "1"),
//    		                hasEntry("pet_type", "Dog"),
//    		                hasEntry("pet_name", "Boola"),
//    		                hasEntry("pet_age", "3")
//    		            )
//    		      )
//    		 );
    }

    @Test
    public void testAddPet() {
        given()
                .header("Content-Type", "application/json")
                .body("{\r\n    \"petName\":\"Bijitha\",\r\n   \"petAge\":4,\r\n   \"petType\":\"Bird\"\r\n}")
                .when().post("v1/pets")
                .then()
                .assertThat()
                .statusCode(201)
                .body("petId", equalTo(5))
                .body("petAge", equalTo(4))
                .body("petName", equalTo("Bijitha"))
                .body("petType", equalTo("Bird"));
    }

    @Test
    public void testUpdatePet(){
        given()
                .header("Content-Type","application/json")
                .pathParam("petId",1)
                .body("{\n\"name\":\"Poppy\"\n}")
                .when().put("v1/pets/{petId}")
                .then()
                .statusCode(201)
                .body("petId",equalTo(1))
                .body("petAge",notNullValue())
                .body("petName",equalTo("Poppy"))
                .body("petType",notNullValue());
    }

    @Test
    public void testDeletePet(){
        given()
                .header("Content-Type","application/json")
                .pathParam("petId",1)
                .when().delete("v1/pets/{petId}")
                .then()
                .statusCode(204)
                .body("successful",equalTo(true));
    }


}