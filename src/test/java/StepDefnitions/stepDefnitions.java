package StepDefnitions;

import Resources.ApiResources;
import Resources.TestDataBuild;
import Resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefnitions extends Utils {
	RequestSpecification req;
	ResponseSpecification resspec;
	Response response;
	ValidatableResponse json;
	static String  place_id;
	
	@Given("Add Place Payload with {string} {string} {string}" )
    public void add_place_payload_with_something_something_something(String name, String language, String address)throws IOException {
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
	    req = given().spec(requestSpecificaion())
	    		.body(TestDataBuild.addPlacePayLoad(name, language, address));
		
		}

	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String resource) {
	    // Write code here that turns the phrase above into concrete actions
		ApiResources resourceApi = ApiResources.valueOf(resource);
		System.out.println(resourceApi.getResource());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(io.restassured.http.ContentType.JSON).build();
		response = req.when().post(resourceApi.getResource()).then().spec(resspec).extract().response();
		//System.out.println(response);
	}
	@Then("The response status code is {int}")
	public void the_response_status_code_is(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		//json = response.then().assertThat().statusCode(200);
		assertEquals(response.statusCode(),200);
		System.out.println(response.statusCode());
		
		
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected) {
	    // Write code here that turns the phrase above into concrete actions
		
		//String respo = response.asString();
		//JsonPath js = new JsonPath(respo);
		assertEquals(getjsonpath(response, key),expected);
		
		
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String string, String resource) throws IOException {
	    //prepare a reqspec 
		place_id = getjsonpath(response, "place_id");
		RequestSpecification res = given().spec(requestSpecificaion()).queryParam("place_id", place_id);
		ApiResources resourceApi = ApiResources.valueOf(resource);
		response = res.when().get(resourceApi.getResource()).then().spec(resspec).extract().response();
		String name = getjsonpath(response, "name");
		assertEquals(name, string);
		System.out.println(place_id);
		
		
	}
	
	@Given("Delete place Payload")
	public void delete_place_payload() throws IOException {
		System.out.println(place_id);
		req = given().spec(requestSpecificaion()).body(TestDataBuild.deleteplacePayload(place_id));
		
	    
	}


}
