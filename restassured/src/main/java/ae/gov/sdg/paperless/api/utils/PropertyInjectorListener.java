/**
 * 
 */
package ae.gov.sdg.paperless.api.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

/**
 * @author c_farkalit.usman
 *
 */
public class PropertyInjectorListener implements IAlterSuiteListener {

//	private static final String propFile = "src/main/resources/application.properties";
//	private static final String propFileQA = "src/main/resources/application-qa.properties";
//	private static final String propFileProd = "src/main/resources/application-prod.properties";

	private static final String propFile = "application.properties";
	private static final String propFileDEV = "application-dev.properties";
	private static final String propFileQA = "application-qa.properties";
	private static final String propFilePROD = "application-prod.properties";

	public void alter(List<XmlSuite> suites) {
		String profileName = getProfileName();
		System.out.println("profileName:" + profileName);
		XmlSuite suite = suites.get(0);
		Properties properties = new Properties();
		try {
			System.out.println("\n ***Properties file and env:" + profileName + "***\n");
			URL root = getClass().getProtectionDomain().getCodeSource().getLocation();
			System.out.println("Root Location:"+root.getPath());
			URL propertiesFile = new URL(root, profileName);
			properties.load(propertiesFile.openStream());
			//properties.load(new FileReader(profileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Map<String, String> params = new HashMap<String, String>();
		for (Map.Entry<Object, Object> each : properties.entrySet()) {
			params.put(each.getKey().toString(), each.getValue().toString());
		}
		suite.setParameters(params);
	}

	/**
	 * Get the properties file based on environment.
	 */
	private String getProfileName() {
		
		String profileName = "";
		String getenv = System.getProperty("env");
		if (getenv.equalsIgnoreCase("qa")) {
			profileName = propFileQA;
		} else if (getenv.equalsIgnoreCase("prod")) {
			profileName = propFilePROD;
		} else if (getenv.equalsIgnoreCase("dev")) {
			profileName = propFileDEV;
		} else {
			profileName = propFile;
		}
		return profileName;
	}
}
