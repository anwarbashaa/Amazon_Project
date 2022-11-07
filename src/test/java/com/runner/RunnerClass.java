package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\FeatureFileAmazon\\com.feature", glue = "com.stepdefenition")
public class RunnerClass {

	public static WebDriver driver = null;

	@BeforeClass
	public static void setUp() throws Exception {
		
		  System.setProperty("webdriver.chrome.driver",
		 "C:\\Users\\shake\\eclipse-workspace\\AMAZON_Project\\Driver\\chromedriver.exe");
		  driver=new ChromeDriver(); driver.manage().window().maximize();
		 
		 
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
	}
}
