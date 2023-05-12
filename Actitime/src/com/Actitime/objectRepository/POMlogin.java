package com.Actitime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actitime.GenericLibrary.Baseclass;

public class POMlogin {
	//declaration
	@FindBy (id = "username")
	private WebElement untf;
	@FindBy (name = "pwd")
	private WebElement pwdtf;
	@FindBy (xpath = "//div[.='Login ']")
	private WebElement lgtf;
	
	//utilization
	public POMlogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUntf() {
		return untf;
	}
	public WebElement getPwdtf() {
		return pwdtf;
	}
	public WebElement getLgtf() {
		return lgtf;
	}
}
