Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify place is successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceApi" with post http request
	Then The response status code is 200
	And "status" in response body is "OK"
	And verify place_id created maps to "<name>" using "GetPlaceApi"
	
Examples:
	|name  |language  |address  |
	|AAhouse | English| World cross center|
#	|BBhouse | Spanish| 2nd cross st |	
@DeletePlace
Scenario: Verify place is deleted using DeletePlaceAPI
	Given Delete place Payload
	When user calls "DeletePlaceApi" with post http request
	Then The response status code is 200
	And "status" in response body is "OK"
	
	
	
	
	 