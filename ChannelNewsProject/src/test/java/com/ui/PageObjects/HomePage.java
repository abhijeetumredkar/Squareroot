package com.ui.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HomePage {

	WebDriver ldriver;
	public static final Logger logger = LogManager.getLogger("ChannelNewsProject");
	SoftAssert softassert = new SoftAssert();

	public HomePage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//h1[@class='feature-card__heading feature-card__heading-- h1']//a")
	private WebElement headlineItem;

	@FindBy(xpath = "//li[@class='main-menu__item is-hide-link']//span[contains(text(),'All Sections')]")
	public WebElement allSectionsMenu;

	public void clickHeadLine() {

		logger.info("Clicking Headline:--> "+ headlineItem.getText());
		headlineItem.click();
	
	}

		
	public void verifyTitle(String expectedTitle) {
		
		
		String title = ldriver.getTitle();
		String[] trimTitle = title.split("-");
		String actualTitle="";
		
		for(int i=0; i < 1; i++) {
			
			actualTitle = trimTitle[i];
		}
	
		softassert.assertEquals(actualTitle.trim(), expectedTitle);
		softassert.assertAll();
		
	}
	
	public void clickAllSections() {

		allSectionsMenu.click();

	}
	
	

}
