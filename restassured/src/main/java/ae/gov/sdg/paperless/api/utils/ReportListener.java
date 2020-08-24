/**
 * 
 */
package ae.gov.sdg.paperless.api.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author c_farkalit.usman
 *
 */
public class ReportListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("All Tests have been completed...");

		System.out.println(context.getFailedTests());
		if (context.getFailedTests() != null) {
			System.out.println("numberOfFailedTest:" + context.getFailedTests().size());
		}

		if (context.getPassedTests() != null) {
			System.out.println("numberOfPassedTest:" + context.getPassedTests().size());
		}

		if (context.getSkippedTests() != null) {
			System.out.println("numberOfSkippedTest:" + context.getSkippedTests().size());
		}
		SendEmail.sendEmail();
		System.out.println("Email Sent completed...");
	}

}
