package Tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Homepage;
import pages.LoginPage;

public class LoginPage2 extends BaseTest {	
	 @Test
	 public void Login() {
		 
		LoginPage loginPage=new LoginPage(page);
		Homepage homepage=new Homepage(page);
		
		test.info("Naviagtinh to the Login page");
		page.navigate("https://opensource-demo.orangehrmlive.com/web/auth/");
		
		test.info("Enters the Username ");
		loginPage.EnterUsername("Admin");
		
		test.info("Enters the Password");
		loginPage.EnterPassword("agmin123");
		
		test.info("Clicking the Submit Button");
		loginPage.SubmitLogin();
	 }
	 @Test
	 public void SkipLogin() {
		 test.skip("Skippting this test");
			throw new SkipException("Skippting this test");
		 }
}
