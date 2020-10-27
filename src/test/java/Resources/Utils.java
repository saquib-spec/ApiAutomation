package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	public RequestSpecification requestSpecificaion() throws IOException {
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	//RestAssured.baseURI = "https://rahulshettyacademy.com";
	
	req =new RequestSpecBuilder().setBaseUri(getGlobal("baseUrl")).addQueryParam("key", "qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType("application/json").build();
			
	return req;
		}
		return req;
	
	}
	
	public static String getGlobal(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream  fis = new FileInputStream("C:\\Users\\msaquib\\eclipse-workspace\\APIFramework\\src\\test\\java\\Resources\\GlobalProperties.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	public String getjsonpath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
		
	}
}
