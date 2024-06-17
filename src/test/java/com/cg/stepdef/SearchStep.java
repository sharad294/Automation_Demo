package com.cg.stepdef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;

import com.cg.page.BasePage;
import com.cg.pages.SearchPage;

import io.cucumber.java.en.When;

public class SearchStep extends BasePage {
	
	SearchPage sp = new SearchPage(driver);
	
	@When("User checks error messages at search")
	public void user_checks_error_messages_at_search(io.cucumber.datatable.DataTable dataTable) throws IOException {
		for(Map<String, String> data : dataTable.asMaps()) {
			sp.enterInputToSearchBox(data.get("Input"));	
			sp.pressEnterKey();
			sp.sleep(3);				
			 assertEquals(isElementPresent(sp.SearchList), false);					
	    }
	}
	
	@When("User searches valid courses")
	public void user_searches_valid_courses(io.cucumber.datatable.DataTable dataTable) throws IOException {
		for(Map<String, String> data : dataTable.asMaps()) {
			sp.enterInputToSearchBox(data.get("Input"));	
			sp.pressEnterKey();
			sp.sleep(3);				
			 assertEquals(isElementPresent(sp.SearchList), true);					
	    }
	}	
}
