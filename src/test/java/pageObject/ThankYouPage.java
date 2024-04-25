package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ThankYouPage extends BasePage{
    
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//WebDriver driver;
	public ThankYouPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='nav-in"
			+ "teract']")
    WebElement click_corporates;
    
    public void clickCorp() {
    	click_corporates.click();
    }
    
    @FindBy(xpath="//a[text()='Health & Wellness Plans']")
    WebElement click_health;
    
    public void clickHealth() {
    	click_health.click();
    }
    
    @FindBy(id="name")
    WebElement send_name;
    
    public void sendName(String name) {
    	//send_name.sendKeys("arivv");
    	send_name.sendKeys(name);
    }
    
    @FindBy(id="organizationName")
    WebElement send_org;
    
    public void sendOrgName(String orgname) {
    	send_org.sendKeys(orgname);
    }
    
    @FindBy(id="contactNumber")
    WebElement send_contact;
    
    public void sendContact(String contact) {
    	send_contact.sendKeys(contact);
    }
    
    @FindBy(id="officialEmailId")
    WebElement send_mailID;
    
    public void sendMail(String mail) {
    	send_mailID.sendKeys(mail);
    }
    
    @FindBy(id="organizationSize")
    WebElement click_orgSize;
    
    public void clickOrgSize() {
      Select ss=new Select(click_orgSize);
      ss.selectByIndex(2);
    }
    
    @FindBy(id="interestedIn")
    WebElement click_interest;
    
    public void clickInterest() {
      Select ss=new Select(click_interest);
      ss.selectByIndex(2);
    }
    
    @FindBy(xpath="//*[@id=\"app\"]/div/div/header[2]/div[2]/div/form/button")
	public
	WebElement submit;
    
    public void clearMail() {
    	send_mailID.clear();
    }
    
    public void sendCorrectMail(String correctmail) {
    	send_mailID.sendKeys(correctmail);
    }
    
    public void clickSubmit() {
    	//submit.click();   	
    	js.executeScript("arguments[0].click()", submit);
    }
    
    @FindBy(xpath="(//div[text()='THANK YOU'])")
	public
    WebElement thanks;
    
	
}
