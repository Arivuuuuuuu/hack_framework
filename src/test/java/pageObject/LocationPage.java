package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPage extends BasePage{
	
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 //WebDriver driver;
	 public LocationPage(WebDriver driver){
		super(driver);
	}

		
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement clear_location;
	
	public void clearLocation() throws InterruptedException {
		//Thread.sleep(5000);
		
		Thread.sleep(5000);
		clear_location.clear();
	}
	
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement set_location;
	
	public void setLocation(String city) throws InterruptedException {
		Thread.sleep(5000);
		//set_location.sendKeys("Mumbai");
		set_location.sendKeys(city);
//		Thread.sleep(3000);
//		clear_location.clear();
//		Thread.sleep(3000);
//		set_location.sendKeys(city);
	}

	
	@FindBy(xpath="(//div[@data-qa-id='omni-suggestion-main'])[1]")
	WebElement click_location;
	
	public void clickLocation() throws InterruptedException {
		Thread.sleep(5000);
		//click_location.click();
		js.executeScript("arguments[0].click()",click_location);
	}
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement click_department;
	
	public void clickDepartment() {
		click_department.click();
	}
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-item'][4]")
	WebElement select_department;
	
	public void selectDepartment() {
		select_department.click();
	}

}
