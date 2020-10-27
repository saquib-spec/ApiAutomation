package StepDefnitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		stepDefnitions m = new stepDefnitions();
		m.add_place_payload_with_something_something_something("saquib", "urdu", "1320 Saratoga Ave");
		m.user_calls_with_post_http_request("AddPlaceApi");
		m.verify_place_id_created_maps_to_using("saquib", "GetPlaceApi");
		
	}
	

}
