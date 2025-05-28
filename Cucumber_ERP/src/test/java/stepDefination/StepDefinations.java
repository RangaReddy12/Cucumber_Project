package stepDefination;

import org.openqa.selenium.WebDriver;

import commonFunctions.FunctionLibrary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	WebDriver driver;
	@Given("launch browser")
	public void launch_browser() throws Throwable {
	    driver = FunctionLibrary.startBrowser();
	}

	@When("launch url in a browser")
	public void launch_url_in_a_browser() {
	   FunctionLibrary.openUrl();
	}

	@When("Wait for username with {string} and {string}")
	public void wait_for_username_with_and(String Ltype, String Lvalue) {
	    FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Enter Username with {string} and {string} and {string}")
	public void enter_Username_with_and_and(String Ltype, String Lvalue,String TestData) {
	    FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
	}

	@When("Enter password with {string} and {string} and {string}")
	public void enter_password_with_and_and(String Ltype, String Lvalue,String Testdata) {
	    FunctionLibrary.typeAction(Ltype, Lvalue, Testdata);
	}

	@When("click Login button with {string} and {string}")
	public void click_Login_button_with_and(String Ltype, String Lvalue) {
	   FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@When("Wait for logout link with {string} and {string}")
	public void wait_for_logout_link_with_and(String Ltype, String Lvalue) {
	    FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@Then("Verify page title with {string}")
	public void verify_page_title_with(String testdata) {
	   FunctionLibrary.validateTitle(testdata);
	}

	@When("Wait  for suppliers link with {string} and {string}")
	public void wait_for_suppliers_link_with_and(String Ltype, String Lvalue) {
	    FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Click Suppliers link with {string} and {string}")
	public void click_Suppliers_link_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@When("Wait for Add + icon with {string} and {string}")
	public void wait_for_Add_icon_with_and(String Ltype, String Lvalue) {
		 FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Click Add + icon with {string} and {string}")
	public void click_Add_icon_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@When("Wait for Supplier Number with {string} and {string}")
	public void wait_for_Supplier_Number_with_and(String Ltype, String Lvalue) {
		 FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Capture Supplier number with {string} and {string}")
	public void capture_Supplier_number_with_and(String Ltype, String Lvalue) throws Throwable {
	    FunctionLibrary.captureSupplier(Ltype, Lvalue);
	}

	@When("Enter in {string} with {string} and {string}")
	public void enter_in_with_and(String TestData, String Ltype, String Lvalue) {
	    FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
	}

	@When("Click Add button with {string} and {string}")
	public void click_Add_button_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@When("Wait for confirm Ok button with {string} and {string}")
	public void wait_for_confirm_Ok_button_with_and(String Ltype, String Lvalue) {
		 FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Click Confirm ok button with {string} and {string}")
	public void click_Confirm_ok_button_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@When("Wait for alert ok button with {string} and {string}")
	public void wait_for_alert_ok_button_with_and(String Ltype, String Lvalue) {
		 FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Click Alert ok button with {string} and {string}")
	public void click_Alert_ok_button_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@Then("Verify Supplier Table")
	public void verify_Supplier_Table() throws Throwable {
	    FunctionLibrary.supplierTable();
	}

	@When("Close App Browser")
	public void close_App_Browser() {
	   FunctionLibrary.closeBrowser();
	}
	@When("Wait  for Customers link with {string} and {string}")
	public void wait_for_Customers_link_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Click Customers link with {string} and {string}")
	public void click_Customers_link_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.clickAction(Ltype, Lvalue);
	}

	@When("Wait for Customer Number with {string} and {string}")
	public void wait_for_Customer_Number_with_and(String Ltype, String Lvalue) {
		FunctionLibrary.waitForElement(Ltype, Lvalue, "10");
	}

	@When("Capture Customer number with {string} and {string}")
	public void capture_Customer_number_with_and(String Ltype, String Lvalue) throws Throwable {
	    FunctionLibrary.captureCustomer(Ltype, Lvalue);
	}

	@Then("Verify Customer Table")
	public void verify_Customer_Table() throws Throwable {
	   FunctionLibrary.customerTable();
	}


}
