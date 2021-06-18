package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import api.models.User;
import api.models.UserData;
import api.models.UserDetail;
import api.models.UserPage;
import api.models.UserSupport;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReqResTests {
	private static final String JSON = "application/json";
	String baseUrl = "https://reqres.in/api";

	@Test
	public void testResponse() {

		String endpoint = "http://dummy.restapiexample.com/api/v1/employees";

		int expectedCode = 200;
		int actualCode = get(endpoint).getStatusCode();

		Assert.assertEquals(actualCode, expectedCode);
	}

	@Test
	public void verifyEmailAddress() {

		String endpoint = getEndpoint("/users/2");
		String email = "janet.weaver@reqres.in";

		when()
		.get(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("data.email", equalTo(email));
	}

	@Test
	public void verifyPostTokenReturnValue() {
		String endpoint = getEndpoint("/login");
		String token = "QpwL5tke4Pnpja7X4";

		JsonObject loginCredentials = new JsonObject();
		loginCredentials.addProperty("email", "eve.holt@reqres.in");
		loginCredentials.addProperty("password", "cityslicka");

		given()
		.contentType(JSON)
		.body(loginCredentials.toString())
		.post(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("token", is(token));
	}

	@Test
	public void verifyDelete() {

		String endpoint = getEndpoint("/users/2");

		given()
		.delete(endpoint)
		.then()
		.assertThat()
		.statusCode(204);
	}

	@Test
	public void canPatch() {

		String endpoint = getEndpoint("/users/2");

		User user = new User();
		user.name = "morpheus2";
		user.job = "zion resident";

		given()
		.contentType(JSON)
		.body(user)
		.patch(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("name", is(user.name))
		.body("job", is(user.job));
	}

	@Test
	public void canPut() {

		String endpoint = getEndpoint("/users/2");

		User user = new User();
		user.name = "morpheus2";
		user.job = "zion resident";

		given()
		.contentType(JSON)
		.body(user)
		.patch(endpoint)
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("name", is(user.name))
		.body("job", is(user.job));
	}

	@Test
	public void canDeserializeUserDetails() {

		String endpoint = getEndpoint("/users/2");

		UserData expectedUserDataDetails = new UserData();
		expectedUserDataDetails.id = 2;
		expectedUserDataDetails.email = "janet.weaver@reqres.in";
		expectedUserDataDetails.first_name = "Janet";
		expectedUserDataDetails.last_name = "Weaver";
		expectedUserDataDetails.avatar = "https://reqres.in/img/faces/2-image.jpg";

		UserSupport expectedUserSupportDetails = new UserSupport();
		expectedUserSupportDetails.url = "https://reqres.in/#support-heading";
		expectedUserSupportDetails.text = "To keep ReqRes free, contributions towards server costs are appreciated!";

		UserDetail expectedUserDetails = new UserDetail();
		expectedUserDetails.data = expectedUserDataDetails;
		expectedUserDetails.support = expectedUserSupportDetails;

		UserDetail updatedUser = given()
				.get(endpoint)
				.getBody()
				.as(UserDetail.class);

		Assert.assertEquals(updatedUser.getData().id, expectedUserDetails.getData().id);
		Assert.assertEquals(updatedUser.getData().email, expectedUserDetails.getData().email);
		Assert.assertEquals(updatedUser.getData().first_name, expectedUserDetails.getData().first_name);
		Assert.assertEquals(updatedUser.getData().last_name, expectedUserDetails.getData().last_name);
		Assert.assertEquals(updatedUser.getData().avatar, expectedUserDetails.getData().avatar);

		Assert.assertEquals(updatedUser.getSupport().url, expectedUserDetails.getSupport().url);
		Assert.assertEquals(updatedUser.getSupport().text, expectedUserDetails.getSupport().text);
	}

	@Test
	public void canDeserializeUserDetailsList() {

		String endpoint = getEndpoint("/users?page=2");

		UserPage expectedPage = new UserPage();
		expectedPage.page = 2;
		expectedPage.per_page = 6;
		expectedPage.total = 12;
		expectedPage.total_pages = 2;

		expectedPage.data = new UserDetail[6];

		UserSupport expectedUserSupportDetails = new UserSupport();
		expectedUserSupportDetails.url = "https://reqres.in/#support-heading";
		expectedUserSupportDetails.text = "To keep ReqRes free, contributions towards server costs are appreciated!";

		expectedPage.support = expectedUserSupportDetails;

		UserPage userPage = given()
				.get(endpoint)
				.getBody()
				.as(UserPage.class);

		Assert.assertEquals(userPage.getPage(), expectedPage.getPage());
		Assert.assertEquals(userPage.getPer_page(), expectedPage.getPer_page());
		Assert.assertEquals(userPage.getTotal(), expectedPage.getTotal());
		Assert.assertEquals(userPage.getTotal(), expectedPage.getTotal());	
		Assert.assertEquals(userPage.getSupport().url, expectedPage.getSupport().url);
		Assert.assertEquals(userPage.getSupport().text, expectedPage.getSupport().text);
		Assert.assertEquals(userPage.getData().length, expectedPage.getData().length);	
	}

	private String getEndpoint(String endpoint) {
		return baseUrl + endpoint;
	}
}
