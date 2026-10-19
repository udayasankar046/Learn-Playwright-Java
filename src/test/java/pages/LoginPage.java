package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	private final String UserNameLoactor="input[name=username]";
	
	private final String PasswordLocator="input[name=password]";
	private final String ClickLogin="button[type=submit]";
	
	public LoginPage(Page page)
	{
		this.page=page;
	}
	public void EnterUsername(String username)
	{
		page.fill(UserNameLoactor, username);
	}
	public void EnterPassword(String Password)
	{
		page.fill(PasswordLocator, Password);

	}
	public void SubmitLogin()
	{
		page.click(ClickLogin);
	}

}
