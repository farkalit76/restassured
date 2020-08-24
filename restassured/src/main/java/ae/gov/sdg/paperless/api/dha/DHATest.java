/**
 * 
 */
package ae.gov.sdg.paperless.api.dha;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DHATest {
	
	//private static final Logger LOG = LogManager.getLogger(DHATest.class);

	@Test( groups = {"dev","qa"})
	public void testEmpty() {
		//LOG.debug("testing LOG4j....");
		Reporter.log("SOAP Service WAS CALLED");
		Assert.assertEquals(true, true);
	}
}
