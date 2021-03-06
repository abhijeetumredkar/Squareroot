package com.ui.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadLinePage {

	WebDriver ldriver;
	public static final Logger logger = LogManager.getLogger("ChannelNewsProject");

	public HeadLinePage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@class='article__read-full-story-button-wrapper']//a[contains(text(),'Expand to read the full story')]")
	public List<WebElement> myelement;

	//@FindBy(xpath = "//h1[@class='h1 h1--page-title']")
	//	public WebElement headLine;

	public WebElement headLine(int num) {

		return ldriver.findElement(By.xpath("(//h1[@class='h1 h1--page-title'])["+num+"]"));
	}

	public void clickExpandFullStoryButton(int news) {
		news = news - 1;
		for(int i = news; i <= news; i++) {

			myelement.get(i).click();


		}

	}

	public String getHeadLineText(int num) {

		return	headLine(num).getText();

	}
}
