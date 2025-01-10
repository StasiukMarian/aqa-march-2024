package api.lesson9;

import base.pojos.createUser.CreateUserRequest;
import base.pojos.createUser.CreateUserResponse;
import base.pojos.getPets.Pet;
import base.pojos.getUserData.UserData;
import base.pojos.updateUser.UpdateUserResponse;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static base.custom.Constants.BASE_URL;
import static base.custom.Specifications.*;
import static io.restassured.RestAssured.given;

public class PojoTest {
    //    @Test
    public void getUserData() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList("data", UserData.class);

        Assert.assertNotNull(users);

        for (int i = 0; i < users.size(); i++) {
            Assert.assertTrue(users.get(i).getEmail().contains("@reqres.in"));
            Assert.assertTrue(users.get(i).getAvatar().contains(users.get(i).getId().toString()));
        }
    }

    //    @Test
    public void createUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(201));

        CreateUserRequest userRequest = new CreateUserRequest();

        userRequest.setName("Marian");
        userRequest.setJob("aqa");

        CreateUserResponse createUserResponse = given()
                .body(userRequest)
                .when()
                .post("api/users")
                .then()
                .log().body().extract().as(CreateUserResponse.class);

        Assert.assertNotNull(createUserResponse);

        Assert.assertEquals(userRequest.getName(), createUserResponse.getName());
        Assert.assertEquals(userRequest.getJob(), createUserResponse.getJob());
    }

    //    @Test
    public void updateUser() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        CreateUserRequest requestUpdate = new CreateUserRequest("Marian", "aqa");

        UpdateUserResponse updateUserResponse = given()
                .body(requestUpdate)
                .when()
                .put("api/users/2")
                .then()
                .extract().as(UpdateUserResponse.class);

        Assert.assertEquals(requestUpdate.getName(), updateUserResponse.getName());
        Assert.assertEquals(requestUpdate.getJob(), updateUserResponse.getJob());
    }

    @Test
    public void availablePetsTest() {
        Pet[] pet = given()
                .accept(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract().as(Pet[].class);

        List<Pet> petsList = Arrays.asList(pet);

        for (Pet pet1 : petsList) {
            Assert.assertEquals(pet1.getStatus(), "available");
        }
    }
}
