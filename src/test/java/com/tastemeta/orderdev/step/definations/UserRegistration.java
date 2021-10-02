package com.tastemeta.orderdev.step.definations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tastemeta.orderdev.util.ConfigFileReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration {

	public static final String accountCreationURL = "https://orderdev.tastemeta.com/auth/signup";
	
	
	@Then("User Clicks on Create an Account")
	public void user_clicks_on_create_an_account() {

		WebElement loginButton = ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("/html/body/app-root/app-sign/section/div/div[2]/div/div/form/div[3]/button[2]"));
		loginButton.click();
	}

	@And("User Account Creation Screen Should Appear")
	public void user_account_creation_screen_should_appear() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(accountCreationURL, ConfigFileReader.getCurrentWebdriver().getCurrentUrl());
	}

	@When("User selects {string} from Phone number Region drop down")
	public void user_selects_from_phone_number_region_drop_down(String string) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) ConfigFileReader.getCurrentWebdriver();
		WebElement phoneDropDown=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("//div[contains(@role, 'combobox')]"));
		jse.executeScript("arguments[0].click();", phoneDropDown);
		WebElement phoneDropDownToBeSelected=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("//li[contains(@data-country-code, 'in')]"));
		jse.executeScript("arguments[0].click();", phoneDropDownToBeSelected);
	}

	@When("User Enters user name as {string} and last name as {string}")
	public void user_enters_user_name_as_and_last_name_as(String string, String string2) {
		WebElement firstName=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[1]/div[2]/div/input"));
		if(Login.currentLoggedInUserName==null) {
			Login.currentLoggedInUserName=string;
		}
		firstName.sendKeys(Login.currentLoggedInUserName);
		WebElement lastName=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[2]/div[2]/div/input"));
		lastName.sendKeys(string2);
	}

	@When("User enters phone number as {string}")
	public void user_enters_phone_number_as(String string) {
		WebElement phoneNumberInput=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[3]/div[2]/div/div/input"));
		phoneNumberInput.sendKeys(string);
	}

	@When("User enters email address as {string}")
	public void user_enters_email_address_as(String string) {
		WebElement emailInput=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[4]/div[2]/div/input"));
		String email = string;
		email=email.replace("random", String.valueOf(Math.random()));
		emailInput.sendKeys(email);
		Login.currentLoggedInUserName = email;
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String string) {
		WebElement password=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[5]/div[2]/div/input"));
		password.sendKeys(string);
	}

	@When("User enters referrel code as {string}")
	public void user_enters_referrel_code_as(String string) {
		WebElement referralCode=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[6]/div[2]/div/input"));
		referralCode.sendKeys(string);
	}

	@When("User checks Agree to META terms checkbox")
	public void user_checks_agree_to_meta_terms_checkbox() throws InterruptedException {
		WebElement metaCheckBok=ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[8]/label/input"));
		JavascriptExecutor jse = (JavascriptExecutor) ConfigFileReader.getCurrentWebdriver();
		jse.executeScript("arguments[0].click();", metaCheckBok);
	}

	@When("Clicks on Create an Account Button")
	public void clicks_on_create_an_account_button() {
		WebElement createAccountButton = ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("/html/body/app-root/app-signup/section/div/div[2]/div/div[2]/form/div[12]/button"));
		JavascriptExecutor jse = (JavascriptExecutor) ConfigFileReader.getCurrentWebdriver();
		jse.executeScript("arguments[0].click();", createAccountButton);
	}

	@Then("Delivery Address pop up should appear")
	public void delivery_address_pop_up_should_appear() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue("Delivery Address pop up did not appear",ConfigFileReader.getCurrentWebdriver().findElement(
				By.xpath("//button[@class='btn btn-confirm']")).isDisplayed());
	}

}
