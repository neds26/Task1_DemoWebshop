package DemoPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


  public class DemoWebshop {
	
	static Logger log = Logger.getLogger(DemoWebshop.class.getName());
  
	Properties pro = new Properties();
	
    WebDriver driver;
   
   @Test
   public void log4j() {
		
		//BasicConfigurator.configure();
		Layout l = new SimpleLayout();
		
		Appender ap = new ConsoleAppender(l);
		
		log.addAppender(ap);
		
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
		
		System.out.println("hello....");	
		
	}
   
	
	@BeforeSuite
	public void browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\T440\\Desktop\\Testing\\Chrome exe\\chromedriver.exe");
	   driver=new ChromeDriver();
		
	}
	
	
	@BeforeTest
	public void openurl() throws IOException
	{
		driver.get("http://demowebshop.tricentis.com/register");
		

		FileInputStream fis = new FileInputStream("D:\\cjc eclipse old\\eclipse-workspace\\Task1_DemoWebshop\\Demo.properties");
		pro.load(fis);
	
	}
	
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	
	@Test
   	public void register()
	{
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(pro.getProperty("fname"));
		driver.findElement(By.id("LastName")).sendKeys(pro.getProperty("lname"));
		driver.findElement(By.name("Email")).sendKeys(pro.getProperty("mail"));
		
		driver.findElement(By.id("Password")).sendKeys(pro.getProperty("pass"));
		driver.findElement(By.id("ConfirmPassword")).sendKeys(pro.getProperty("cpass"));
		
		driver.findElement(By.id("register-button")).click();
		
	}
	
	
}
