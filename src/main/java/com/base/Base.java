package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.util.OsUtil;
import com.util.TestUtil;
import com.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Xls_Reader reader;
	
/*###############################################################################*/
/************overloaded initialize()***********/

	public void initialize() {
		// set up properties file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// set up browser
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			if (OsUtil.isWindows()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			} else if (OsUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver_mac");
			} else if (OsUtil.isUnix()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver_linux");
			}

			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {

			if (OsUtil.isWindows()) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			} else if (OsUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver_mac");
			} else if (OsUtil.isUnix()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver_linux");
			}

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

		Reporter.log("Application is set up successfully");
	}

	public void initialize(String webUrl) {

		// get browserName from properties file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// set up browser
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			if (OsUtil.isWindows()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			} else if (OsUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver_mac");
			} else if (OsUtil.isUnix()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver_linux");
			}

			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {

			if (OsUtil.isWindows()) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			} else if (OsUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver_mac");
			} else if (OsUtil.isUnix()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver_linux");
			}

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(webUrl);
	}

	public void initialize(String webUrl, String browserName) {

		// set up browser
		if (browserName.equals("chrome")) {
			if (OsUtil.isWindows()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			} else if (OsUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver_mac");
			} else if (OsUtil.isUnix()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver_linux");
			}

			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {

			if (OsUtil.isWindows()) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			} else if (OsUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver_mac");
			} else if (OsUtil.isUnix()) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver_linux");
			}

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(webUrl);
	}
	
	/*###############################################################################*/
	/************overloaded setWebDriverManager()***********/

	public WebDriver setWebDriverManager(String browser) {

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
			options.setBinary("C:\\Users\\yulia\\AppData\\Local\\Programs\\Opera\\60.0.3255.170\\opera.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(OperaOptions.CAPABILITY, options);

			driver = new OperaDriver(capabilities);
		} else {
			throw new RuntimeException("Unknown browser: " + browser);
		}
		return driver;
	}

	public void setWebDriverManager(String browser, String url) {

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
			options.setBinary("C:\\Users\\yulia\\AppData\\Local\\Programs\\Opera\\60.0.3255.170\\opera.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(OperaOptions.CAPABILITY, options);

			driver = new OperaDriver(capabilities);
		} else {
			throw new RuntimeException("Unknown browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(url);
		Reporter.log("Application is set up successfully");
	}

	public void setUpXcelReader(String xcelUrl) throws IOException {
		// set up xcel file

		String fileUrl = System.getProperty("user.dir") + xcelUrl;

		File xcelFile = new File(fileUrl);
		if (!xcelFile.createNewFile()) {
			System.out.println("\n++++++++++\n" + "xcelFile already exists" + "\n++++++++++\n");
		} else {
			System.out.println("\n++++++++++\n" + "New xcelFile created" + "\n++++++++++\n");
			// solve this: org.apache.poi.EmptyFileException: The supplied file was empty
			// (zero bytes long)
		}

		// set up xcel Reader
		reader = new Xls_Reader(fileUrl);
	}

	public void killBrowser() {
		if (driver != null) {
			driver.quit();
		}
		Reporter.log("Browser Session End");
	}
}