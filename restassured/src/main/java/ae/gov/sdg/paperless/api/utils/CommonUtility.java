/**
 * 
 */
package ae.gov.sdg.paperless.api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author c_farkalit.usman
 *
 */
public class CommonUtility {

	public static String getCurrentDate(String dateFormat) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);
	}
	
	public static String getCurrentDateAddDays(String dateFormat, long daysToAdd) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate.plusDays(daysToAdd));
	}
}
