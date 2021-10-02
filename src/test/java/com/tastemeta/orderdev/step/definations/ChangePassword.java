package com.tastemeta.orderdev.step.definations;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tastemeta.orderdev.util.ConfigFileReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePassword {

	@When("User Clicks on Change Password")
	public void user_clicks_on_change_password() {
		 WebElement changePasswordButton = ConfigFileReader.getCurrentWebdriver().findElement(
					By.xpath("/html/body/app-root/app-settings/section/div/div/div/div[4]/div[1]/div[2]/p"));
		 changePasswordButton.click();
	}

	@When("User Enters existing password as {string}")
	public void user_enters_existing_password_as(String string) {
		 WebElement existingPasswordText = ConfigFileReader.getCurrentWebdriver().findElement(
					By.xpath("/html/body/ngb-modal-window/div/div/div/div[2]/div/input"));
		 existingPasswordText.sendKeys(string);
	}

	@When("User Enters new password as {string} and confirm password as {string}")
	public void user_enters_new_password_as_and_confirm_password_as(String string, String string2) {
		 WebElement newPasswordText = ConfigFileReader.getCurrentWebdriver().findElement(
					By.xpath("/html/body/ngb-modal-window/div/div/div/div[3]/div/input"));
		 newPasswordText.sendKeys(string);
		 
		 WebElement confirmPasswordText = ConfigFileReader.getCurrentWebdriver().findElement(
					By.xpath("/html/body/ngb-modal-window/div/div/div/div[4]/div/input"));
		 confirmPasswordText.sendKeys(string);
	 }

	@When("User Clicks on Confirm")
	public void user_clicks_on_confirm() {
		 WebElement confirmButton = ConfigFileReader.getCurrentWebdriver().findElement(
					By.xpath("/html/body/ngb-modal-window/div/div/div/div[6]/button"));
		 confirmButton.click();
	}

	@Then("Password Changed Popup Should Appear")
	public void password_changed_popup_should_appear() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(ConfigFileReader.getCurrentWebdriver(), 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toast-container']/div")));
		WebElement errorToast = ConfigFileReader.getCurrentWebdriver().findElement(By.xpath("//*[@id='toast-container']/div"));
		assertTrue(errorToast.isDisplayed());
		Thread.sleep(2000);
	}
}
