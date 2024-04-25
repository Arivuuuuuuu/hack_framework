package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	protected  WebDriver driver;
	
	public Logger logger;
	
	public Properties p;
	
	public static TakesScreenshot ts;
	
	@Parameters({"browser","os"})
	@BeforeClass
	public void setup(String n,String w) throws IOException {
		
		FileInputStream file=new FileInputStream(".//src/test/resources/configg.properties");
		
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		//DesiredCapabilities cap=new DesiredCapabilities();
		
		if(p.getProperty("environment").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(w.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WINDOWS);
			}
			else if(w.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid os name");
				return;
			}
			
			if(n.equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
			}
			else if(n.equalsIgnoreCase("edge")) {
				cap.setBrowserName("edge");
			}
			else {
				System.out.println("invalid browser name");
			}
			
			String nodeURL="http://localhost:4444/wd/hub";			
			driver=new RemoteWebDriver(new URL(nodeURL),cap);
		}
		else if(p.getProperty("environment").equalsIgnoreCase("local")) {
		
			if(n.equalsIgnoreCase("edge")) {
			    driver=new EdgeDriver();
			}
			else if(n.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else {
				System.out.println("Invalid browser name");
			}
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		driver.get(p.getProperty("appURL"));
		
		driver.manage().window().maximize();
		
		ts=(TakesScreenshot)driver;
	}
	
	@AfterClass
	public void quit() {
		driver.quit();
	}
	
	public static String captureScreen(String name) {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//TakesScreenshot tc= (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String targetPath=System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timeStamp+".png";
		
		File target=new File(targetPath);
		
		src.renameTo(target);
		
		return targetPath;
	}
	
	public String randomString() {
    	String fname=RandomStringUtils.randomAlphabetic(5);
    	return fname;
    }
    
    public String randomNum() {
    	String pass=RandomStringUtils.randomNumeric(10);
    	return pass;
    }
    
    public String randomAlphaNumeric() {
    	String fname=RandomStringUtils.randomAlphabetic(3);
    	String pass=RandomStringUtils.randomNumeric(3);
    	return (fname+"@"+pass);
    }
	
	

}
