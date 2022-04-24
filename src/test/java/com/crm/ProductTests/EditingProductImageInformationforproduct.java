package com.crm.ProductTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;

public class EditingProductImageInformationforproduct extends BaseClass{
@Test
public void EditingProductImageInformationforProduct() throws Throwable  {
	
	
	     //Read data from Excel sheet
		String ProductName = elib.Readdataexcel("ProdutModule", 33, 1);
		String In = elib.Readdataexcel("ProdutModule", 33, 1);
	 	
		/*Navigate to product link and click on product link*/
		HomePage hp=new HomePage(driver);
		hp.ClickonProductLnk();
		
		
		/*Editing Product Image Information for Product*/
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.EditingProductImageInformationforProduct(driver, ProductName, In);
		
 	}
}
