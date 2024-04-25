package testCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LocationPage;
import pageObject.ThankYouPage;
import pageObject.DoctorsListPage;
import pageObject.FiltersPage;
import pageObject.SurgeryPage;
import testBase.BaseClass;

public class TC_001_doctorsList extends BaseClass{
	
	LocationPage lp;
	FiltersPage fp;
	SurgeryPage sp;
	ThankYouPage tp;
	DoctorsListPage dl;
	
	@Test(priority=1)
	public void location() throws InterruptedException {
		
		try {
		lp=new LocationPage(driver);
		
		logger.info("$$$ TestCase1 location() Method is started $$$");
		Thread.sleep(7000);
		
		lp.clearLocation();
		
		logger.info("$$$ location box is cleared $$$");
		
		Thread.sleep(7000);
		
		//fp.setLocation();
		lp.setLocation(p.getProperty("city"));
		logger.info("$$$ sending the location $$$");
		
		Thread.sleep(7000);
		
		lp.clickLocation();
		logger.info("$$$ Clicking the location $$$");
		
		Thread.sleep(3000);
		
		lp.clickDepartment();
		logger.info("$$$ Clicking the department $$$");
		
		Thread.sleep(5000);
		
		lp.selectDepartment();
		logger.info("$$$ selecting the department $$$");
		
		logger.info("$$$ TestCase1 location() Method  is ended $$$");
		
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("$$$TestCase1 location() Method  gets failed $$$");
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void filters() throws InterruptedException{
		
		try {
            
			logger.info("*** TestCase1 filters() Method is started***");
			fp=new FiltersPage(driver);
			
			Thread.sleep(7000);
			
			fp.clickStories();
			logger.info("*** clicking the stories ***");
			
			//Thread.sleep(5000);
			
			fp.selectStories();
			logger.info("*** selecting the stories ***");
			
			//Thread.sleep(5000);
			
			fp.clickExp();
			logger.info("*** clicking Experience ***");
			
			//Thread.sleep(5000);
			
			fp.selectExp();
			logger.info("*** selecting Experience ***");
			
			Thread.sleep(5000);
			
			fp.clickAllFilter();
			logger.info("*** clicking All Filters ***");
			
			//Thread.sleep(5000);
			
			fp.selectFees();
			logger.info("*** selecting Fees ***");
			
			//Thread.sleep(5000);
			
			fp.selectAvailablity();
			logger.info("*** selecting Availability ***");
			
			//Thread.sleep(5000);
			
			fp.clickSortBy();
			logger.info("*** clicking sortBy ***");
			
			//Thread.sleep(5000);
			
			fp.selectSortBy();
			
			Thread.sleep(5000);
			
			logger.info("*** selecting sortBy ***");
			
			logger.info("*** TestCase1 filters() method ended***");
			
		}
		catch(Exception e) {
			//e.printStackTrace();
			logger.error("*** TestCase1 filters() method gets failed**");
			Assert.fail();
		}
	}
	
	@Test(priority=3)
	public void docList() {
		
		try {
			logger.info("### TestCase1 docList() method is started ###");
			for(int i=2;i<7;i++) {
				Thread.sleep(10000);				
				WebElement info=driver.findElement(By.xpath("(//div[@class='info-section'])["+i+"]"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", info);		

				js.executeScript("arguments[0].click();", info);
				
				Thread.sleep(5000);
				
				Set<String>window=driver.getWindowHandles();
				logger.info("### Getting the Window Handles ###");				
				List<String>wind=new ArrayList<String>(window);
				String parent=wind.get(0);
				Thread.sleep(5000);
				String child=wind.get(1);
				driver.switchTo().window(child);
				
				//String text=driver.findElement(By.xpath("//div[@class='pure-u-20-24']")).getText();
				dl=new DoctorsListPage(driver);
				//dl.docList();
				System.out.println();
				System.out.println(dl.docList());
				//System.out.println(text);
				logger.info("### Printing the first five doctor details ###");
			    System.out.println();
				
				Thread.sleep(5000);
				
				driver.close();
				
				driver.switchTo().window(parent);	
				
			}
			logger.info("### TestCase1 docList() method ended ###");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.info("### TestCase1 docList() method gets failed ###");
			Assert.fail();
		}
	}
	
	@Test(priority=4)
	public void printSurgery() {
		try {
			logger.info("!!! TestCase1 printSurgery() method gets started !!!");
	        
	        sp=new SurgeryPage(driver);
			
			Thread.sleep(3000);
			sp.clickSurgeries();
			logger.info("!!! Clicking surgery option !!!");
			Thread.sleep(3000);
			sp.surgeryList();
			
			System.out.println(sp.surgeryList());
			logger.info("!!! Printing surgery List !!!");
			System.out.println();
			logger.info("!!! TestCase1 printSurgery() method ended !!!");
			
		}
		catch(Exception e){
			e.printStackTrace();
			logger.info("!!! TestCase1 printSurgery() method gets failed !!!");
			Assert.fail();
		}
	}
	
	@Test(priority=5)
	public void validMail() {
		try {
		    
			logger.info("&&& TestCase1 validMail() method  gets started &&&");
		    tp=new ThankYouPage(driver);
			
			Thread.sleep(3000);
			
			tp.clickCorp();
			logger.info("&&& Clicking the For-corporation option &&&");
			
			Thread.sleep(3000);
			
			tp.clickHealth();
			logger.info("&&& Clicking the Health and Wellness option &&&");
			Thread.sleep(3000);
			
			tp.sendName(randomString().toLowerCase());
			logger.info("&&& Sending the name  &&&");
			
			//Thread.sleep(3000);
			
			tp.sendOrgName(randomString().toLowerCase());
			logger.info("&&& Sending the organization name  &&&");
			
			//Thread.sleep(3000);
			
			//lp.sendContact(randomNum());
			tp.sendContact(p.getProperty("contact"));
			logger.info("&&& Sending the contact number  &&&");
			
			//Thread.sleep(3000);
			
			tp.sendMail(randomString().toLowerCase());
			logger.info("&&& Sending the Wrong mailID  &&&");
			
			//Thread.sleep(3000);
			
			tp.clickOrgSize();
			logger.info("&&& Clicking the organization size  &&&");
			Thread.sleep(3000);
			
			tp.clickInterest();
			logger.info("&&& Clicking the InterestedIn option  &&&");
			Thread.sleep(3000);
			logger.info("&&& Checking whether the submit button is enabled or not  &&&");
			if(tp.submit.isEnabled()) {
				System.out.println("submit is enabled");
			}
			else {
				System.out.println("Submit is not enabled");
			}
			
			Thread.sleep(10000);
			
			tp.clearMail();
			logger.info("&&& Clearing the mailId column &&&");
			Thread.sleep(3000);
			tp.sendCorrectMail(randomString().toLowerCase()+"@gmail.com");
			logger.info("&&& Sending the correct mailId  &&&");
			
			//Thread.sleep(3000);
			
			tp.clickSubmit();
			logger.info("&&& Clicking the submit button &&&");
			
			Thread.sleep(3000);
			
			logger.info("&&& Checking whether the Thnak You message is displayed or not  &&&");
			if(tp.thanks.isDisplayed()) {
				System.out.println("Thank You message is displayed");
			}
			else {
				System.out.println("Thank You message is not displayed");
			}
			
			logger.info("&&& TestCase1 validMail() method  ended&&&");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.info("&&& TestCase1 validMail() method gets failed &&&");
			Assert.fail();
		}
	}

}
