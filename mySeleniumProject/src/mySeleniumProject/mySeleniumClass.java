package mySeleniumProject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class mySeleniumClass {
	
	public static JavascriptExecutor executor;
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int FromStation;
		Random rand = new Random();
		String FromStations = "רחובות";
		String NoStation = "גדרה";
		System.setProperty("webdriver.chrome.driver", "C://Projects/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		executor = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.navigate().to("http://www.rail.co.il");
		// Pointer to the list of the stations of the rail
     	driver.findElement(By.xpath("//*[@id=\'trainSearchMain\']/div/div/div/div[2]/div[2]/input")).click();
     	WebElement dropDown = driver.findElement(By.xpath("//*[@id=\'trainSearchMain\']/div/div/div/div[2]/div[2]/div"));
     	String S = dropDown.getText().toString();
     	List <String>list = Arrays.asList(S.split("\n"));
     	  	
     	if (S.contains(FromStations)) {
     		
     		// An Alert
     		executor.executeScript("alert('"+FromStations+" is on the list');");
     		Thread.sleep(5000);
     		
     		//confirm the Alert
     		driver.switchTo().alert().accept();
     		
     		driver.findElement(By.xpath("//*[@id=\'trainSearchMain\']/div/div/div/div[2]/div[2]/input")).sendKeys(FromStations);
   
     	}
     		
     		
     
     		
     	String domain_name=(String) executor.executeScript("return document.domain");
        executor.executeScript("alert('"+domain_name+" is the domain name');");

     		
		}

}
