package com.ui.PageObjects;


import java.util.jar.Attributes.Name;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPage {

	WebDriver ldriver;
	public static final Logger logger = LogManager.getLogger("ChannelNewsProject");

	public WeatherPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//a[@href='https://www.channelnewsasia.com/weather'])[2]")
	public WebElement weatherLink;

	public WebElement findCityWeather(String city) {

		return ldriver.findElement(By.xpath("//li[@class=\"tabular-list__view--item\"]//div[@class=\"tabular-list__view--city\"][text()='"+city+"']//following-sibling::div"));
	}

	public void clickWeatherLink() {

		((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", weatherLink);
	}

	public String getWeather(String city) {

		return findCityWeather(city).getText();
	}

}
