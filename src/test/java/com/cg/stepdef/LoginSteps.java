package com.cg.stepdef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import com.cg.page.BasePage;
import com.cg.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class LoginSteps extends BasePage {
	
	LoginPage lp = new LoginPage(driver);	

	@When("User enters username {string}")
	public void user_enters_username(String username) throws InterruptedException, IOException {
		lp.setUserName(username);
	    
	}

	@Then("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		lp.clickLogin();
		lp.sleep(5);
		assertEquals(getTextFromElement(lp.invalidLogginLbl).trim(), "Your email or password is incorrect.");
	}
	
	@When("User checks error messages at email")
	public void user_checks_error_messages_at_email(DataTable dataTable) {
	    for(Map<String, String> data : dataTable.asMaps()) {
	    	lp.setUserName(data.get("Email"));	    	
	    	lp.lblEmailClick();
	    	assertEquals(getTextFromElement(lp.emailError).trim(), data.get("Message").trim());
	    }
	}
	
	@When("User verifies logo text {string} on login page")
	public void user_verifies_logo_text_on_login_page(String string) {
	    
	}
	
	@When("User verifies lbl {string} on login page")
	public void user_verifies_lbl_on_login_page(String value) throws InterruptedException {	
		assertEquals(getTextFromElement(lp.lblLogin).trim(), value);
//		int i;
//		String[] labels = new String[50];
//	    for(i =0;i<=6;i++) {	    	
//    		labels[i] = value;   
//    		System.out.println(lp.getTextFromElement(lp.lblLogin).trim());
//    		System.out.println("****************"+labels[i]);
//    		Thread.sleep(3000);
//    		
//    		if(labels[i]==lp.getTextFromElement(lp.lblLogin)) {
//    			System.out.println("A");
//				
//	    	} //else if(value==lp.getTextFromElement(lp.lblEmail)) {
//	    		System.out.println("value from array** "+value);
//				System.out.println("value from ele** "+lp.getTextFromElement(lp.lblEmail));
//	    		Assert.assertFalse(true);  
//	    	} else if(value==lp.getTextFromElement(lp.lblPassword)) {
//	    		System.out.println("value from array*** "+value);
//				System.out.println("value from ele*** "+lp.getTextFromElement(lp.lblPassword));
//	    		Assert.assertFalse(true);
//	    	} else if(value==lp.getTextFromElement(lp.lblRememberMe)) {
//	    		Assert.assertFalse(true);
//	    	} else if(value==lp.getTextFromElement(lp.lblForgotPwd)) {
//	    		Assert.assertFalse(true);
//	    	} else if(value == lp.getTextFromElement(lp.needAnAccount)) {
//	    		Assert.assertFalse(true);
//	    	} else if(value==lp.getTextFromElement(lp.signUp)) {
//	    		Assert.assertFalse(true);
	    	//} 
	}	 	    
	
	@When("Logo label {string} on login page")
	public void logo_label_on_login_page(String value) {
		assertEquals(lp.loginpage_logo.getAttribute("alt"), value);
	}

	@When("Login with label {string} on login page")
	public void login_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.lblLogin).trim(), value);
	}

	@When("Email with label {string} on login page")
	public void email_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.lblEmail).trim(), value);
	}

	@When("Password with label {string} on login page")
	public void password_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.lblPassword).trim(), value);
	}

	@When("Remember me with label {string} on login page")
	public void remember_me_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.lblRememberMe).trim(), value);
	}

	@When("Forgot password with label {string} on login page")
	public void forgot_password_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.lblForgotPwd).trim(), value);
	}

	@When("Need an account with label {string} on login page")
	public void need_an_account_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.needAnAccount).trim(), value);
	}

	@When("Sign up with label {string} on login page")
	public void sign_up_with_label_on_login_page(String value) {
		assertEquals(getTextFromElement(lp.signUp).trim(), value);
	}
	
	@Then("User closed browser")
	@After
	public void logout_from_application() {
		lp.closeBrowser();
	}
}
