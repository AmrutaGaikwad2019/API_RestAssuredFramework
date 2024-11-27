package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	UserPayload userpayload;

	@BeforeClass
	public void generateTestData() {
		faker=new Faker();
		userpayload=new UserPayload();

		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());		
	}
	
	@Test(priority=1)
	public void Test_CreateUser() {
		Response response=UserEndpoints.createUser(this.userpayload);
		System.out.println("*---Test_CreateUser---*");
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void Test_getUser() {
		Response response=UserEndpoints.getUser(this.userpayload.getUsername());
		System.out.println("*---Test_getUser---*");
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	public void Test_updateUser() {
		
		userpayload.setUsername(faker.name().username());
		
		Response response=UserEndpoints.updateUser(this.userpayload.getUsername(), userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("*---Test_updateUser---*");
		Response postUpdateresponse=UserEndpoints.getUser(this.userpayload.getUsername());
		postUpdateresponse.then().log().all();
	}
	
	@Test(priority=4)
	public void Test_deleteUser() {
		
		Response response=UserEndpoints.deleteUser(this.userpayload.getUsername(), userpayload);
		System.out.println("*---Test_deleteUser---*");
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("*---Test_afterdeleteUser---*");
		Response postUpdateresponse=UserEndpoints.getUser(this.userpayload.getUsername());
		postUpdateresponse.then().log().all();
	}
}
