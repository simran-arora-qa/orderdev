package com.tastemeta.orderdev.step.definations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tastemeta.orderdev.util.ConfigFileReader;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BaseDefination {
	
	public static final String signInURL = "https://orderdev.tastemeta.com/auth/signin";

	@After
	public void teardown() throws InterruptedException {
		System.out.println("Close browser");
		Thread.sleep(2000);
		ConfigFileReader.getCurrentWebdriver().quit();
	}

	@Given("User Navigates to orderdevURL on {string}")
	public void user_navigates_to_orderdev_url_on(String string) throws InterruptedException {
		ConfigFileReader.loadBrowserSpecificDriver(string);
		WebDriver driver = ConfigFileReader.getCurrentWebdriver();
		driver.get(ConfigFileReader.getApplicationUrl());
		driver.manage().window().maximize();
		Thread.sleep(2000);
		assertEquals(ConfigFileReader.getApplicationUrl(), driver.getCurrentUrl());
	}

	@Given("^User Navigates to orderdevURL$")
	public void user_Navigates_to() throws Throwable {
		//WebDriver driver = ConfigFileReader.getCurrentWebdriver();
		//driver.get(ConfigFileReader.getApplicationUrl());
		Thread.sleep(2000);
		assertEquals(ConfigFileReader.getApplicationUrl(), ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}

	@Given("^Clicks on Login$")
	public void clicks_on_Login() throws Throwable {
		Thread.sleep(2000);
		WebElement loginButton = ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("/html/body/app-root/app-home/section/div/app-sidebar/div[1]/div/div[2]/div[1]/div[2]/p"));
		loginButton.click();
	}

	@And("^Login Screen Should Appear$")
	public void login_Screen_Should_Appear() throws Throwable {
		Thread.sleep(2000);
		assertEquals(signInURL, ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}
	
	@Then("User should be navigated to orderdevURL")
	public void user_should_be_navigated_to_orderdev_url() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(ConfigFileReader.getApplicationUrl(), ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}
	@Then("User Closes Delivery Popup")
	public void user_closes_delivery_popup() {
		WebElement deliveryPopupCloseButton = ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("/html/body/ngb-modal-window/div/div/app-initial-address/div/div[1]/button"));
		deliveryPopupCloseButton.click();
	}

	@Then("User Clicks Logout")
	public void user_clicks_logout() throws InterruptedException {
		Thread.sleep(2000);
		WebElement logoutButton = ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("/html/body/app-root/*/section/div/app-sidebar/div[1]/div/div[2]/div[1]/div[2]/p"));
		logoutButton.click();
	
	}
	
	@When("User Clicks on Settings")
	public void user_clicks_on_settings() {
	    WebElement settingButton = ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("/html/body/app-root/app-home/section/div/app-sidebar/div[1]/div/ul/li[7]/a"));
	    settingButton.click();
	    
	}
}
