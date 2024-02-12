// Created to perform CRUD operation to the user APIs.

package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.post_url);

		return response;

	}

	public static Response readUser(String userName) {

		Response response = given().pathParam("username", userName)

				.when().get(Routes.get_url);

		return response;

	}

	public static Response updateUser(String userName, User payload) {

		Response response = given()
							
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.pathParam("username", userName)
							.body(payload)
							

							.when().put(Routes.update_url);

		return response;

	}

	public static Response deleteUser(String userName) {

		Response response = given().pathParam("username", userName)

				.when().get(Routes.delete_url);

		return response;

	}

}
