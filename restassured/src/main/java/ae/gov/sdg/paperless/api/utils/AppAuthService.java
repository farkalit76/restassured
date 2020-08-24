/**
 * 
 */
package ae.gov.sdg.paperless.api.utils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author c_farkalit.usman
 *
 */
public class AppAuthService {

	public static String getAuthToken() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("grant_type", "dubainowauth");
		paramMap.put("dnusername", "shahid1311@gmail.com");
		paramMap.put("dnpwd", "Test@123");
		paramMap.put("scope", "openid");

		String username = "Wbn8larGjlsFxGxPzkx3VmBBjIYa";
		String password = "kDfwQ1Z7CyYqOFsMMrZv2VZMQuca";
		String authUrl = "https://ids.qa.dubai.gov.ae/oauth2/token";
		Response response =
				given().auth().preemptive().basic(username, password).
					contentType(ContentType.URLENC).accept(ContentType.JSON).	
					formParams(paramMap).
					post(authUrl).thenReturn();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertNotNull(response.body().asString());
	
		JsonPath jsonObj=new JsonPath(response.asString());
		//System.out.println("jsonObj is:"+jsonObj.prettyPrint());
		//String idtoken=jsonObj.get("id_token");
		//System.out.println("idtoken is:"+idtoken);
		return jsonObj.get("id_token");
	}
}
