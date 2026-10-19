package pages;

import com.microsoft.playwright.Page;

public class Homepage {
	
	private Page page;
	private final String clicktime="";
	public Homepage(Page page)
	{
		this.page=page;
	}
	public void selectTime()
	{
		page.click(clicktime);
	}

}
