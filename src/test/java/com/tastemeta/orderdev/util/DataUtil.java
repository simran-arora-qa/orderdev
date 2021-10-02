package com.tastemeta.orderdev.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataUtil {

	public static void main(String[] args) {
		ConfigFileReader configFileReader = new ConfigFileReader();
		System.out.println(configFileReader.getCurrentWebdriver());
		System.getProperty("webdriver.chrome.driver");
		WebDriver driver = new ChromeDriver();
		driver.get("google.com");
	}
}
