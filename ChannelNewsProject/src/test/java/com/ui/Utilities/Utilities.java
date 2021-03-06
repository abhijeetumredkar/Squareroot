package com.ui.Utilities;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.ui.PageObjects.HeadLinePage;

public class Utilities {

	public static WebDriver ldriver;
	public static final Logger logger = LogManager.getLogger("ChannelNewsProject");
	public static SoftAssert softassert = new SoftAssert();


	public Utilities(WebDriver rdriver) {

		ldriver = rdriver;
	}


	public void verifyTitle(String expectedTitle) {

		String actualTitle = ldriver.getTitle();
		softassert.assertEquals(actualTitle, expectedTitle,"Mismatch is Page Title");
		softassert.assertAll();

	}

	public void scrollPage(){

		long longScrollHeight = (Long) ((JavascriptExecutor) ldriver).executeScript("return Math.max("
				+ "document.body.scrollHeight, document.documentElement.scrollHeight,"
				+ "document.body.offsetHeight, document.documentElement.offsetHeight,"
				+ "document.body.clientHeight, document.documentElement.clientHeight);"
				);
		((JavascriptExecutor) ldriver).executeScript("window.scrollTo(0, " + longScrollHeight + ");");
		((JavascriptExecutor) ldriver).executeScript("window.scrollBy(0,-500)");
		ldriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		((JavascriptExecutor) ldriver).executeScript("window.scrollBy(0,500)");
		ldriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	public void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
