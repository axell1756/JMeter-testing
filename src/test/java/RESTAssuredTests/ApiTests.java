package RESTAssuredTests;

import static io.restassured.RestAssured.given;

import com.cognizant.assessmentJUnit.Const;

import com.cognizant.assessmentJUnit.TestSuite;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.After;

import org.json.JSONArray;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiTests {

	public ExtentTest test;

	public RequestSpecification req;

	@Test
	public void getVisits() throws Throwable {

		req = given().contentType(ContentType.JSON);

		req.when().get(Const.ROOT_URI + Const.VISIT_URI);

		req.then().statusCode(200);

	}

	@Test
	public void updatingOwnersDetails() throws Throwable {
		req = given().contentType(ContentType.JSON);

		test = TestSuite.report.startTest("Upadting details");

		JSONObject json = new JSONObject();
		JSONObject pet = new JSONObject();
		JSONObject type = new JSONObject();
		JSONArray pets = new JSONArray();

		JSONArray visits = new JSONArray();

		type.put("id", 2);
		type.put("name", "hamster");

		pet.put("id", 2);
		pet.put("name", "Basil");
		pet.put("birthDate", "2012/08/06");
		pet.put("type", type);
		pet.put("owner", 2);
		pet.put("visits", visits);

		pets.put(pet);

		json.put("id", 2);
		json.put("firstName", 2);
		json.put("lastName", 2);
		json.put("address", 2);
		json.put("city", 2);
		json.put("telephone", 2);
		json.put("pets", pets);

		req.body(json.toString()).when().put(Const.ROOT_URI + Const.OWNERS_URI + 2);

		req.then().statusCode(204);

	}

	@Test
	public void addNewAnimal() throws Throwable {

		req = given().contentType(ContentType.JSON);

		test = TestSuite.report.startTest("Adding new animal");

		JSONObject json = new JSONObject();
		JSONObject type = new JSONObject();
		JSONObject owner = new JSONObject();
		JSONArray visits = new JSONArray();

		json.put("id", 1);
		json.put("name", "Leo");
		json.put("birthDate", "2010/09/07");

		type.put("id", 1);
		type.put("name", "cat");

		json.put("type", type);

		owner.put("id", 1);
		owner.put("firstName", "Caklsjf");
		owner.put("lastName", "Franklin");
		owner.put("address", "110 W. Liberty St.");
		owner.put("city", "Madison");
		owner.put("telephone", "6085551023");

		json.put("owner", owner);

		json.put("visits", visits);
		
		req.body(json.toString()).when().post(Const.ROOT_URI + Const.PETS_URI);

		req.then().statusCode(201);
	}

	@Test
	public void deleteAnimal() throws Throwable {

		req = given().contentType(ContentType.JSON);

		test = TestSuite.report.startTest("Adding new animal");
		
		req.when().delete(Const.ROOT_URI + Const.PETS_URI + 1);
		
		req.then().statusCode(204);

	}

	@Test
	public void addNewOwner() throws Throwable {
		
		req = given().contentType(ContentType.JSON);

		test = TestSuite.report.startTest("Creating new owner");

		JSONObject json = new JSONObject();
		JSONObject pet = new JSONObject();
		JSONObject type = new JSONObject();
		JSONArray pets = new JSONArray();

		JSONArray visits = new JSONArray();

		type.put("id", 2);
		type.put("name", "hamster");

		pet.put("id", 2);
		pet.put("name", "Basil");
		pet.put("birthDate", "2012/08/06");
		pet.put("type", type);
		pet.put("owner", 2);
		pet.put("visits", visits);

		pets.put(pet);

		json.put("id", 6);
		json.put("firstName", "Mark");
		json.put("lastName", "Test");
		json.put("address", "Test");
		json.put("city", "Test");
		json.put("telephone", "123456767");
		json.put("pets", pets);
		
		req.body(json.toString()).when().post(Const.ROOT_URI + Const.OWNERS_URI);

		req.then().statusCode(201);
		
	}

	@After
	public void tearDown() throws Exception {
		TestSuite.report.flush();
	}

}