package com.ui.TestCases;

import org.apache.hc.client5.http.impl.nio.MultihomeConnectionInitiator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.BaseClass.BaseClass;
import com.ui.PageObjects.HeadLinePage;
import com.ui.PageObjects.HomePage;
import com.ui.PageObjects.WeatherPage;
import com.ui.Utilities.ReadConfig;
import com.ui.Utilities.Utilities;

public class TC_HeadLine extends BaseClass {

	HomePage homePage;
	HeadLinePage headLinePage;
	WeatherPage weatherPage;
	Utilities utility;
	public static ReadConfig config;


	@BeforeMethod
	public void testSetUp() {

		homePage = new HomePage(driver);
		headLinePage = new HeadLinePage(driver);
		weatherPage = new WeatherPage(driver);
		utility = new Utilities(driver);

	}

	@Test(priority = 0, description = "Verify Headline page test")
	public void verifyHeadLine(){



		homePage.clickHeadLine();
		logger.info("HeadLine news clicked");
		homePage.verifyTitle(headLinePage.getHeadLineText(1));
		logger.info("Verified headline page title");
		utility.scrollPage();
		headLinePage.clickExpandFullStoryButton(2);
		logger.info("Expanding second news");
		homePage.verifyTitle(headLinePage.getHeadLineText(2));
		logger.info("Verified second news title");

	}

	@Test( description = "Verify Singapore weather")
	public void verifyWeather()  {

		utility.waitForElement(homePage.allSectionsMenu);
		logger.info("All sections clicked");
		homePage.clickAllSections();
		utility.waitForElement(weatherPage.weatherLink);
		weatherPage.clickWeatherLink();
		logger.info("Clicking on Weather");
		String cityWeather = weatherPage.getWeather("singapore");
		logger.info("Singapore weather is:- "+cityWeather);
		
	}

}
