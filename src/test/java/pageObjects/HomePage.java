package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement btn_myAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement btn_register;
	
	public void click_myAccount() {
		btn_myAccount.click();
	}
	
	public void click_register() {
		btn_register.click();
	}
	
	

}
