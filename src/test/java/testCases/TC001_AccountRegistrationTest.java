package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		logger.info("******Starting TC001_AccountRegistrationTest ******");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("clicked on Register Link..");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setPhone(randomeNumber());
		//String password=randomAlphaNumeric();
		
		String password=randomeAlphaNumeric();
		Reporter.log(password,true);
		regpage.setPassword(password);
		regpage.confPwd(password);
		
		
		regpage.checkPolicy();
		regpage.pressContinue();
		
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		}
	
	public String randomString() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		Reporter.log(generatedstring,true);
		return generatedstring;
	}
	
	public String randomeNumber() {
		String generatednumber=RandomStringUtils.randomNumeric(10);
		Reporter.log(generatednumber,true);
		return generatednumber;
	}
	
	public String randomeAlphaNumeric() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}

}
