package utilities;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.Assert;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	
	public class Not {
	    ExtentReports extent;
	    ExtentTest test;

	    @BeforeSuite
	    public void setup() {
	        // Specify the report location and file name
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");

	        // Create the ExtentReports object and attach the reporter
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        // Optional: Add system information
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Tester", "John Doe");
	    }

	    @Test
	    public void testSuccess() {
	        // Start a test and log the result
	        test = extent.createTest("Successful Test");
	        test.log(Status.INFO, "Starting the test: testSuccess");
	        
	        Assert.assertTrue(true);  // Test passed
	        test.log(Status.PASS, "Test passed successfully");
	        try {

				URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\");

				// Create the email message

				ImageHtmlEmail email = new ImageHtmlEmail();

				email.setDataSourceResolver (new DataSourceUrlResolver(url));

				email.setHostName("smtp.gmail.com");

				email.setSmtpPort(465);

				email.setAuthenticator (new DefaultAuthenticator("93kshubham@gmail.com","fuckinterpal"));

				email.setSSLOnConnect(true);

				email.setFrom("93kshubham@gmail.com"); //Sender

				email.setSubject("Test Results");
				email.setMsg("Please find the Attached Report");
				email.addTo("shubham.kuntoji@gmail.com");//receiver
				email.send();
			}
			catch(Exception e) {
				e.printStackTrace();

			}
	    }

	    @Test
	    public void testFailure() {
	        // Start another test and log the result
	        test = extent.createTest("Failed Test");
	        test.log(Status.INFO, "Starting the test: testFailure");

	        Assert.assertTrue(false);  // Test failed
	        test.log(Status.FAIL, "Test failed");
	    }

	    @AfterSuite
	    public void tearDown() {
	        // Flush the ExtentReports object and save the report
	        extent.flush();
	    }
	}



