package Tests;

import org.jspecify.annotations.Nullable;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;

import base.BaseTest;

public class FirstTest extends BaseTest {
	@Test
	public void navigateUrl() {
	
	      page.navigate("https://www.google.com/ncr");
	       // Optional: Handle cookie popup
	       if (page.isVisible("button:has-text('Accept all')")) {
	           page.click("button:has-text('Accept all')");
	       } 
	       System.out.println("Google NCR opened successfully...!");
	       System.out.println("Page Title: " + page.title());

	}
	

}
