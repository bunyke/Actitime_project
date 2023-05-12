package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.fileLibrary;
import com.Actitime.objectRepository.POMhome;
import com.Actitime.objectRepository.POMtask;

public class Task extends Baseclass {
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException {
		POMhome hp = new POMhome(driver);
		hp.getTasktab().click();
		POMtask tp = new POMtask(driver);
		tp.getAnb().click();
		tp.getNcb().click();
		fileLibrary f = new fileLibrary();
		String createcustomer = f.readDataFromExcel("Sheet1", 1, 1);
		tp.getNcntf().sendKeys(createcustomer);
		String desc = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getDestf().sendKeys(desc);
		tp.getCrcob().click();
		String expectedresult = createcustomer ;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+createcustomer+"'])[2]")).getText();
		Reporter.log(actualresult);
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		s.assertAll();
	}
}
