package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersPage extends BasePage{
   
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 //WebDriver driver;
	 public FiltersPage(WebDriver driver){
		super(driver);
	}
	 
	    @FindBy(xpath="//div[@role='button'][2]")
		WebElement click_stories;
		
		public void clickStories() throws InterruptedException {
			Thread.sleep(3000);
			click_stories.click();
		}
		
		@FindBy(xpath="//div[@role='button'][2]//li[1]")
		WebElement select_stories;
		
		public void selectStories() {
			select_stories.click();
		}
		
		@FindBy(xpath="//div[@role='button'][3]")
		WebElement click_Exp;
		
		public void clickExp() {
			click_Exp.click();
		}
		
		@FindBy(xpath="//div[@role='button'][3]//li[2]")
		WebElement select_exp;
		
		public void selectExp() {
			select_exp.click();
		}
		
		@FindBy(xpath="//div[@role='button'][4]")
		WebElement click_allfilter;
		
		public void clickAllFilter() {
			click_allfilter.click();
		}
		
		@FindBy(xpath="//div[@class='pure-u-4-24'][1]//label[3]")
		WebElement select_fees;
		
		public void selectFees() throws InterruptedException {
			//select_fees.click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()",select_fees);
		}
		
		@FindBy(xpath="//div[@class='pure-u-4-24'][1]//label[4]")
		WebElement select_availability;
		
		public void selectAvailablity() {
			//select_availability.click();	
			js.executeScript("arguments[0].click()",select_availability);
		}
		
		@FindBy(xpath="//span[text()='Relevance']")
		WebElement click_sortby;
		
		public void clickSortBy() {
			//click_sortby.click();	
			js.executeScript("arguments[0].click()",click_sortby);
		}
		
		@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li[2]")
		WebElement select_sortby;
		
		public void selectSortBy() {
			//select_sortby.click();		
			js.executeScript("arguments[0].click()",select_sortby);
		}
}
