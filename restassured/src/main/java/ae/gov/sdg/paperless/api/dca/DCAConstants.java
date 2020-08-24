/**
 * 
 */
package ae.gov.sdg.paperless.api.dca;

import ae.gov.sdg.paperless.api.utils.CommonUtility;

/**
 * @author c_farkalit.usman
 *
 */
public class DCAConstants {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String ALMAJLIS_REVIEW_BOOKING_PAYLOAD = "{\r\n" + 
			"  \"MajlisReservationId\": 0,\r\n" + 
			"  \"GuestName\": \" dubai now majlis test26 \",\r\n" + 
			"  \"ApplicantName\": \"dubai now majlis test\",\r\n" + 
			"  \"ApplicantMobile\": \"00971561715321\",\r\n" + 
			"  \"ApplicantEmail\": \"atahar.mohammad@dubaiairports.ae\",\r\n" + 
			"  \"FlightType\": 2,\r\n" + 
			"  \"ArrivalFlightNo\": \" EK 385     \",\r\n" + 
			"  \"ArrAirline\": \" EK\",\r\n" + 
			"  \"ArrivalDate\": \"14/08/2020 12:00\",\r\n" + 
			"  \"ETA\": \"04:45\",\r\n" + 
			"  \"ArrivalHour\": 4,\r\n" + 
			"  \"ArrivalMinute\": 45,\r\n" + 
			"  \"DepartureFlightNo\": \" EK 219     \",\r\n" + 
			"  \"DepAirline\": \" EK\",\r\n" + 
			"  \"DepartureDate\": \"14/08/2020 12:00\",\r\n" + 
			"  \"ETD\": \"02:50\",\r\n" + 
			"  \"DepartureHour\": 2,\r\n" + 
			"  \"DepartureMinute\": 50,\r\n" + 
			"  \"Origin\": \" Hongkong \",\r\n" + 
			"  \"Destination\": \" Orlando \",\r\n" + 
			"  \"PaymentMode\": 6,\r\n" + 
			"  \"PrefferedLanguage\": null,\r\n" + 
			"  \"PassengersDetail\": [\r\n" + 
			"    {\r\n" + 
			"      \"ID\": 1152391,\r\n" + 
			"      \"Name\": \"pax1\",\r\n" + 
			"      \"PassportNo\": \"123254\",\r\n" + 
			"      \"Nationality\": \"95\",\r\n" + 
			"      \"DOB\": \"21/11/1990\",\r\n" + 
			"      \"Type\": 1,\r\n" + 
			"      \"TypeDesc\": \"Adult\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"Services\": [],\r\n" + 
			"  \"TotalFees\": 1595,\r\n" + 
			"  \"SpecialRequirements\":[1,2],\r\n" + 
			"  \"ArrivalStatus\": 2,\r\n" + 
			"  \"ArrivalStatusDesc\": \"Approved\",\r\n" + 
			"  \"DepartureStatus\": 0,\r\n" + 
			"  \"DepartureStatusDesc\": \"Approved\"\r\n" + 
			"}";
	
	
	public static final String ALMAJLIS_CREATE_BOOKING_PAYLOAD = "{\r\n" + 
			"  \"MajlisReservationId\": 0,\r\n" + 
			"  \"GuestName\": \" dubai now majlis test26 \",\r\n" + 
			"  \"ApplicantName\": \" dubai now majlis test26 \",\r\n" + 
			"  \"ApplicantMobile\": \"00971561715321\",\r\n" + 
			"  \"ApplicantEmail\": \"atahar.mohammad@dubaiairports.ae\",\r\n" + 
			"  \"FlightType\": 2,\r\n" + 
			"  \"ArrivalFlightNo\": \" EK 385     \",\r\n" + 
			"  \"ArrAirline\": \" EK\",\r\n" + 
			"  \"ArrivalDate\": \"14/08/2020 12:00\",\r\n" + 
			"  \"ETA\": \"04:45\",\r\n" + 
			"  \"ArrivalHour\": 4,\r\n" + 
			"  \"ArrivalMinute\": 45,\r\n" + 
			"  \"DepartureFlightNo\": \" EK 219     \",\r\n" + 
			"  \"DepAirline\": \" EK\",\r\n" + 
			"  \"DepartureDate\": \"14/08/2020 12:00\",\r\n" + 
			"  \"ETD\": \"02:50\",\r\n" + 
			"  \"DepartureHour\": 2,\r\n" + 
			"  \"DepartureMinute\": 50,\r\n" + 
			"  \"Origin\": \" Hongkong \",\r\n" + 
			"  \"Destination\": \" Orlando \",\r\n" + 
			"  \"PaymentMode\": 6,\r\n" + 
			"  \"PrefferedLanguage\": null,\r\n" + 
			"  \"PassengersDetail\": [\r\n" + 
			"    {\r\n" + 
			"      \"ID\": 0,\r\n" + 
			"      \"Name\": \"pax1\",\r\n" + 
			"      \"PassportNo\": \"123254\",\r\n" + 
			"      \"Nationality\": \"95\",\r\n" + 
			"      \"DOB\": \"21/11/1990\",\r\n" + 
			"      \"Type\": 1,\r\n" + 
			"      \"TypeDesc\": \"Adult\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"Services\": [\r\n" + 
			"    {\r\n" + 
			"      \"ReceiptNo\": null,\r\n" + 
			"      \"ServiceCode\": \"1610\",\r\n" + 
			"      \"ServiceName\": \"Individual Charges 1500.00 AED Per Person\",\r\n" + 
			"      \"Quantity\": 1,\r\n" + 
			"      \"ServiceAmount\": 1500,\r\n" + 
			"      \"VATRate\": 5,\r\n" + 
			"      \"VATAmount\": 75,\r\n" + 
			"      \"IFAmount\": 10,\r\n" + 
			"      \"KFAmount\": 10,\r\n" + 
			"      \"Total\": 1595\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"TotalFees\": 1595,\r\n" + 
			"  \"SpecialRequirements\": [\r\n" + 
			"    \"1\",\r\n" + 
			"    \"2\",\r\n" + 
			"    \"\"\r\n" + 
			"  ],\r\n" + 
			"  \"ArrivalStatus\": 0,\r\n" + 
			"  \"ArrivalStatusDesc\": \"New\",\r\n" + 
			"  \"DepartureStatus\": 0,\r\n" + 
			"  \"DepartureStatusDesc\": \"New\"\r\n" + 
			"}";
	
	
	public static final String LPMS_REGISTER_LOSTITEM_PAYLOAD = "{\r\n" + 
			"  \"ItemDescription\": \"Test2 by ICT Please ignore\",\r\n" + 
			"  \"IncidentDate\": \"29/06/2020\",\r\n" + 
			"  \"IncidentDate_Hour\": 14,\r\n" + 
			"  \"IncidentDate_Minute\": 20,\r\n" + 
			"  \"CategoryName\": \"Bank cards\",\r\n" + 
			"  \"CategoryOtherDesc\": \"\",\r\n" + 
			"  \"CategoryId\": \"33\",\r\n" + 
			"  \"FLCategoryName\": \"Atm cards\",\r\n" + 
			"  \"FLCategoryOtherDesc\": \"\",\r\n" + 
			"  \"FLCategoryId\": \"94\",\r\n" + 
			"  \"SLCategoryName\": \"Credit or Debit Cards\",\r\n" + 
			"  \"SLCategoryOtherDesc\": \"\",\r\n" + 
			"  \"SLCategoryId\": \"13\",\r\n" + 
			"  \"Brand\": \"Xyz bank\",\r\n" + 
			"  \"Model\": \"2019\",\r\n" + 
			"  \"Color\": \"blue\",\r\n" + 
			"  \"FirstName\": \"atahar\",\r\n" + 
			"  \"LastName\": \"aleem\",\r\n" + 
			"  \"Email\": \"atahar.mohammad@dubaiairports.ae\",\r\n" + 
			"  \"Mobile\": \"971561715321\",\r\n" + 
			"  \"Telephone\": \"\",\r\n" + 
			"  \"Nationality\": \"india\",\r\n" + 
			"  \"NationalityId\": 102,\r\n" + 
			"  \"FlightNumber\": \"EK530\",\r\n" + 
			"  \"FlightDate\": \"29/06/2020\",\r\n" + 
			"  \"FlightType\": \"1\",\r\n" + 
			"  \"TerminalId\": 1,\r\n" + 
			"  \"TerminalName\": \"Terminal 1\",\r\n" + 
			"  \"AreaId\": 1,\r\n" + 
			"  \"AreaName\": \"Arrival\",\r\n" + 
			"  \"LocationId\": 19,\r\n" + 
			"  \"LocationName\": \"Baggage Belt 1\",\r\n" + 
			"  \"Title\": \"\"\r\n" + 
			"}"; 
	
	
	////////////////////////////////////////////
	/*
	 * Client Soap Web Service API
	 * 
	 *//////////////////////////////////////////
	private static final String username = "dsgfis";
	private static final String password = "dsgfis@2014";
	 
	public static final String FLIGHT_STATUS_NUMBER_ENVELOP = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:flig=\"http://tempuri.org/DCAWebServices/FlightServices\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <flig:GetFlightStatusByNumber>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:FlightNumber>AF655</flig:FlightNumber>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"          <flig:Username>"+username+"</flig:Username>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:Password>"+password+"</flig:Password>\r\n" + 
			"      </flig:GetFlightStatusByNumber>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	
	public static final String DEPARTURE_DATETIME_RANGE_ENVELOP = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:flig=\"http://tempuri.org/DCAWebServices/FlightServices\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <flig:GetDeparturesDateTimeRange>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:FromDate>"+CommonUtility.getCurrentDate(DATE_FORMAT)+"</flig:FromDate>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:ToDate>"+CommonUtility.getCurrentDateAddDays(DCAConstants.DATE_FORMAT, 1)+"</flig:ToDate>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"           <flig:Username>"+username+"</flig:Username>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:Password>"+password+"</flig:Password>\r\n" + 
			"      </flig:GetDeparturesDateTimeRange>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	
	public static final String ARRIVAL_DATETIME_RANGE_ENVELOP = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:flig=\"http://tempuri.org/DCAWebServices/FlightServices\">\r\n" + 
			"   <soapenv:Header/>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <flig:GetArrivalsDateTimeRange>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:FromDate>"+CommonUtility.getCurrentDate(DATE_FORMAT)+"</flig:FromDate>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:ToDate>"+CommonUtility.getCurrentDateAddDays(DCAConstants.DATE_FORMAT, 1)+"</flig:ToDate>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"           <flig:Username>"+username+"</flig:Username>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <flig:Password>"+password+"</flig:Password>\r\n" + 
			"      </flig:GetArrivalsDateTimeRange>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
}
