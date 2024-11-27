package api.endpoints;

public class Routes {

	
	public static String baseURL = "https://petstore.swagger.io/v2";
	
	//user module
	public static String postURL = baseURL+"/user";
	public static String getURL = baseURL+"/user/{username}";
	public static String putURL = baseURL+"/user/{username}";
	public static String deleteURL = baseURL+"/user/{username}";


}
