/**
 * 
 */
package ae.gov.sdg.paperless.api.dca;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import ae.gov.sdg.paperless.api.utils.AppAuthService;
import io.restassured.http.ContentType;

/**
 * @author c_farkalit.usman
 *
 */
public class DCATest {

	private String token;
	private String flightByStatusNumber ="https://api.qa.dubai.gov.ae/secure/dac/flightinfo/5.0.0/flightstatusbynumber";
	private String clientDCABaseUrl = "https://services.dubaiairports.ae/dsgfiswebservice/flightservices.asmx";
	private String clientGetAirlineCodesSoapAction = "http://tempuri.org/DCAWebServices/FlightServices/GetAirlineCodes";
	
	public DCATest() {
		this.token = AppAuthService.getAuthToken();
	}
	
	@Test( groups = {"dev","prod"})
	public void testEmpty1() {
		Assert.assertEquals(true, true);
	}
	
	@Test( groups = {"dev","prod"})
	public void testEmpty2() {
		Assert.assertEquals(true, true);
	}
	
	@Test( groups = {"dev","qa"})
	public void testEmpty3() {
		Assert.assertEquals(true, true);
	}
	
	@Test( groups = {"dev","qa"})
	public void testEmpty4() {
		Assert.assertEquals(true, true);
	}
	
	@Test( groups = {"dev","qa","prod"})
	public void testStatusByFlightNumberLogging() {
		//log responses
		given().auth().oauth2(token).accept(ContentType.JSON).param("flightnumber", "AF655").log().all()
				.get(flightByStatusNumber).then().statusCode(200).log().cookies();
	}
	
	@Test( groups = {"dev","qa","prod"})
	public void testStatusByFlightNumberResponseTime() {
		// response time Milliseconds
		given().auth().oauth2(token).accept(ContentType.JSON).param("flightnumber", "AF655")
				.get(flightByStatusNumber).then().statusCode(200).time(lessThan(1000L)); 
	}
	
	//@Test( enabled = false, groups = {"dev","qa"})
	@Test( groups = {"dev","qa"})
	public void testGetAirlinesCodesSaopApi() {
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "text/xml; charset=utf-8");
		headers.put("SOAPAction", clientGetAirlineCodesSoapAction);
		
		//Response response = 
		given().headers(headers).body(soapEnvelop).log().all()																																																																																																			
				.post(clientDCABaseUrl).then().statusCode(200)
				.body("Envelope.Body.GetAirlineCodesResponse.GetAirlineCodesResult.diffgram.NewDataSet.AirlineCodes[0].airlineCode3", is("VJT")).extract().response();
		
		//System.out.println("response is: " +  response);
		//System.out.println("response s is: " +  response.asString());
		//XmlPath path = new XmlPath(response.asString());
		//System.out.println("path is: " +  path);
		//System.out.println("path p is: " +  path.prettify());
		//System.out.println("path pp is: " +  path.prettyPrint());
		//Object dataset = path.get("/Envelope/Body/GetAirlineCodesResponse/GetAirlineCodesResult/diffgram/NewDataSet/AirlineCodes[0]");
		//System.out.println("dataset returned as: " +  dataset);
	}
	
	String soapEnvelop = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:flig=\"http://tempuri.org/DCAWebServices/FlightServices\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <flig:GetAirlineCodes>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:Username>dsgfis</flig:Username>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:Password>dsgfis@2014</flig:Password>\r\n" + 
			"      </flig:GetAirlineCodes>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";

}
