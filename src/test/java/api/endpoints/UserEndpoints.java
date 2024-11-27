package api.endpoints;

import api.payload.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	// create user
	public static Response createUser(UserPayload payload) {

		Response response=RestAssured.given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(Routes.postURL);	

		return response;
	}

	//get user

	public static Response getUser(String username) {

		Response response=RestAssured.given()
				.accept(ContentType.JSON)
				.pathParam("username", username)

				.when()
				.get(Routes.getURL);	

		return response;
	}

	//update user

	public static Response updateUser(String username, UserPayload payload) {

		Response response=RestAssured.given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)

				.when()
				.put(Routes.putURL);	

		return response;
	}

	//delete user

	public static Response deleteUser(String username, UserPayload payload) {

		Response response=RestAssured.given()
				.accept(ContentType.JSON)
				.pathParam("username", username)

				.when()
				.delete(Routes.deleteURL);	

		return response;
	}
}
