package base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ExtentManager;
import utils.ScreenshotsUtils;

public class BaseTest { protected Playwright playwright;
protected Browser browser;
protected BrowserContext browserContext;
public Page page;
protected ExtentReports extent;
protected ExtentTest test;

@BeforeMethod
public void launchBrowser(Method method ) {

	// Extent Reporting 

	extent = ExtentManager.getInstance();
	test = extent.createTest(method.getName());

	playwright = Playwright.create();

	browser = playwright.chromium().launch(
			new BrowserType.LaunchOptions()
			.setHeadless(false)
			);

	browserContext = browser.newContext();

	page = browserContext.newPage();

	page.navigate("https://www.google.com");

	System.out.println("Browser launched successfully!");
}

@AfterMethod
public void teardownBrowser(ITestResult result) {

	// Reporting logic 
	if(result.getStatus()==ITestResult.FAILURE)
	{
		  test.fail(result.getThrowable());

	        if (page != null) {
	            String screenshotPath =
	                ScreenshotsUtils.takeScreenshot(page, result.getName());

	            test.addScreenCaptureFromPath(screenshotPath);	
	        }
	}
	else if (result.getStatus()==ITestResult.SUCCESS)
	{
		test.pass("test Pass Sucesfully")	;
	}

	else 
		test.skip("test Skipped Successfully");
	extent.flush();

	if (browserContext != null) {
		browserContext.close();
	}

	if (browser != null) {
		browser.close();
	}

	if (playwright != null) {
		playwright.close();
	}
}
}
