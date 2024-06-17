package com.cg.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cg.page.BasePage;

public class SearchPage extends BasePage {
	WebDriver localDriver;
	
	@FindBy(xpath = "//input[@id=\"search-courses\"]") public WebElement searchTxt;	
	@FindBy(xpath = "//div[@class=\"row course-list list\"]") public WebElement SearchList;
	
	public SearchPage(WebDriver Driver) {
		super();
		localDriver = Driver;
		PageFactory.initElements(Driver, this);		
	}	
	
	public void enterInputToSearchBox(String value) throws IOException {
		searchTxt.clear();
		searchTxt.sendKeys(value);		
	}
}
