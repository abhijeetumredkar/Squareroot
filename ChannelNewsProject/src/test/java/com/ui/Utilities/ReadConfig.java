package com.ui.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream file = new FileInputStream(src);
			prop = new Properties();
			prop.load(file);
		}catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getURL() {

		return prop.getProperty("url");
	}

	public String getHomePageTitle() {

		return prop.getProperty("homePageTitle");

	}

	public String getHeadLineTitle() {

		return prop.getProperty("headLinePageTitle");

	}
}
