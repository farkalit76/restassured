/**
 * 
 */
package ae.gov.sdg.paperless.api;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author c_farkalit.usman
 *
 */
public class MyTest {

	@Test( groups = {"dev","qa"})
	public void myTest() {
		assertEquals(true, true);
	}
	
//	@Test( groups = {"dev","qa"})
//	public void myTestFail() {
//		assertEquals(true, false);
//	}
}
