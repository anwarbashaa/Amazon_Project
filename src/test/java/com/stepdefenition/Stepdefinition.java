package com.stepdefenition;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Project.PROJECT_NAME.XLXSReder;
import com.runner.RunnerClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {
	
	public static WebDriver driver=RunnerClass.driver;
	
	String searchvalue;
	
	@Given("user Launch The Browser")
	public void user_launch_the_browser() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
		
	@When("user Select The DropDown {string} From Excel")
	public void user_select_the_drop_down_from_excel(String dropdown) {
		WebElement allcat = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		//String expected = XLXSReder.singleData("Products", 3, 0);
		String expected=dropdown;
		Select select=new Select(allcat);
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) {

			String actual = options.get(i).getText();

			if (expected.equalsIgnoreCase(actual)) {
				select.selectByVisibleText(actual);
			}
			else {
				continue;
			}
		}
			}
	
	@When("user Send The {string} In Searchbox From Excel")
	public void user_send_the_in_searchbox_from_excel(String searchval) {
		WebElement Searchbar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]/ancestor::form/div[2]/div/input"));
		//searchvalue = XLXSReder.singleData("Products", 2, 1);
		String searchvalue=searchval;
		Searchbar.sendKeys(searchvalue);
	}
	@Then("user Click The Search Button")
	public void user_click_the_search_button() {
		WebElement click1 = driver.findElement(By.xpath("//span[@id=\"nav-search-submit-text\"]/child::input"));
		click1.click();
		
	}
	}


    



