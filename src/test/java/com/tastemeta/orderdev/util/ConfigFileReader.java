package com.tastemeta.orderdev.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ConfigFileReader {	
	private static Properties properties;
	private final String propertyFilePath= "src/test/resources/configs/Configuration.properties";
	
	static {
		new ConfigFileReader();
	}
	public ConfigFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try { properties.load(reader);
			}
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		}		
	}
	
	private static WebDriver webDriver;
	public static WebDriver getCurrentWebdriver() {
		if(webDriver==null) {
			synchronized (ConfigFileReader.class) {
				 webDriver = getBrowser();
			}
		}
		return webDriver;
	}
	
	public static String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	private static WebDriver getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.chrome.driver"));
			return new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",properties.getProperty("webdriver.gecko.driver"));
			return new FirefoxDriver();
		}
		else if(browserName.equals("internetExplorer")) {
			System.setProperty("webdriver.ie.driver",properties.getProperty("webdriver.ie.driver"));
			return new InternetExplorerDriver();
		}
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	
	public static String getTestDataResourcePath(){
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
	}

	public static void loadBrowserSpecificDriver(String browserName) {
		webDriver=null;
		properties.setProperty("browser", browserName);
	}

}
