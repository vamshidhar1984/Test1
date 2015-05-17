package com.facebook.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testng {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
		
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	
	@Test
	public void loadPage(){
		driver.get("http://store.demoqa.com/");
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods = "loadPage")
	public void fillForm() throws IOException, InterruptedException{		
		
		/*driver.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");;
		driver.findElement(By.cssSelector("#pass")).sendKeys("abc");
		
		driver.findElement(By.cssSelector("#u_0_1")).sendKeys("abc");
		driver.findElement(By.cssSelector("#u_0_3")).sendKeys("def");
		driver.findElement(By.cssSelector("#u_0_5")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("#u_0_8")).sendKeys("abcd@gmail.com");
		
		WebElement element = driver.findElement(By.cssSelector("#u_0_a"));
		element.sendKeys("asdfg");
		//element.sendKeys("abc123");
		
		//Utils.takeScreenshot(driver, "C:\\POC\\output1.jpg");
		*/
		WebElement element = driver.findElement(By.linkText("Product Category"));
		//Utils.hover(driver, element);
		Actions action = new Actions(driver);
		action.moveToElement(element);
		element.click();
		
		Thread.sleep(10000);
	}
}
