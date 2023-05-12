package com.Actitime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMhome {
	//declaration
	@FindBy (id = "container_tasks")
	private WebElement tasktab;
	@FindBy (id = "container_reports")
	private WebElement reporttab;
	@FindBy (id = "container_users")
	private WebElement usertab;
	@FindBy (xpath = "//a[.='Logout']")
	private WebElement logouttab;
	
	//initialization
	public POMhome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getTasktab() {
		return tasktab;
	}
	public WebElement getReporttab() {
		return reporttab;
	}
	public WebElement getUsertab() {
		return usertab;
	}
	public WebElement getLogouttab() {
		return logouttab;
	}
}
