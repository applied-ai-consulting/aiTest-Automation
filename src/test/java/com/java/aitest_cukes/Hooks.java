/* 
* File Name: Hooks.java
* Copyright 2015, Opex Software
* Apache License, Version 2.0
* This file contains the setup and teardown methods, browser initializations and screenshot functionality
*/

package com.java.aitest_cukes;

import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.Assertion;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;
	public String browser;
	

	// Contains declaration of all browsers (FF, Chrome, IE, Opera, Android)
	// This method is a hook which runs before every test
	@Before
	public void beforeEach() throws IOException, URISyntaxException {
		browser = System.getenv("BROWSER");
		
		System.out.println("Browser selected is " + browser);
		if (browser == null) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();	        
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			//chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1400,600");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
//			WebDriverManager.firefoxdriver().proxy("server:port").setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--no-sandbox");
			firefoxOptions.addArguments("--disable-dev-shm-usage");
//			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("--window-size=1400,600");
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("ChromeHeadless")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1400,600");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("FirefoxHeadless")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--no-sandbox");
			firefoxOptions.addArguments("--disable-dev-shm-usage");
			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("--window-size=1400,600");
			
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			 
	        // Create an object of Edge Options class
			EdgeOptions options = new EdgeOptions();
	 
	        // pass the argument –headless to Edge Options class.
	        
			options.setCapability("headless", true);
			options.setCapability("--no-sandbox", true);
			options.setCapability("--disable-dev-shm-usage", true);
			options.setCapability("--window-size=1400,600", true);
	 
	        // Create an object of WebDriver class and pass the Edge Options object as
	        // an argument
			driver = new EdgeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method kills the browser after the test is over
	// It also takes a screenshot and embeds it in the report if the test fails
	// This method is a hook which runs after every test
	@After
	public void afterEach(Scenario scenario) {
		String status = scenario.getStatus();
		System.out.println("scenario status:"+status);
		if (scenario.isFailed()) {
			
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());

				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
		}
		else if(status.equals("passed"))
		{
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				scenario.write("test case is pass successfuly  Screenshot is attached below");
				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
			
		driver.quit();

	}
	}

}