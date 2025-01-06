package api.lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredTest {

    public static final String BASE_URL = "https://reqres.in/api/";
//    @Test
    public void getTest() {
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//
//        int statusCode = response.statusCode();
//
//        Assert.assertEquals(statusCode, 200);

//        given()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200).log().body()
//                .body("data.id[1]", equalTo(8));
//
//        given().get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200)
//                .body("total", equalTo(12));

        Response response = given()
                .accept(ContentType.JSON)
                .get(BASE_URL + "users?page=2")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("data.id[1]"), 8);
    }
//    @Test
    public void postTest(){

        JSONObject postRequest = new JSONObject();

        postRequest.put("name", "Marian");
        postRequest.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(postRequest)
                .when()
                .post(BASE_URL + "users")
                .then()
                .statusCode(201).log().body();
    }

//    @Test
    public void putTest(){
        JSONObject putRequest = new JSONObject();

        putRequest.put("name", "Marian");
        putRequest.put("job", "teacher");

        given()
                .accept(ContentType.JSON)
                .body(putRequest)
                .when()
                .put(BASE_URL + "users/53")
                .then()
                .statusCode(200).log().body();
    }
    @Test
    public void deleteTest(){
        given()
                .delete(BASE_URL + "users/53")
                .then()
                .statusCode(204).log().all();
    }
}
