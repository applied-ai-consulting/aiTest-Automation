package com.java.aitest_cukes;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.java.aitest_cukes.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultiBrowserTestStep {
	
	@Then("^I verified user is on dasboard when clicked on Multibrowser test button$")
	public void i_verified_user_is_on_dasboard_when_clicked_on_Multibrowser_test_button() throws Throwable {
		Utilities.clickOnElement("//span[normalize-space()='Multi Browser Test']");
		String MBTDashboard_url = Hooks.driver.getCurrentUrl();
		boolean MBT_present = MBTDashboard_url.contains("multi-browser-test");
		Assert.assertEquals(true,MBT_present);
	}
	
	
	
	@Then("^I filtered completed test from the list$")
	public void i_filtered_completed_test_from_the_list() throws Throwable {
		Utilities.clickOnElement("(//div[contains(@role,'button')])[2]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[2]");
	}
	
	
	@Then("^I validate show summary data of MBT and config\\.page data of MBT are same or not$")
	public void i_validate_show_summary_data_of_MBT_and_config_page_data_of_MBT_are_same_or_not() throws Throwable {
		Utilities.clickOnElement("//span[normalize-space()='Show Summary']");
		Thread.sleep(2000);
		String Max_user = Hooks.driver.findElement(By.xpath("//*[text()='Max Users']/following-sibling::*[contains(@class,'MuiTypography')]")).getText();
		System.out.println("Max user="+Max_user);
		Utilities.clickOnElement("(//span[contains(text(),'View')])[1]");
		String Conf_max_user = Hooks.driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
		Assert.assertEquals(Max_user, Conf_max_user);
	}
	
	@Then("^I click on Create Testrun button$")
	public void i_click_on_Create_Testrun_button() throws Throwable {
		Utilities.clickOnElement("(//button[@type='button'])[1]");
	}
	
	@Then("^I clicked on existing Created Testrun$")
	public void i_clicked_on_existing_Created_Testrun() throws Throwable {
	
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
//		WebElement input = Hooks.driver.findElement(By.xpath("//span[@aria-label='checking status']"));
//	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
//	    js.executeScript("arguments[0].scrollIntoView();", input );
//	    Thread.sleep(2000);
	    Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[11]");
	}
	
	@Then("^I select Created  Two Testrun$")
	public void i_select_Created_Two_Testrun() throws Throwable {
		
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
//		WebElement input = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[3]"));
//	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
//	    js.executeScript("arguments[0].scrollIntoView();", input );
//	    Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[7]");
		Thread.sleep(1000);
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]");
//		Thread.sleep(1000);
//		WebElement input2 = Hooks.driver.findElement(By.xpath("//button[text()='Compare']"));
//	    js.executeScript("arguments[0].scrollIntoView();", input2 );
	    Thread.sleep(2000);
	}
	
	@Then("^I filtered testname with draft option$")
	public void i_filtered_testname_with_draft_option() throws Throwable {
		Utilities.clickOnElement("(//div[@role='button'])[5]");
		Thread.sleep(2000);
		Utilities.clickOnElement("//li[@data-value='draft']");
	}
	
	@Then("^I validate draft filter testname is same as dashboard test status$")
	public void i_validate_draft_filter_testname_is_same_as_dashboard_test_status() throws Throwable {
		Utilities.clickOnElement("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-grid-xs-11 css-1g1flhp'])[1]");
		Thread.sleep(3000);
	    String Status_btn_name = Hooks.driver.findElement(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-grid-xs-11 css-1g1flhp'])[1]")).getText();
		System.out.println("status name="+Status_btn_name);
		String Test_sts_name = Hooks.driver.findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li'])[3]")).getText();
		System.out.println("Teststatus name="+Test_sts_name);
		Assert.assertEquals(Test_sts_name.replaceAll("[\r\n]+", " "),"TestMBt1");
	//	Assert.assertEquals(Status_btn_name, Test_sts_name);
		//Assert.assertEquals(true, Status);
	}
	
	@Then("^I Select Device Versions$")
	public void i_Select_Device_Versions() throws Throwable {

	    Thread.sleep(2000);
		Utilities.clickOnElement("(//button[@type='button'])[12]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@name='iPhone 12 Pro'])[1]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//button[text()='Save'])[2]");
//		Actions action = new Actions (Hooks.driver);
//		action.sendKeys(Keys.PAGE_UP);
//	    action.build().perform();
		WebElement input = Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter AUT URL']"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
		Thread.sleep(2000);
	}
	
	@Then("^I clicked on created draft Testrun$")
	public void i_clicked_on_created_draft_Testrun() throws Throwable {
		
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
		Utilities.clickOnElement("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-grid-xs-11 css-1g1flhp']");
}
	
	@Then("^I Clicked on Upload zip file button and select file$")
	public void i_Clicked_on_Upload_zip_file_button_and_select_file() throws Throwable {
//		WebElement input = Hooks.driver.findElement(By.xpath("(//button[@type='button'])[8]"));
//	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
//	    js.executeScript("arguments[0].scrollIntoView();", input );
//	    Thread.sleep(3000);
		Utilities.clickOnElement("//div[@role='presentation']");
		Robot rb=new Robot();
		rb.delay(2000);
		 StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\Documents\\marXeed_UiAutomation140223_R1.zip");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//        StringSelection ss=new StringSelection("C:\\Users\\Supriya\\Desktop\\aitest zipcode\\marXeed_UiAutomation140223_R1.zip");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
      
	}
	
	@Then("^I Validate Testrun getting created successfully message popup as \"([^\"]*)\"$")
	public void i_Validate_Testrun_getting_created_successfully_message_popup_as(String messagePopup) throws Throwable {
		String Error_msg1 = Hooks.driver.findElement(By.xpath("//div[@class='SnackbarItem-message']")).getText();
		System.out.println("Text ="+Error_msg1);
		Assert.assertEquals(Error_msg1, messagePopup);
    }
	
	@Then("^I enter Repo Details$")
	public void i_Enter_Repo_Details() throws Throwable {
		
		// Repo url
		Utilities.clickOnElement("//input[@placeholder='Git Repo URL']");
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Git Repo URL']")).sendKeys("https://github.com/applied-ai-consulting/marXeed_UiAutomation.git");
		
//		// Git username
//		WebElement input = Hooks.driver.findElement(By.xpath("//input[@id='usersGitUsername']"));
//	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
//	    js.executeScript("arguments[0].scrollIntoView();", input );
//	    Thread.sleep(2000);
	    Utilities.clickOnElement("//input[@id='usersGitUsername']");
		Hooks.driver.findElement(By.xpath("//input[@id='usersGitUsername']")).sendKeys("suvarna08");
		// git token/password
		Utilities.clickOnElement("//input[@id='userGitPassword']");
		Hooks.driver.findElement(By.xpath("//input[@id='userGitPassword']")).sendKeys("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");
		
		// Report file Location
		Utilities.clickOnElement("//input[@id='reportFileLocation']");
		Hooks.driver.findElement(By.xpath("//input[@id='reportFileLocation']")).sendKeys("target/reports/Cucumber.xml");
		
		// Testrun command
		Utilities.clickOnElement("//input[@id='testRunCommand']");
		Hooks.driver.findElement(By.xpath("//input[@id='testRunCommand']")).sendKeys("mvn test -Dcucumber.options=\"--tags @Smoke\"");
		
	}
}

