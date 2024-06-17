package com.cg.stepdef;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.cg.page.BasePage;
import com.cg.pages.LoginPage;
import com.cg.pages.ProfilePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps extends BasePage {
	
    ProfilePage pp = new ProfilePage(driver);
	LoginPage lp = new LoginPage(driver);
	
	@Then("Profile name with label {string} on profile page")
	public void profile_name_with_label_on_profile_page(String value) throws IOException {
		assertEquals(getTextFromElement(pp.btnProfileName).trim(), value);
	}	
	
	@When("User clicks on profile name")
	public void user_clicks_on_profile_name() {
		pp.lblProfileNameClick();
	}	

	@Then("User verifies profile pop up list")
	public void user_verifies_profile_pop_up_list(io.cucumber.datatable.DataTable dataTable) {
	     int i =0;
	     for (Map<String,String> data :dataTable.asMaps(String.class,String.class)) {
	    	 assertEquals(getTextFromElement(pp.listOfProfile.get(i)),data.get("list"));
	    	 i++;
	     }
	}	
}
