package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurgeryPage extends BasePage{
    
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//WebDriver driver;
	public SurgeryPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//div[contains(text(),'Surgeries')]")
	WebElement click_surgery;
	
	public void clickSurgeries() {
		//click_surgery.click();
		js.executeScript("arguments[0].click()",click_surgery);
	}
	
	@FindBy(xpath="//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	public
	List<WebElement>surgery_list;
	
    public List<String>surgeryList(){
		
		List<String> el = new ArrayList<String>();
		for(WebElement ll:surgery_list) {
			el.add(ll.getText());
		}	
		return el;
	}       

}
