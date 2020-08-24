/**
 * 
 */
package ae.gov.sdg.paperless.api;

import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * @author c_farkalit.usman
 *
 */
public class RunAllApiTest {

	/**
	 * Run by Java main method
	 */
//	public static void main(String[] args) {
//		TestListenerAdapter tla = new TestListenerAdapter();
//		TestNG testng = new TestNG();
//		testng.setTestClasses(new Class[] { DHATests.class });
//		testng.addListener(tla);
//		testng.run();
//	}

	/**
	 * Run another way as:
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestSuite main calss started....");
		System.out.println("args:"+args.length);
		if( args == null || args.length == 0) {
			System.out.println("Please enter the environment arguments [dev, qa, or prod]....");
			System.exit(0);
		}
		if( args.length > 0) {
			System.out.println("args:"+args[0]);
			System.setProperty("env", args[0]);
		}
		testSuite(args[0]);
	}

	/**
	 * Run another way: Write Test suite in java (instead of testng.xml file) Sample
	 * of testng.xml
	 * 
	 * <suite name="TmpSuite" > <test name="TmpTest" > <classes>
	 * <class name="ae.gov.sdg.paperless.api.dha.DHATests" /> <classes> </test>
	 * </suite>
	 *
	 */
	public static void testSuite(String groupName) {
		XmlSuite suite = new XmlSuite();
		suite.setName("WSO2_RESTAPI_TestSuite");
		
		//Set listeners
		List<String> listeners = new ArrayList<String>();
		listeners.add("ae.gov.sdg.paperless.api.utils.PropertyInjectorListener");
		listeners.add("ae.gov.sdg.paperless.api.utils.ReportListener");
		suite.setListeners(listeners);
		
		XmlTest test = new XmlTest(suite);
		test.setName("DubaiNowTest");
		
		//Set groups
		List<String> names = new ArrayList<String>();
		names.add(groupName);
		test.setIncludedGroups(names);

		//Set classes
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("ae.gov.sdg.paperless.api.dca.DCATest"));
		classes.add(new XmlClass("ae.gov.sdg.paperless.api.dca.DubaiAirportApiTest"));
		classes.add(new XmlClass("ae.gov.sdg.paperless.api.dha.DHATest"));
		classes.add(new XmlClass("ae.gov.sdg.paperless.api.MyTest"));
		test.setXmlClasses(classes);
		
		// Then add it as
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
		Reporter.log("M3 WAS CALLED");
	}
}
