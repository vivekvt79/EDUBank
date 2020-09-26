package com.EDUbank.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class VerifyLoginTest {
	WebDriver driver;
	String firefoxDriverPath = "D:\\Automation\\Selenium Files n Downloads\\Drivers\\geckodriver-v0.27.0-win64\\";
	String autUrl = "http://10.82.180.36:8080/EDUBank/tellerLogin";

	@Test
	public void test() {
		driver.findElement(By.id("tellerId")).sendKeys("T7302");
		driver.findElement(By.id("password")).sendKeys("T7302*abc");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		if (driver.findElement(By.linkText("Logout")).isDisplayed()) {
			System.out.println("Login success");
		} else
			System.out.println("Login failed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath + "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(autUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
