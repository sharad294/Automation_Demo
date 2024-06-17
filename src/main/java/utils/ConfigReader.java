package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigReader {

	public static Properties getPropertyObject() throws IOException {
		FileInputStream fp = new FileInputStream("Config/Config.properties");
		Properties prop = new Properties();
		prop.load(fp);
		return prop;
	}
	
	public static String getBrowser() throws IOException {
		return getPropertyObject().getProperty("browser");
	}
	
	public static String getUrl() throws IOException {
		return getPropertyObject().getProperty("url");
	}
	
	public static String getUserName() throws IOException {
		return getPropertyObject().getProperty("username");
	}
	
	public static String getPassword() throws IOException {
		return getPropertyObject().getProperty("password");
	}
	
	public static String getPageLoadTimeOut() throws IOException {
		return getPropertyObject().getProperty("Page_Load_Time_Out");
	}
	
	public static String getImplicitWait() throws IOException {
		return getPropertyObject().getProperty("Implicit_Wait");
	}
}
