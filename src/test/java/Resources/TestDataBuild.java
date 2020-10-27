package Resources;

public class TestDataBuild {
	
	public static String addPlacePayLoad(String name, String language, String address) {

		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"" + name +"\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \""+ address+"\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"" +language+"\"\r\n" + 
				"}\r\n" + 
				"";
				
				
	}

	public static String deleteplacePayload(String place_id) {
		
		return "{\r\n" + 
				"    \"place_id\":\"" + place_id +"\"\r\n" + 
				"}\r\n" + 
				"";
	}
}
