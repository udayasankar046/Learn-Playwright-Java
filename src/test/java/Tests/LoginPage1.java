package Tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import base.BaseTest;

public class LoginPage1 extends BaseTest {	

	 @Test
	 public void test() {
	    page.navigate("https://www.facebook.com/");

	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address or mobile number")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address or mobile number")).fill("9003682046");
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("jamuna");
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

}
}
