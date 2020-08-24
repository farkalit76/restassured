/**
 * 
 */
package ae.gov.sdg.paperless.api.dca;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ae.gov.sdg.paperless.api.utils.AppAuthService;
import ae.gov.sdg.paperless.api.utils.CommonUtility;
import io.restassured.http.ContentType;

/**
 * @author c_farkalit.usman
 *
 */
public class DubaiAirportApiTest {

	private String token;
	private static final String API_KEY = "apiKey";
	private static final String API_KEY_VALUE = "64Gwz5b5NH";
	private Map<String, String> headers = new HashMap<String, String>();
	
	public DubaiAirportApiTest() {
		this.token = AppAuthService.getAuthToken();
		System.out.println("token generated...");
		headers.put("Content-Type", "text/xml; charset=utf-8");
	}
	
	@Test( groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl","dcaFlightStatusbyNumber","clientSoapFlightStatusByNumber","clientDCABaseUrl"})
	public void testStatusByFlightNumber(String gsbDCABaseUrl, String dcaFlightStatusbyNumber, String clientSoapFlightStatusByNumber, String clientDCABaseUrl) {
		
		given().auth().oauth2(token).accept(ContentType.JSON).param("flightnumber", "AF655")
				.get(gsbDCABaseUrl + dcaFlightStatusbyNumber).then().statusCode(200)
				.body(containsStringIgnoringCase("GetFlightStatusByNumberResponse"))
				.body("GetFlightStatusByNumberResponse.FlightStatusByNumber[0].flightNumber", equalTo("AF655"));
		
		//Client Service call
		headers.put("SOAPAction", clientSoapFlightStatusByNumber);
		given().headers(headers).body(DCAConstants.FLIGHT_STATUS_NUMBER_ENVELOP)																																																																																																		
				.post(clientDCABaseUrl).then().statusCode(200)
				.body("Envelope.Body.GetFlightStatusByNumberResponse.GetFlightStatusByNumberResult.diffgram.NewDataSet.FlightStatusByNumber[0].flightNumber", is("AF655"));
	
	}

	@Test( groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl","dcaDepartureDatetimeRange","clientSoapDepartureDateTimeRange", "clientDCABaseUrl"})
	public void testFlighDepartureDatetimeRange(String gsbDCABaseUrl,String dcaDepartureDatetimeRange, String clientSoapDepartureDateTimeRange, String clientDCABaseUrl) {
		
		given().auth().oauth2(token).param("fromdate", CommonUtility.getCurrentDate(DCAConstants.DATE_FORMAT))
				.param("todate", CommonUtility.getCurrentDateAddDays(DCAConstants.DATE_FORMAT, 1))
				.get(gsbDCABaseUrl + dcaDepartureDatetimeRange).then().statusCode(200)
				.body(containsStringIgnoringCase("GetDeparturesDateTimeRangeResponse"))
				.body("GetDeparturesDateTimeRangeResponse.Departures24hrsDTRange[0].rowOrder", equalTo("0"));
		
		//Client Service call
		headers.put("SOAPAction", clientSoapDepartureDateTimeRange);
		given().headers(headers).body(DCAConstants.DEPARTURE_DATETIME_RANGE_ENVELOP)																																																																																																			
				.post(clientDCABaseUrl).then().statusCode(200)
				.body("Envelope.Body.GetDeparturesDateTimeRangeResponse.GetDeparturesDateTimeRangeResult.diffgram.NewDataSet.Departures24hrsDTRange[0].flightNumber", notNullValue());
	}

	@Test( groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl","dcaArrivalDatetimeRange", "clientSoapArrivalDateTimeRange", "clientDCABaseUrl"})
	public void testFlighArrivalDatetimeRange(String gsbDCABaseUrl, String dcaArrivalDatetimeRange, String clientSoapArrivalDateTimeRange, String clientDCABaseUrl) {
		
		given().auth().oauth2(token).param("fromdate", CommonUtility.getCurrentDate(DCAConstants.DATE_FORMAT))
				.param("todate", CommonUtility.getCurrentDateAddDays(DCAConstants.DATE_FORMAT, 1))
				.get(gsbDCABaseUrl + dcaArrivalDatetimeRange).then().statusCode(200)
				.body(containsStringIgnoringCase("GetArrivalsDateTimeRangeResponse"))
				.body("GetArrivalsDateTimeRangeResponse.Arrivals24hrsDTRange[0].rowOrder", equalTo("0"));
		
		//Client Service call
		headers.put("SOAPAction", clientSoapArrivalDateTimeRange);
		given().headers(headers).body(DCAConstants.ARRIVAL_DATETIME_RANGE_ENVELOP)																																																																																																			
				.post(clientDCABaseUrl).then().statusCode(200)
				.body("Envelope.Body.GetArrivalsDateTimeRangeResponse.GetArrivalsDateTimeRangeResult.diffgram.NewDataSet.Arrivals24hrsDTRange[0].flightNumber", notNullValue());
	}

	@Test( enabled = false, groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl","dcaAlmajlisGetBooking", "clientAlmajlisGetBooking"})
	public void testAlmajlisGetBookingInfo(String gsbDCABaseUrl, String dcaAlmajlisGetBooking, String clientAlmajlisGetBooking) {
		
		given().auth().oauth2(token).param("BookingID", "295210").get(gsbDCABaseUrl + dcaAlmajlisGetBooking).then()
				.statusCode(200).body(containsStringIgnoringCase("MajlisReservationId"))
				.body("MajlisReservationId", equalTo(295210));
		
		//Client Service Call
		given().header(API_KEY, API_KEY_VALUE).param("BookingID", "295210").get(clientAlmajlisGetBooking).then()
			.statusCode(200).body(containsStringIgnoringCase("MajlisReservationId"))
			.body("MajlisReservationId", equalTo(295210));
	}

	@Test( enabled = false, groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl","dcaAlmajlisReviewBooking","clientAlmajlisReviewBooking"})
	public void testAlmajlisReviewBooking(String gsbDCABaseUrl, String dcaAlmajlisReviewBooking, String clientAlmajlisReviewBooking) {
		
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(DCAConstants.ALMAJLIS_REVIEW_BOOKING_PAYLOAD).post(gsbDCABaseUrl + dcaAlmajlisReviewBooking).then()
				.statusCode(200).body("Booking", equalTo(null));
		
		//Client Service Call
		given().header(API_KEY, API_KEY_VALUE).contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(DCAConstants.ALMAJLIS_REVIEW_BOOKING_PAYLOAD).post(clientAlmajlisReviewBooking).then()
			.statusCode(200).body("Booking", equalTo(null));
	}

	@Test( enabled = false, groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl","dcaAlmajlisCreateBooking","clientAlmajlisCreateBooking"})
	public void testAlmajlisCreateBooking(String gsbDCABaseUrl,String dcaAlmajlisCreateBooking, String clientAlmajlisCreateBooking) {
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(DCAConstants.ALMAJLIS_CREATE_BOOKING_PAYLOAD).post(gsbDCABaseUrl + dcaAlmajlisCreateBooking).then()
				.statusCode(200).body(containsStringIgnoringCase("result"));

		//Client Service Call
		given().header(API_KEY, API_KEY_VALUE).contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(DCAConstants.ALMAJLIS_CREATE_BOOKING_PAYLOAD).post(clientAlmajlisCreateBooking).then()
			.statusCode(200).body(containsStringIgnoringCase("result"));
	}

	@Test( enabled = false, groups = {"dev","qa"})
	@Parameters({"gsbDCABaseUrl", "dcaLpmsRegisterLostItem", "clientLpmsRegisterLostItem"})
	public void testLpmsRegisterLostItem(String gsbDCABaseUrl, String dcaLpmsRegisterLostItem, String clientLpmsRegisterLostItem) {
		
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(DCAConstants.LPMS_REGISTER_LOSTITEM_PAYLOAD).post(gsbDCABaseUrl + dcaLpmsRegisterLostItem).then()
				.statusCode(200).body(containsStringIgnoringCase("result"));

		//Client Service Call
		given().header(API_KEY, API_KEY_VALUE).contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(DCAConstants.LPMS_REGISTER_LOSTITEM_PAYLOAD).post(clientLpmsRegisterLostItem).then()
			.statusCode(200).body(containsStringIgnoringCase("result"));
	}

}
