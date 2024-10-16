package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfPwd;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void confPwd(String pwd) {
		txtConfPwd.sendKeys(pwd);
	}
	
	public void checkPolicy() {
		chkdPolicy.click();
	}
	
	public void pressContinue() {
		btnContinue.submit();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
