package com.cg.pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.ConfigReader.*;


import com.cg.page.BasePage;

public class LoginPage extends BasePage {
	WebDriver localDriver;

	@FindBy(xpath= "//input[@name='email']") public WebElement txtUsrNme;
	
	@FindBy(xpath = "//input[@name='password']") public	WebElement txtPass;
	
	@FindBy(xpath = "//input[@name='commit']") public WebElement btnLogin;
	@FindBy(xpath = "//div[@class='inline-error']") public WebElement emailError;
	@FindBy(xpath = "//label[@for=\"email\"]") public WebElement lblEmail;
	@FindBy(xpath = "//label[@for=\"password\"]") public WebElement lblPassword;
	@FindBy(xpath = "//label[@for=\"remember_me\"]") public WebElement lblRememberMe;
	@FindBy(xpath = "//a[@class=\"bodySmall form-footer\"]") public WebElement lblForgotPwd;
	@FindBy(xpath = "//div[@class=\"bodyMain text-center-xs m-b-5-xs\"]") public WebElement needAnAccount;
	@FindBy(xpath = "//div[@class=\"bodyMain text-center-xs m-b-5-xs\"]//a") public WebElement signUp;
	@FindBy(css = ".bodySmall.text-center-xs") public WebElement invalidLogginLbl;
	@FindBy(xpath="//footer[@class='text-center-xs']") public WebElement loginpage_logo;
	@FindBy(xpath="//h3[@class=\"heading3 text-center-xs\"]") public WebElement lblLogin;
	
	public LoginPage(WebDriver Driver) {
		super();
		localDriver = Driver;
		PageFactory.initElements(Driver, this);
	}	
	
	public void getLogoTxt() {
		 String loginpage_title=loginpage_logo.getAttribute("alt");
	}	
	
	public void lblEmailClick() {
		lblEmail.click();
	}
	
	public void setUserName(String unm) {
		txtUsrNme.clear();
		txtUsrNme.sendKeys(unm);
	}
	
	public void setPassword(String pwd) {
		txtPass.clear();
		
		txtPass.sendKeys(pwd);
	}
	
	public void login() throws IOException {
		txtUsrNme.clear();
		txtUsrNme.sendKeys(getUserName());
		txtPass.clear();
		txtPass.sendKeys(getPassword());
		btnLogin.click();
	}
	
//	public void login() {
//		setValue(txtUsrNme, prop.getProperty("userName"));
//		setValue(txtPass, prop.getProperty("password"));
//	}
	
	public void clickLogin() {
		btnLogin.click();
	}	
}
