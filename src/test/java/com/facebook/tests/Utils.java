package com.facebook.tests;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static void takeScreenshot(WebDriver driver, String path)
			throws IOException {
		File output = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(output, new File(path));
	}

	public static boolean elementExists(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void explicitWait(WebDriver driver, String elementtype,
			String element, String path) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (elementtype == "cssSelector") {
				wait.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector(element))).click();
			}
		} catch (Exception e) {

		}
	}
	
	public static void hover(WebDriver driver, WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
}
