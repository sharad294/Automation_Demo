package com.cg.stepdef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.cg.page.BasePage;
import com.cg.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BasePage {
	
	LoginPage lp = new LoginPage(driver);
	
	@Given("User navigates to sigin page")
	public void user_navigates_to_sigin_page() {
		lp.setup();
	}

	@When("User logins to application")
	public void user_logins_to_application() throws IOException {
		lp.login();	
	}

	@When("^User is on dashboard page$")
	public void user_is_on_dashboard_page() {
	  assertEquals(getTitle().trim(), "Rahul Shetty Academy");
	}
	
	@Then("User zooms page")
	public void user_zooms_page() throws Exception {
	    lp.ZoomIn();
	}
	
	@Then("User zoom outs page")
	public void user_zoom_outs_page() throws Exception {		
		lp.ZoomOut();		
	}
}
