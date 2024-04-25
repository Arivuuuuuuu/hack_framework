package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorsListPage extends BasePage{
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//WebDriver driver;
	public DoctorsListPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='pure-u-20-24']")
	WebElement doc_list;
	
	public String docList() {
		String doctors=doc_list.getText();
		return doctors;
	}

}
