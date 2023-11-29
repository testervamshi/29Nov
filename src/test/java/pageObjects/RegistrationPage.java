package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_fstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lstname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_passsword;
	
	@FindBy(xpath="//input[@class='form-check-input']")
	WebElement chkbx_privacy;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement btn_continue;
	
	public void setFirstname(String fname) {
		txt_fstname.sendKeys(fname);
	}
	
	public void setLastname(String Lname) {
		txt_lstname.sendKeys(Lname);
	}
	
	public void setEmail(String mail) {
		txt_email.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		txt_passsword.sendKeys(pwd);
	}
	
	public void clickCheckbox() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", chkbx_privacy);
		//chkbx_privacy.click();
	}
	
	public void clickContinue() {
		btn_continue.submit();
	}

}
