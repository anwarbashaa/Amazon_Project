package com.Project.PROJECT_NAME;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon 
{

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shake\\eclipse-workspace\\Amazon.com\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement allcat = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		String expected = XLXSReder.singleData("Products", 3, 0);
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

			WebElement Searchbar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]/ancestor::form/div[2]/div/input"));
			String searchvalue = XLXSReder.singleData("Products", 2, 1);

			Searchbar.sendKeys(searchvalue);
		}

		WebElement click1 = driver.findElement(By.xpath("//span[@id=\"nav-search-submit-text\"]/child::input"));
		click1.click();

	}


}

