package com.cg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.page.BasePage;

public class ProfilePage extends BasePage {
	WebDriver localDriver;
	
	@FindBy(xpath = "//span[@class='navbar-current-user']") public WebElement btnProfileName;
	@FindBy(xpath = "//a[contains(text(),'Home')]") public WebElement lblHome;
	@FindBy(xpath = "(//ul[@class='dropdown-menu'])[1]//li") public List<WebElement> listOfProfile;

	
	
	public ProfilePage(WebDriver Driver) {
		super();
		localDriver = Driver;
		PageFactory.initElements(Driver, this);		
	}	
	
	public void lblProfileNameClick() {
		btnProfileName.click();
	}
}
