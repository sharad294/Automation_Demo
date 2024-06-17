package com.cg.page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import static utils.ConfigReader.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;

import com.cg.customexc.BrowserNotSupported;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static Logger logger;
	public static WebDriver driver;
	Properties prop;
	String bname, Title;
	

	public void setup()  {
		WebDriverManager.chromedriver().setup();
		//logger = Logger.getLogger("");
		prop = new Properties();		

		try {
			prop.load(new FileInputStream("Config/Config.properties"));
			bname = prop.getProperty("browser");
			if (bname.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver",
				//		"C:\\Users\\SHJAGATA\\eclipse-workspace\\Automation_Demo\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (bname.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\SHJAGATA\\eclipse-workspace\\Automation_Demo\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				throw new BrowserNotSupported(bname + "browser is not supported!!!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BrowserNotSupported e) {
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		try {
			//driver.manage().timeouts().pageLoadTimeout(Long.parseLong(getPageLoadTimeOut()), TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(Long.parseLong(getPageLoadTimeOut()), TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(Long.parseLong(getImplicitWait()), TimeUnit.SECONDS);
			driver.get(getUrl());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String randomNum(int size) {
		String generatedString1 = RandomStringUtils.randomNumeric(size);
		return generatedString1;
	}
	
//	public void setValue(WebElement element, String value) {
//		waitForElementFullyLoaded(element, 30, 1);
//		try {
//			element.click();
//		}catch (Exception e){
//			e.printStackTrace();			
//		}
//		element.clear();
//		element.sendKeys(value);
//	}
	
	public boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean waitForElementFullyLoaded(WebElement element, Duration timeOut, int pollingEverysecond) {
		try {
			FluentWait<WebDriver> wait = new WebDriverWait(driver,timeOut).pollingEvery(Duration.ofSeconds(pollingEverysecond));
			boolean t1 = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
					wait.until(ExpectedConditions.elementToBeClickable(element));
			if(t1) {
				return true;
			}
			
		}catch(Exception e) {
			logger.error("Element Not Found: "+ element);
		}
		return false;		
	}

	public void closeBrowser() {		
		driver.close();		
		driver.quit();
	}		
	
	public String getTitle() {
		Title = driver.getTitle();	
		return Title;
	}
	
	public void doubleClickToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
//	public void searchValueWithEnter(WebElement element, String value) {
//		setValue(element, value);
//		element.sendKeys(Keys.ENTER);
//	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public List<String> getTextFromList(List<WebElement> elements) {
		List<String> stringList = new ArrayList<String>();
		for(WebElement element : elements) {
			stringList.add(element.getText().trim());
		}
		return stringList;		
	}	
	
	public String getTextFromElement(WebElement elements) {
		return elements.getText();
	}
	
	public void sleep(int seconds) {		
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		sleep(1);
	}
	
	public void scrollPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-2000)");
	}
	
	public void hoverOnAnyElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}	
	
	public void pressEscapeKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}
	
	public void pressEnterKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void pageDown() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		sleep(1);
	}
	
	public void pageUp() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		sleep(1);
	}
	
	public void ZoomOut() throws Exception {
		Robot robot = new Robot();
		for(int i = 0;i<4;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}		
	}
	
	public void ZoomIn() throws Exception {
		Robot robot = new Robot();
		for(int i = 0;i<4;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}		
	}
}
