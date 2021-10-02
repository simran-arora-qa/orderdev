package com.tastemeta.orderdev.step.definations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tastemeta.orderdev.util.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	public static final String signInURL = "https://orderdev.tastemeta.com/auth/signin";
	public static String currentLoggedInUserName = null;
	
	
	@Given("^User is on Login Screen$")
	public void user_is_on_Login_Screen() throws Throwable {
		Thread.sleep(2000);
		assertEquals("https://orderdev.tastemeta.com/auth/signin", ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}

	@When("^Clicks on Sign in Button$")
	public void clicks_on_Sign_in_Button() throws Throwable {
		WebElement signInButton = ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-sign/section/div/div[2]/div/div/form/div[3]/button[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) ConfigFileReader.getCurrentWebdriver();
		jse.executeScript("arguments[0].click();", signInButton);
	}

	@Then("^An error pop-up should apper with message \"([^\"]*)\"$")
	public void an_error_pop_up_should_apper_with_message(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(ConfigFileReader.getCurrentWebdriver(), 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toast-container']/div")));
		WebElement errorToast = ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("//*[@id='toast-container']/div"));
		assertTrue(errorToast.isDisplayed());
		assertTrue("Error message does not match",errorToast.getText().contains(arg1));
	}
	
	@Then("^User should not be able to login$")
	public void user_should_not_be_able_to_login() throws Throwable {
		assertEquals(signInURL, ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}
	
	@When("^User Enters user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_Enters_user_name_as_and_password_as(String arg1, String arg2) throws Throwable {
		WebElement emailText=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-sign/section/div/div[2]/div/div/form/div[1]/div[2]/div/input"));
		if(currentLoggedInUserName==null) {
			currentLoggedInUserName=arg1;
		}
		emailText.sendKeys(currentLoggedInUserName);
		WebElement passwordText=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-sign/section/div/div[2]/div/div/form/div[2]/div[2]/div/input"));
		passwordText.sendKeys(arg2);
	}

	@Then("^User should be navigate to \"([^\"]*)\"$")
	public void user_should_be_navigate_to(String arg1) throws Throwable {
		Thread.sleep(2000);
		assertEquals(arg1, ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}


}
