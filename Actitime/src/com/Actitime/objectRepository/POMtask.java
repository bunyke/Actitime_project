package com.Actitime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMtask {
	//declaration
	@FindBy (xpath = "//div[@class='title ellipsis']")
	private WebElement anb;
	@FindBy (xpath = "//div[@class='item createNewCustomer']")
	private WebElement ncb;
	@FindBy (xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement ncntf;
	@FindBy (xpath = "(//textarea[@class='textarea'])[9]")
	private WebElement destf;
	@FindBy (xpath = "//div[.='Create Customer']")
	private WebElement crcob;
	@FindBy (xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancel;
	
	//initialization
	public POMtask(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAnb() {
		return anb;
	}
	public WebElement getNcb() {
		return ncb;
	}
	public WebElement getNcntf() {
		return ncntf;
	}
	public WebElement getDestf() {
		return destf;
	}
	public WebElement getCrcob() {
		return crcob;
	}
	public WebElement getCancel() {
		return cancel;
	}	
}
