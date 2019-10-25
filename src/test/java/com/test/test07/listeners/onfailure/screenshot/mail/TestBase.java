package com.test.test07.listeners.onfailure.screenshot.mail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static WebDriver driver;

    public WebDriver getDriver(String browser) {

	if (browser.equals("chrome")) {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	} else if (browser.equals("firefox")) {
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	} else if (browser.equals("ie")) {
	    WebDriverManager.iedriver().setup();
	    driver = new InternetExplorerDriver();
	} else if (browser.equals("edge")) {
	    WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	} else if (browser.equals("opera")) {
	    WebDriverManager.operadriver().setup();

	    OperaOptions options = new OperaOptions();
	    options.setBinary(
	            "C:\\Users\\yulia\\AppData\\Local\\Programs\\Opera\\60.0.3255.170\\opera.exe");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(OperaOptions.CAPABILITY, options);

	    driver = new OperaDriver(capabilities);
	} else {
	    throw new RuntimeException("Unknown browser: " + browser);
	}
	return driver;
    }

    @BeforeSuite
    public void setUp() {
	System.out.println("Initializing everything");
	if(driver==null) {
	    driver = getDriver("chrome");
	    driver.get("http://gmail.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	    System.out.println(driver.getTitle());
	}
	
    }

    @AfterSuite
    public void tearDown() {
	System.out.println("Quitting everything");
	driver.quit();
    }

}
