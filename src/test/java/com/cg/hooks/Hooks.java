package com.cg.hooks;

import com.cg.page.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

	
	@Before
	public void setupTest() {
		setup();
	}
	
	@After
	public void tearDown() {
		closeBrowser();
	}
}
