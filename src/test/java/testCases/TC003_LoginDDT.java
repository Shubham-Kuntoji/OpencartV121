package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(groups="Datadriven", dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("******starting TC_003_LoginDDT*******");
		
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/*Data is valid - login success - test pass - logout
		 * Data is valid -- login failed - test fail
		 * 
		 * Data is invalid - login success - test fail  - logout
		 * Data is invalid -- login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				
				Assert.assertTrue(true);
				macc.clickLogut();
			}
			else {
				Assert.assertTrue(false);
			}
			if(exp.equalsIgnoreCase("invalid")) {
				if(targetPage==true) {
					macc.clickLogut();
					Assert.assertTrue(false);
				}
				else
				{
				  Assert.assertTrue(true);	
				}
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		}
			
		
	}
		
	

