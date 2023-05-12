package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.objectRepository.POMhome;
import com.Actitime.objectRepository.POMlogin;

public class Baseclass {
	public static WebDriver driver;
	fileLibrary f = new fileLibrary();
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected", true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		//driver.get("https://demo.actitime.com"); //hardcode
		Reporter.log("browser launched", true);
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String UN = f.readDataFromPropertyFile("username");
		//driver.findElement(By.id("username")).sendKeys(UN);
		////driver.findElement(By.id("username")).sendKeys("admin");
		String pwd = f.readDataFromPropertyFile("password");
		//driver.findElement(By.name("pwd")).sendKeys(pwd);
		////driver.findElement(By.name("pwd")).sendKeys("manager");
		//driver.findElement(By.xpath("//div[.='Login ']")).click();
		POMlogin lp = new POMlogin(driver);
		lp.getUntf().sendKeys(UN);
		lp.getPwdtf().sendKeys(pwd);
		Thread.sleep(10000);
		lp.getLgtf().click();
		Reporter.log("logedin successfully", true);
	}
	@AfterMethod
	public void logout() {
		POMhome hp = new POMhome(driver);
		hp.getLogouttab().click();
		Reporter.log("logedout successfully", true);
	}
	@AfterClass
	public void closebrowser() {
		driver.quit();
		Reporter.log("browser closed", true);
	}
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected", true);
	}
}
