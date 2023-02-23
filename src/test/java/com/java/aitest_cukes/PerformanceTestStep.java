package com.java.aitest_cukes;

import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.java.aitest_cukes.Hooks;
import com.java.aitest_cukes.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PerformanceTestStep {
	
	
    @Then("^I clicked on Create Testrun button$")
    public void i_clicked_on_Create_Testrun_button() throws Throwable {
        Utilities.clickOnElement("(//button[@type='button'])[1]");
}
	@Then("^I validate I am on create Testrun page$")
	public void i_validate_I_am_on_create_Testrun_page() throws Throwable {
		String Current_Url = Hooks.driver.getCurrentUrl();
		Assert.assertEquals(Current_Url, "https://ui.aitest.dev.appliedaiconsulting.com/performance-test:create");
	    
	}
	
	@When("^I Clicked on Testrun name and kept filed empty$")
	public void i_Clicked_on_Testrun_name_and_kept_filed_empty() throws Throwable {
	    Utilities.clickOnElement("//input[@id='testName']");
	    Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
	}

	@Then("^I validate error message appears for Testrun name field$")
	public void i_validate_error_message_appears_for_Testrun_name_field() throws Throwable {
	   String Error_msg = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[1]")).getText();
	   //System.out.println("error message="+Error_msg);
	   Assert.assertEquals(Error_msg, "Test name is required");
	}
	
	@When("^I Clicked on Project and kept filed empty$")
	public void i_Clicked_on_Project_and_kept_filed_empty() throws Throwable {
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");

		Utilities.clickOnElement("//input[@name='projectTitle']");
		Utilities.clickOnElement("//button[@title='Clear']");
		Utilities.clickOnElement("(//input[@type='radio'])[2]");
	}

	@Then("^I validate error message appears for project field$")
	public void i_validate_error_message_appears_for_project_field() throws Throwable {
		 String Error_msg = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[2]")).getText();
		   System.out.println("error message="+Error_msg);
		   Assert.assertEquals(Error_msg, "Project is required");
	}
	@When("^I Enter Project name as \"([^\"]*)\" on project field and validate it$")
	public void i_Enter_Project_name_as_on_project_field_and_validate_it(String projectName) throws Throwable {
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");

		Utilities.clickOnElement("//input[@name='projectTitle']");
		Utilities.clickOnElement("//button[@title='Clear']");
		Hooks.driver.findElement(By.xpath("//input[@name='projectTitle']")).sendKeys(projectName);
		Robot rb = new Robot();
		rb.delay(1000);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Add']");
		 String Noti_msg = Hooks.driver.findElement(By.xpath("//div[@class='MuiCollapse-wrapperInner MuiCollapse-vertical css-8atqhb']")).getText();
		    System.out.println("Notification message="+Noti_msg);
			Assert.assertEquals(Noti_msg, "Project already exists");
			Thread.sleep(1000);
	}

	@Then("^I click on add project button and added new project as \"([^\"]*)\"$")
	public void i_click_on_add_project_button_and_added_new_project_as(String projectName) throws Throwable {
		
		Utilities.clickOnElement("(//button[@type='button'])[7]");
		Utilities.clickOnElement("//input[@placeholder='Enter project name...']");
		
		 Robot robot = new Robot();
		 robot.delay(1000);
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_A);
		 robot.delay(3000);
		 robot.keyRelease(KeyEvent.VK_A);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.delay(2000);
		 robot.keyPress(KeyEvent.VK_BACK_SPACE);
		 robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter project name...']")).sendKeys(projectName);
	    Utilities.clickOnElement("//button[normalize-space()='Add']");
	   
	}
	@Then("^I validate newly added project as \"([^\"]*)\" updated in dropdown list or not$")
	public void i_validate_newly_added_project_as_updated_in_dropdown_list_or_not(String projectName) throws Throwable {
		Utilities.clickOnElement("//input[@name='projectTitle']");
		 String Error_msg = Hooks.driver.findElement(By.xpath("//input[@value='Aitest']")).getText();
		   System.out.println("error message="+Error_msg);
		   Assert.assertEquals(Error_msg, projectName);
		Thread.sleep(1000);
	}
	
	
//	@Then("^I validate newly added project updated in dropdown list or not\\.$")
//	public void i_validate_newly_added_project_updated_in_dropdown_list_or_not() throws Throwable {
//		//Utilities.clickOnElement("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputA')]");
//		Thread.sleep(2000);
//		//WebElement dropdown = Hooks.driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputA')]"));  
//        //Select select = new Select(dropdown);
//        //List<WebElement> options = select.getOptions();
////		Robot robo=new Robot();
////		robo.keyPress(KeyEvent.VK_DOWN);
////		robo.keyRelease(KeyEvent.VK_DOWN);
////		Thread.sleep(2000);
////	    List<WebElement> Dropdown_list = Hooks.driver.findElements(By.xpath("//ul[@id=':rh:-listbox']"));
////	    int List_size = Dropdown_list.size();
////	    System.out.println("Size of the list="+List_size);
////	    for(WebElement list:Dropdown_list)
////	    {
////	    	String omkar = list.getText();
////	    	System.out.println(omkar);
////	    }
////        //for(WebElement we:options) {
////        //	System.out.println("Size of the list="+we.getText());
////        //}
//		Hooks.driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M7 10l5 5 ')]")).click();
//		List<WebElement> wbList = Hooks.driver.findElements(By.xpath("//ul[@id=':rc:-listbox']/li"));
//		System.out.println("size of dropdown is " + wbList.size());
//		for(int i=0;i< wbList.size();i++){
//		    System.out.println("value of " + i + "th element is " + wbList.get(i).getText());
//		}
//	    
//	}
//	
	@Then("^I verify the list$")
	public void i_verify_the_list() throws Throwable {
		
		Hooks.driver.findElement(By.xpath("(//*[name()='svg'][@focusable='false'])[9]")).click();
		Thread.sleep(2000);
		List<WebElement> wbList = Hooks.driver.findElements(By.xpath("//ul[@id=':rc:-listbox']/li"));
		Thread.sleep(5000);
		System.out.println("size of dropdown is " + wbList.size());
		for(int i=0;i< wbList.size();i++){
		    System.out.println("value of " + i + "th element is " + wbList.get(i).getText());
		}
	}
	
	@Then("^I click on add project button and added new project as \"([^\"]*)\" and validate error message popup$")
	public void i_click_on_add_project_button_and_added_new_project_as_and_validate_error_message_popup(String projectName) throws Throwable {
		
		Utilities.clickOnElement("(//button[@type='button'])[7]");
		Utilities.clickOnElement("//input[@placeholder='Enter project name...']");
		
		 Robot robot = new Robot();
		 robot.delay(1000);
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_A);
		 robot.delay(3000);
		 robot.keyRelease(KeyEvent.VK_A);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.delay(2000);
		 robot.keyPress(KeyEvent.VK_BACK_SPACE);
		 robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter project name...']")).sendKeys(projectName);
	    Utilities.clickOnElement("//button[normalize-space()='Add']");
	    String Noti_msg = Hooks.driver.findElement(By.xpath("//div[@class='SnackbarItem-message']")).getText();
	    System.out.println("Notification message="+Noti_msg);
		Assert.assertEquals(Noti_msg, "Project already exists");
		Thread.sleep(1000);
	}

	@Then("^I click on all the fields of repo details and kept empty field$")
	public void i_click_on_all_the_fields_of_repo_details_and_kept_empty_field() throws Throwable {
	  //  Utilities.enterTextUsingXpath("//input[@id='usersRepoUrl']", "abc");
	    //Utilities.clearText("//input[@id='usersGitUsername']");
	    Utilities.clickOnElement("//input[@id='usersRepoUrl']");
	   // Utilities.enterTextUsingXpath("//input[@id='usersGitUsername']", " ");
	    Utilities.clickOnElement("//input[@id='usersGitUsername']");
	  
	    WebElement input = Hooks.driver.findElement(By.xpath("//input[@id='userGitPassword']"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(3000);
	   
	    Utilities.clickOnElement("//input[@id='userGitPassword']");
	    Utilities.clickOnElement("//input[@id='reportFileLocation']");
	   // Utilities.enterTextUsingXpath("//input[@id='reportFileLocation']", " ");
	    //Utilities.enterTextUsingXpath("//input[@id='testRunCommand']", " ");
	    Utilities.clickOnElement("//input[@id='testRunCommand']");
	    Thread.sleep(3000);
	    Utilities.clickOnElement("(//button[@type='submit'])[1]");
	}

	@Then("^I validate all the error messages of the repo details field$")
	public void i_validate_all_the_error_messages_of_the_repo_details_field() throws Throwable {
		String Error_msg1 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[4]")).getText();
		System.out.println("error message1="+Error_msg1);
		Assert.assertEquals(Error_msg1, "Repo URL is required.");
		String Error_msg2 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[5]")).getText();
		System.out.println("error message2="+Error_msg2);
		Assert.assertEquals(Error_msg2, "Git Username is required.");
		String Error_msg3 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[6]")).getText();
		System.out.println("error message3="+Error_msg3);
		Assert.assertEquals(Error_msg3, "Git Token / Password is required.");
		String Error_msg4 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[7]")).getText();
		System.out.println("error message4="+Error_msg4);
		Assert.assertEquals(Error_msg4, "Report File Location is required.");
		String Error_msg5 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[8]")).getText();
		System.out.println("error message2="+Error_msg5);
		Assert.assertEquals(Error_msg5, "Test Run Command is required.");
		
		
		
	}
	
	@Then("^I clicked on Your Automation Code radio button$")
	public void i_clicked_on_Your_Automation_Code_radio_button() throws Throwable {
		
		Utilities.clickOnElement("//div[normalize-space()='Your Automation Code']");
	}

	@Then("^I click on all the fields of automation code and kept empty field$")
	public void i_click_on_all_the_fields_of_automation_code_and_kept_empty_field() throws Throwable {
		
		//Hooks.driver.findElement(By.xpath("//input[@id='testRunCommand']")).click();
		WebElement input = Hooks.driver.findElement(By.xpath("//input[@id='testRunCommand']"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(3000);
		Utilities.clickOnElement("//input[@id='testRunCommand']");
		Thread.sleep(2000);
		Utilities.clickOnElement("//input[@id='reportFileLocation']");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//button[@type='submit'])[1]");
	}

	@Then("^I validate all the error messages of the automation code field$")
	public void i_validate_all_the_error_messages_of_the_automation_code_field() throws Throwable {
		String Error_msg1 = Hooks.driver.findElement(By.xpath("(//p[text()='No files uploaded yet'])")).getText();
		System.out.println("error message1="+Error_msg1);
		Assert.assertEquals(Error_msg1, "No files uploaded yet");
		String Error_msg2 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[4]")).getText();
		System.out.println("error message2="+Error_msg2);
		Assert.assertEquals(Error_msg2, "Test Run Command is required");
		String Error_msg3 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[5]")).getText();
		System.out.println("error message3="+Error_msg3);
		Assert.assertEquals(Error_msg3, "Report File Location is required");
	}
	
	@Then("^I clicked on Upload zip file button and select file$")
	public void i_clicked_on_Upload_zip_file_button_and_select_file() throws Throwable {
		//WebElement Upload_file = Hooks.driver.findElement(By.xpath("//div[@role='presentation']"));
		//Upload_file.sendKeys("C:\\Users\\DELL\\Downloads\\DS_Klarity (1).zip");
		//Thread.sleep(2000);
		WebElement input = Hooks.driver.findElement(By.xpath("//input[@id='testRunCommand']"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(3000);
		Utilities.clickOnElement("//div[@role='presentation']");
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\Documents\\marXeed_UiAutomation140223_R1.zip");
//        StringSelection ss=new StringSelection("C:\\Users\\Supriya\\Desktop\\aitest zipcode\\marXeed_UiAutomation140223_R1.zip");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
      
	}
	@Then("^I clicked on Upload button$")
	public void i_clicked_on_Upload_button() throws Throwable {
		Utilities.clickOnElement("//button[@id='upload-file']");
	}
	
	@Then("^I validate Upload button is visible and click on it$")
	public void i_validate_Upload_button_is_visible_and_click_on_it() throws Throwable {
//		JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
//		js.executeScript("window.scrollBy(0,1000)", "");
//		Thread.sleep(2000);
		boolean Upload_visible = Hooks.driver.findElement(By.xpath("//button[@id='upload-file']")).isEnabled();
		Assert.assertEquals(true, Upload_visible);
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@id='upload-file']");
		
	}

	@Then("^I vallidate file is uploaded successfully$")
	public void i_vallidate_file_is_uploaded_successfully() throws Throwable {
	    String Upload_text = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Uploaded successfully...!']")).getText();
	    Assert.assertEquals(Upload_text, "Uploaded successfully...!");
	    String slider_percent = Hooks.driver.findElement(By.xpath("//p[contains(@class,'MuiTypography-root MuiTypography-body2 css-16')]")).getText();
	    Assert.assertEquals(slider_percent, "100%");
	    
	}

	@Then("^I click on Cancel button$")
	public void i_click_on_Cancel_button() throws Throwable {
		Utilities.clickOnElement("//button[normalize-space()='cancel']");
	}

	@Then("^I validate Upload button is disabled$")
	public void i_validate_Upload_button_is_disabled() throws Throwable {
		boolean Upload_visible = Hooks.driver.findElement(By.xpath("//button[@id='upload-file']")).isEnabled();
		Assert.assertEquals(false, Upload_visible);
	}
	
	@Then("^I checked the count of slider and text field$")
	public void i_checked_the_count_of_slider_and_text_field() throws Throwable {
		Hooks.driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[1]")).click();
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);

	
		Utilities.enterTextUsingXpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[1]", "100");
	    String Slider_count = Hooks.driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabelLabel'])[1]")).getText();
	    System.out.println("Slider Count="+Slider_count);
	    Thread.sleep(2000);
	    String TextField_count = Hooks.driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[1]")).getAttribute("value");
	    System.out.println("Text field Count="+TextField_count);
	    Assert.assertEquals(Slider_count, TextField_count);
	    
	}
	
	@Then("^I checked the count of slider and text field of Total_duration$")
	public void i_checked_the_count_of_slider_and_text_field_of_Total_duration() throws Throwable {
		Hooks.driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[2]")).click();
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);

	
		Utilities.enterTextUsingXpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[2]", "100");
	    String Slider_count = Hooks.driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabelLabel'])[2]")).getText();
	    System.out.println("Slider Count="+Slider_count);
	    Thread.sleep(2000);
	    String TextField_count = Hooks.driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[2]")).getAttribute("value");
	    System.out.println("Text field Count="+TextField_count);
	    Assert.assertEquals(Slider_count, TextField_count);
	}
	
	@Then("^I checked the count of slider and text field of Ramp up time$")
	public void i_checked_the_count_of_slider_and_text_field_of_Ramp_up_time() throws Throwable {
		Hooks.driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[3]")).click();
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);

	
		Utilities.enterTextUsingXpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[3]", "64");
	    String Slider_count = Hooks.driver.findElement(By.xpath("(//span[@class='MuiSlider-valueLabelLabel'])[3]")).getText();
	    System.out.println("Slider Count="+Slider_count);
	    Thread.sleep(2000);
	    String TextField_count = Hooks.driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-input MuiInput')])[3]")).getAttribute("value");
	    System.out.println("Text field Count="+TextField_count);
	    Assert.assertEquals(Slider_count, TextField_count);
	}
	
	@Then("^I click on Run It Now button without filling details$")
	public void i_click_on_Run_It_Now_button_without_filling_details() throws Throwable {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(2000);
	   Utilities.clickOnElement("//button[normalize-space()='Run It Now']");
	}

	@Then("^I validate all error message$")
	public void i_validate_all_error_message() throws Throwable {
		String Error_msg1 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[1]")).getText();
		Assert.assertEquals(Error_msg1, "Test name is required.");
		String Error_msg2 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[2]")).getText();
		Assert.assertEquals(Error_msg2, "");//Project is required
		String Error_msg3 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[3]")).getText();
		Assert.assertEquals(Error_msg3, "AUT URL is required.");
		String Error_msg4 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[4]")).getText();
		Assert.assertEquals(Error_msg4, "Repo URL is required.");
		String Error_msg5 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[5]")).getText();
		Assert.assertEquals(Error_msg5, "Git Username is required.");
		String Error_msg6 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[6]")).getText();
		Assert.assertEquals(Error_msg6, "Git Token / Password is required.");
		String Error_msg7 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[7]")).getText();
		Assert.assertEquals(Error_msg7, "Report File Location is required.");
		String Error_msg8 = Hooks.driver.findElement(By.xpath("(//p[@id='component-error-text'])[8]")).getText();
		Assert.assertEquals(Error_msg8, "Test Run Command is required.");
	}
	
	@Then("^I Enter Testrun name as \"([^\"]*)\"$")
	public void i_Enter_Testrun_name_as(String testrunName) throws Throwable {
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
		
		Utilities.clickOnElement("//input[@id='testName']");
		Hooks.driver.findElement(By.xpath("//input[@id='testName']")).sendKeys(testrunName);
	}
	@Then("^I Enter Project Name as \"([^\"]*)\"$")
	public void i_Enter_Project_Name_as(String projectName) throws Throwable {
		
		Utilities.clickOnElement("//input[@name='projectTitle']");
		Utilities.clickOnElement("//button[@title='Clear']");
		Hooks.driver.findElement(By.xpath("//input[@name='projectTitle']")).sendKeys(projectName);
		Robot rb = new Robot();
		rb.delay(1000);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		 Utilities.clickOnElement("//button[normalize-space()='Add']");
	}
	@Then("^I Enter Testrun Description as \"([^\"]*)\"$")
	public void i_Enter_Testrun_Description_as(String testrunDescription) throws Throwable {
		
			Utilities.clickOnElement("//input[@name='testDescription']");
			Hooks.driver.findElement(By.xpath("//input[@name='testDescription']")).sendKeys(testrunDescription);
	}	
	@Then("^I Enter Testrun Aut URL as \"([^\"]*)\"$")
	public void i_Enter_Testrun_Aut_URL_as(String autUrl) throws Throwable {
	
		Utilities.clickOnElement("//input[@id='appUrl']");
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter AUT URL']")).sendKeys(autUrl);
	}

	@Then("^I Enter Testrun Command$")
	public void i_Enter_Testrun_Command() throws Throwable {
		Utilities.clickOnElement("//input[@id='testRunCommand']");
		Hooks.driver.findElement(By.xpath("//input[@name='testRunCommand']")).sendKeys("mvn test -Dcucumber.options=\"--tags @Smoke\"");
	}
	
	@Then("^I Enter Report Location$")
	public void i_Enter_Report_Location() throws Throwable {
		Utilities.clickOnElement("//input[@id='reportFileLocation']");
		Hooks.driver.findElement(By.xpath("//input[@name='reportFileLocation']")).sendKeys("target/reports/Cucumber.xml");
	}

	@Then("^I validate Testrun getting created successfully message popup as \"([^\"]*)\"$")
	public void i_validate_Testrun_getting_created_successfully_message_popup_as(String messagePopup) throws Throwable {
		String Error_msg1 = Hooks.driver.findElement(By.xpath("//div[@class='SnackbarItem-message']")).getText();
		System.out.println("Text ="+Error_msg1);
		Assert.assertEquals(Error_msg1, messagePopup);
    }

	
	@Then("^I clicked on Your Repo Details radio button$")
	public void i_clicked_on_Your_Repo_Details_radio_button() throws Throwable {
		
		Utilities.clickOnElement("//div[normalize-space()='Repo Details']");
	}
	
	@Then("^I Enter Repo Details$")
	public void i_Enter_Repo_Details() throws Throwable {
		
		// Repo url
		Utilities.clickOnElement("//input[@id='usersRepoUrl']");
		Hooks.driver.findElement(By.xpath("//input[@id='usersRepoUrl']")).sendKeys("https://github.com/applied-ai-consulting/marXeed_UiAutomation.git");
		
		// Git username
		WebElement input = Hooks.driver.findElement(By.xpath("//input[@id='usersGitUsername']"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(2000);
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
	
	@Then("^I Enter Run Configuration Details$")
	public void i_Enter_Run_Configuration_Details() throws Throwable {
		Robot robo=new Robot();
		// Max User
		Utilities.clickOnElement("(//input[@value='50'])[2]");
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.delay(1000);
		Hooks.driver.findElement(By.xpath("(//input[@type='number'])[1]")).sendKeys("2");
		
		// Min User
		Utilities.clickOnElement("(//input[@value='10'])[3]");
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.delay(1000);
		Hooks.driver.findElement(By.xpath("//input[@id='initalUsers']")).sendKeys("1");
		
		// Time duration
		Utilities.clickOnElement("(//input[@value='15'])[2]");
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.delay(1000);
		Hooks.driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("5");
		
		//Iteration
		Utilities.clickOnElement("//input[@id='iterations']");
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.delay(1000);
		Hooks.driver.findElement(By.xpath("//input[@id='iterations']")).sendKeys("1");
		
		// Ramp up Time
		Utilities.clickOnElement("(//input[@value='10'])[2]");
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.delay(1000);
		Hooks.driver.findElement(By.xpath("(//input[@type='number'])[3]")).sendKeys("1");
		
		// Ramp up users
		Utilities.clickOnElement("//input[@id='rampUpUsers']");
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyPress(KeyEvent.VK_BACK_SPACE);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_BACK_SPACE);
		robo.delay(1000);
		Hooks.driver.findElement(By.xpath("(//input[@type='number'])[6]")).sendKeys("1");
				
	}
	
	@Then("^I clicked on Run It Now button$")
	public void i_clicked_on_Run_It_Now_button() throws Throwable {
		
		Utilities.clickOnElement("//button[text()='Run It Now']");
	}
	
	@Then("^I clicked on Created Testrun$")
	public void i_clicked_on_Created_Testrun() throws Throwable {
		
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
		WebElement input = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[24]"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(2000);
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[28]");
	}
	
	@Then("^I clicked on Copy and Run button$")
	public void i_clicked_on_Copy_and_Run_button() throws Throwable {
		
		Utilities.clickOnElement("//img[@alt='ReRunLogo']");
	}
	
	@Then("^I clicked on Run button$")
	public void i_clicked_on_Run_button() throws Throwable {
		
		Utilities.clickOnElement("//button[text()='Run']");
	}
	@Then("^I validate Testrun getting Rerunning successfully message popup as \"([^\"]*)\"$")
	public void i_validate_Testrun_getting_Rerunning_successfully_message_popup_as(String popupMsg) throws Throwable {
		String Error_msg = Hooks.driver.findElement(By.xpath("//div[@class='SnackbarItem-message']")).getText();
		 System.out.println("Text ="+Error_msg);
		Assert.assertEquals(Error_msg, popupMsg);
    }
	
	@Then("^I clicked on Save button$")
	public void i_clicked_on_Save_button() throws Throwable {
		
		Utilities.clickOnElement("(//button[@type='submit'])[2]");
	}
	
	@Then("^I clicked on Run Button$")
	public void i_clicked_on_Run_Button() throws Throwable {
		
		Utilities.clickOnElement("//img[@alt='ReRunLogo']");
	}
	
	@Then("^I clicked on Created draft Testrun$")
	public void i_clicked_on_Created_draft_Testrun() throws Throwable {
		
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
		Utilities.clickOnElement("//span[text()='DemoTest']");
}
	@Then("^I Select Created  Two Testrun$")
	public void i_Select_Created_Two_Testrun() throws Throwable {
		
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
		WebElement input = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[24]"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[28]");
		Thread.sleep(1000);
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[30]");
		Thread.sleep(1000);
		WebElement input2 = Hooks.driver.findElement(By.xpath("//button[text()='Compare']"));
	    js.executeScript("arguments[0].scrollIntoView();", input2 );
	    Thread.sleep(2000);
	}
	
	@Then("^I clicked on Compare button$")
	public void i_clicked_on_Compare_button() throws Throwable {
		Utilities.clickOnElement("//button[text()='Compare']");
	}
	
	@Then("^I clicked on Analytics button$")
	public void i_clicked_on_Analytics_button() throws Throwable {
		
		Utilities.clickOnElement("//img[@alt='AnalyticsLogo']");
	}
	
	@Then("^I validate Testrun Comparison Summary deatils$")
	public void i_validate_Testrun_Comparison_Summary_deatils() throws Throwable {
		boolean Summary_deatils = Hooks.driver.findElement(By.xpath("(//div[@class='css-j7qwjs'])[3]")).isEnabled();
		Assert.assertEquals(true, Summary_deatils);
		Thread.sleep(2000);
	}
	
	@Then("^I validate Testrun api error Summary deatils$")
	public void i_validate_Testrun_api_error_Summary_deatils() throws Throwable {
		boolean Apierror_deatils = Hooks.driver.findElement(By.xpath("//div[@class='css-uuewlk']")).isEnabled();
		Assert.assertEquals(true, Apierror_deatils);
		Thread.sleep(2000);
	}
	
	@Then("^I clicked on Share button$")
	public void i_clicked_on_Share_button() throws Throwable {
		Utilities.clickOnElement("//img[@alt='ShareLogo']");
	}
	
	@Then("^I Enter Emailid as \"([^\"]*)\"$")
	public void i_Enter_Email_as(String emailId) throws Throwable {
		
		Utilities.clickOnElement("//input[@id='shareTest']");
		Hooks.driver.findElement(By.xpath("//input[@id='shareTest']")).sendKeys(emailId);
	}

	@Then("^I Clicked on Send button$")
	public void i_Clicked_on_Send_button() throws Throwable {
		Utilities.clickOnElement("//button[text()='Send']");
	}
	
	@Then("^I validate Message popup$")
	public void i_validate_Message_popup() throws Throwable {
		
		String Popup_msg = Hooks.driver.findElement(By.xpath("//div[@class='SnackbarItem-message']")).getText();
		 System.out.println("Text ="+Popup_msg);
		Assert.assertEquals(Popup_msg, "Test details shared successfully");
	}
	
	@Then("^I validate show summary data and config\\.page data are same or not$")
	public void i_validate_show_summary_data_and_config_page_data_are_same_or_not() throws Throwable {
		
		Utilities.clickOnElement("(//span[text()='demo'])[2]");
		Utilities.clickOnElement("//span[text()='View']");
		String tetrun_Name = Hooks.driver.findElement(By.xpath("//span[text()='demo']")).getText();
		 System.out.println("Text ="+tetrun_Name);
		Assert.assertEquals(tetrun_Name, "demo");
	}
	@Then("^I clicked on Existing Created Testrun$")
	public void i_clicked_on_Existing_Created_Testrun() throws Throwable {
	
		Utilities.clickOnElement("(//*[name()='svg'][@focusable='false'])[9]");
//		WebElement input = Hooks.driver.findElement(By.xpath("//span[text()='demo']"));
//	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
//	    js.executeScript("arguments[0].scrollIntoView();", input );
//	    Thread.sleep(2000);
	    Utilities.clickOnElement("(//span[text()='demo'])[2]");
	}
	
	@Then("^I verified user is on dasboard when clicked on Performance test button$")
	public void i_verified_user_is_on_dasboard_when_clicked_on_Performance_test_button() throws Throwable {
		
		Utilities.clickOnElement("//span[text()='View']");
		boolean Dashboard = Hooks.driver.findElement(By.xpath("//div[@class='css-1hxp6fi']")).isEnabled();
		Assert.assertEquals(true, Dashboard);
		Thread.sleep(2000);
	}
	
	@Then("^I Enter Git password$")
	public void i_Enter_Git_password() throws Throwable {
		
		Actions a = new Actions(Hooks.driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Utilities.clickOnElement("//input[@placeholder='Git Password']");
		Hooks.driver.findElement(By.xpath("//input[@placeholder='Git Password']")).sendKeys("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");
				
	}

}


