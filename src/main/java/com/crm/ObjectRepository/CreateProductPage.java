package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateProductPage extends WebdriverUtility {
    
	//declaration
	@FindBy(name="productname")
	private WebElement ProductNameEdit;
	
	@FindBy(name="description")
	private WebElement descriptionEdt;
	
    @FindBy(name="qtyinstock")
     private WebElement qtyStockEdt;
    
    @FindBy(name="qty_per_unit")
    private WebElement qtyperunitEdt;
    
    @FindBy(name="reorderlevel")
    private WebElement reorderlevelEdt;
    
    @FindBy(name="qtyindemand")
    private WebElement qtyindemandEdt;
    
     @FindBy(name="usageunit")
     private WebElement usageunitDD;
    
     @FindBy(xpath="//input[@value='T']")
     private WebElement RadioGBtn;
     
     @FindBy(xpath="//select[@name='assigned_group_id']")
     private WebElement assignedgroupIdDD;
     
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement EditBtn;
	
	@FindBy(name="sales_start_date")
	private WebElement SalesStratDate;
	
	@FindBy(name="productcategory")
	private WebElement productcategoryDD;
	
	@FindBy(name="sales_end_date")
	private WebElement SalesEndDate;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement clickonVendorWindowBtn;
	
	@FindBy(name="search_text")
	private WebElement SearchVendorEdt;
	
	@FindBy(name="search")
	private WebElement VendorSearchBtn;
	
	@FindBy(name="productsheet")
	private WebElement productSheetEdt;
	
	@FindBy(name="glacct")
	private WebElement glacctDD;
	
	@FindBy(name="productcode")
	private WebElement productcodeEdt;
	
	@FindBy(name="vendor_part_no")
	private WebElement VendorpartNumEdt;
	
	@FindBy(name="manufacturer")
	private WebElement ManufacturerDD;
	
	@FindBy(id="jscal_field_start_date")
	private WebElement SupportStartDateEdt;
	
	@FindBy(id="jscal_field_expiry_date")
	private WebElement SupportEndDateEdt;
	
	@FindBy(name="website")
	private WebElement websiteEdt;
	
	@FindBy(name="mfr_part_no")
	private WebElement MfrPartNumEdt;
	
	@FindBy(name="serial_no")
	private WebElement SerialNumEdt;
	
	@FindBy(name="productcode")
	private WebElement PartNumEdt;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(name="search_text")
	private WebElement search_textEdt;
	
	@FindBy(name="search_field")
	private WebElement search_fieldDD;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[.='edit']")
	private WebElement editBtn;
	
	@FindBy(name="unit_price")
	private WebElement unit_priceEdt;
	
	@FindBy(name="tax1_check")
	private WebElement tax1_checkBtn;
	
	@FindBy(name="tax2_check")
	private WebElement tax2_checkBtn;
	
	@FindBy(name="tax3_check")
	private WebElement tax3_checkBtn;
	
	@FindBy(xpath="//a[.='more currencies »']")
	private WebElement morecurrenciesLnk;
	
	@FindBy(xpath="//input[@class='crmbutton small edit']")
	private WebElement crmbuttonsmallBtn;
	
	@FindBy(xpath="//img[@style='cursor: pointer;']")
	private WebElement cursorpointerBtn;
	
	//initialization with constructer
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getProductNameEdit() {
		return ProductNameEdit;
	}
	
	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getQtyStockEdt() {
		return qtyStockEdt;
	}

	public WebElement getQtyperunitEdt() {
		return qtyperunitEdt;
	}

	public WebElement getReorderlevelEdt() {
		return reorderlevelEdt;
	}

	public WebElement getQtyindemandEdt() {
		return qtyindemandEdt;
	}

	public WebElement getUsageunitDD() {
		return usageunitDD;
	}

	public WebElement getRadioGBtn() {
		return RadioGBtn;
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}
	

	public WebElement getSalesStratDate() {
		return SalesStratDate;
	}

	public WebElement getProductcategoryDD() {
		return productcategoryDD;
	}

	public WebElement getSalesEndDate() {
		return SalesEndDate;
	}

	public WebElement getClickonVendorWindowBtn() {
		return clickonVendorWindowBtn;
	}

	public WebElement getSearchVendorEdt() {
		return SearchVendorEdt;
	}

	public WebElement getVendorSearchBtn() {
		return VendorSearchBtn;
	}

	public WebElement getProductSheetEdt() {
		return productSheetEdt;
	}

	public WebElement getGlacctDD() {
		return glacctDD;
	}

	public WebElement getProductcodeEdt() {
		return productcodeEdt;
	}

	public WebElement getVendorpartNumEdt() {
		return VendorpartNumEdt;
	}

	public WebElement getManufacturerDD() {
		return ManufacturerDD;
	}

	public WebElement getSupportStartDateEdt() {
		return SupportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return SupportEndDateEdt;
	}

	public WebElement getWebsiteEdt() {
		return websiteEdt;
	}

	public WebElement getMfrPartNumEdt() {
		return MfrPartNumEdt;
	}

	public WebElement getSerialNumEdt() {
		return SerialNumEdt;
	}

	public WebElement getPartNumEdt() {
		return PartNumEdt;
	}

	public WebElement getAssignedgroupIdDD() {
		return assignedgroupIdDD;
	}
	//Scenario 4 start here
	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getSearch_textEdt() {
		return search_textEdt;
	}

	public WebElement getSearch_fieldDD() {
		return search_fieldDD;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getUnit_priceEdt() {
		return unit_priceEdt;
	}

	public WebElement getTax1_checkBtn() {
		return tax1_checkBtn;
	}

	public WebElement getTax2_checkBtn() {
		return tax2_checkBtn;
	}

	public WebElement getTax3_checkBtn() {
		return tax3_checkBtn;
	}

	public WebElement getMorecurrenciesLnk() {
		return morecurrenciesLnk;
	}

	public WebElement getCrmbuttonsmallBtn() {
		return crmbuttonsmallBtn;
	}

	public WebElement getCursorpointerBtn() {
		return cursorpointerBtn;
	}

	//Business laibrary
	public void createProductName(String productname,String Description) {
		ProductNameEdit.sendKeys(productname);
		descriptionEdt.sendKeys(Description);
		saveBtn.click();
	}
	
	public void CreateStockInformation(WebDriver driver,String productName,String QtyinStock,String QtyUnit,String ReorderLevel,
	String QtyinDemand,String usageunitDropDown,String HandlerDD)  
	{
		ProductNameEdit.sendKeys(productName);
		qtyStockEdt.sendKeys(QtyinStock);
		qtyperunitEdt.sendKeys(QtyUnit);
		reorderlevelEdt.sendKeys(ReorderLevel);
		qtyindemandEdt.sendKeys(QtyinDemand);
	    select(usageunitDD,usageunitDropDown);
	    select(assignedgroupIdDD, HandlerDD);
	    getRadioGBtn().click();
		saveBtn.click();

	}
	public void EditingInformationforProduct(WebDriver driver,String productName,String ProductNameran,String SalesStartDate,String SalesEndDate, 
	String ProductCategory,String Vendorname,String ProductSheet,String glacctD,String Productcode,String ProductNum,
	String VendorPartNum,String Manufacturer, String SupportStartDate,String SupportEndDate,String Website,String MfrPartNum,
	String SerialNum,String PartNum) 
	{
		ProductNameEdit.sendKeys(productName);
		saveBtn.click();
		String header1 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		Assert.assertTrue(header1.contains(ProductNameran), "Verified");
		EditBtn.click();
		ProductNameEdit.clear();
		ProductNameEdit.sendKeys(ProductNameran);
		SalesStratDate.sendKeys(SalesStartDate);
		select(ProductCategory, productcategoryDD);
		getSalesEndDate().sendKeys(SalesEndDate);
		clickonVendorWindowBtn.click();
		switchToWindow(driver, "Vendors");
		SearchVendorEdt.sendKeys(Vendorname);
		VendorSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Vendorname+"']")).click();
		switchToWindow(driver, "Products");
		productSheetEdt.sendKeys(ProductSheet);
		select(glacctD, glacctDD);
		productcodeEdt.sendKeys(Productcode);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('product_no').value='"+ProductNum+"'");//non Editable TextField
		VendorpartNumEdt.sendKeys(VendorPartNum);
		select(Manufacturer, ManufacturerDD);
		SupportStartDateEdt.sendKeys(SupportStartDate);
		SupportEndDateEdt.sendKeys(SupportEndDate);
		websiteEdt.sendKeys(Website);
		MfrPartNumEdt.sendKeys(MfrPartNum);
		SerialNumEdt.sendKeys(SerialNum);
		PartNumEdt.sendKeys(PartNum);
		saveBtn.click();

	}
}
