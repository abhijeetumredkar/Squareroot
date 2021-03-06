package com.ui.BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.ui.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger("ChannelNewsProject");
	public static ReadConfig config = new ReadConfig();
	public static final String USERNAME = "YOUR_USERNAME";
	public static final String APIKEY = "YOUR_ACCESS_KEY";
	public static final String URL = "https://" + USERNAME + ":" + APIKEY + "@hub-cloud.browserstack.com/wd/hub";

	@Parameters("platform")
	@BeforeMethod
	public void setUp(String platform) throws Throwable {

		if(platform.equalsIgnoreCase("desktop")){

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (platform.equalsIgnoreCase("mobile")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browserName", "Android");
			caps.setCapability("device", "Samsung Galaxy S21");
			caps.setCapability("realMobile", "true");
			caps.setCapability("os_version", "11.0");
			driver = new RemoteWebDriver(new URL(URL), caps);
		}

		else if(platform.equalsIgnoreCase("tablet")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browserName", "Android");
			caps.setCapability("device", "Samsung Galaxy S21 Ultra");
			caps.setCapability("realMobile", "true");
			caps.setCapability("os_version", "11.0");
			driver = new RemoteWebDriver(new URL(URL), caps);

		}

		logger.info("Launching Chrome Browser");
		driver.manage().window().maximize();
		logger.info("Brower window Maximize");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod(dependsOnMethods = "setUp")
	public void launchUrl() {

		driver.get(config.getURL());

	}

}
