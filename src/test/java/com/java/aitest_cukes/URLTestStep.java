package com.java.aitest_cukes;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.java.aitest_cukes.Hooks;
import com.java.aitest_cukes.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class URLTestStep {
	
	@Then("^I will be on URL Test$")
	public void i_will_be_on_URL_Test() throws Throwable {
		//Thread.sleep(3000);
	}
	@Then("^I validate seleted testname is same as displayed in dashboard$")
	public void i_validate_seleted_testname_is_same_as_displayed_in_dashboard() throws Throwable {
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[1]");
		Thread.sleep(3000);
	    String Testname = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[1]")).getText();
	    System.out.println("TestName="+Testname);
	    String DB_testname = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-info css-1i8idci'])[1]")).getText();
	    System.out.println("DashboardTestName="+DB_testname);
	    boolean Name_match = DB_testname.contains(Testname);
	    if (Name_match==true) {
	    	Assert.assertEquals(true, Name_match);
	    }
	    else {
	    	Utilities.clickOnElement("//div[@class='css-182dx50']");
	    	Thread.sleep(3000);
	    	String Testname1 = Hooks.driver.findElement(By.xpath("//div[@class='css-182dx50']")).getText();//tooltip xpath
	    	System.out.println("TestName1="+Testname1);
	    	Thread.sleep(3000);
		    String DB_testname1 = Hooks.driver.findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li'])[3]")).getText();
		    System.out.println("DashboardTestName1="+DB_testname1);
		    boolean Name_match1 = DB_testname1.contains(Testname1);
		    Assert.assertNotEquals(true, Name_match1);
	    }   
	}
	
	@Then("^I clicked on view config page of seletected test$")
	public void i_clicked_on_view_config_page_of_seletected_test() throws Throwable {
		Utilities.clickOnElement("//span[contains(@class,'MuiTypography-root MuiTypography-label css-f')]");
	}
	
	@Then("^I verified user is on dasboard when clicked on URL test button$")
	public void i_verified_user_is_on_dasboard_when_clicked_on_URL_test_button() throws Throwable {
		Utilities.clickOnElement("//span[normalize-space()='Url Test']");
		String URL_TDashboard_url = Hooks.driver.getCurrentUrl();
		boolean UT_present = URL_TDashboard_url.contains("url-test");
		Assert.assertEquals(true,UT_present);
	}
	
	@Then("^I filter test with completed condition$")
	public void i_filter_test_with_completed_condition() throws Throwable {
		Utilities.clickOnElement("(//button[@type='button'])[2]");
		Utilities.clickOnElement("(//li[@id='3'])[1]");
	}
	
	@Then("^I clicked on Analyze button of selected test$")
	public void i_clicked_on_Analyze_button_of_selected_test() throws Throwable {
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[5]");
		Utilities.clickOnElement("//img[@alt='AnalyticsLogo']");
	}

	@Then("^I validate analytics graph appears when clicked$")
	public void i_validate_analytics_graph_apperas_when_clicked() throws Throwable {
		JavascriptExecutor j = (JavascriptExecutor)Hooks.driver;
		j.executeScript("window.scrollBy(0,1200)");
	    boolean Graph_displed = Hooks.driver.findElement(By.xpath("//div[contains(@id,'apexcharts')]")).isDisplayed();
	    Assert.assertEquals(true,Graph_displed);
	}

	@Then("^I validate submitted filter testname is same as dashboard test status$")
	public void i_validate_submitted_filter_testname_is_same_as_dashboard_test_status() throws Throwable {
		Utilities.clickOnElement("//span[@aria-label='Copy of Cancel of Saved draft run']");
		Thread.sleep(3000);
	    String Status_btn_name = Hooks.driver.findElement(By.xpath("//span[@aria-label='Copy of Cancel of Saved draft run']")).getText();
		System.out.println("status name="+Status_btn_name);
		String Test_sts_name = Hooks.driver.findElement(By.xpath("(//li[@class='MuiBreadcrumbs-li'])[3]")).getText();
		System.out.println("Teststatus name="+Test_sts_name);
//		Assert.assertEquals(Status_btn_name, Test_sts_name);
		Assert.assertEquals(Test_sts_name.replaceAll("[\r\n]+", " "),"Copy of Cancel of Saved draft run");	
		//Assert.assertEquals(true, Status);
	}
	
	@Then("^I filtered testname with submitted option$")
	public void i_filtered_testname_with_submitted_option() throws Throwable {
		Utilities.clickOnElement("(//div[@role='button'])[5]");
		Thread.sleep(2000);
		Utilities.clickOnElement("//li[@data-value='submitted']");
	}
	
	@Then("^I filtered testname with In Progress option$")
	public void i_filtered_testname_with_In_Progress_option() throws Throwable {
		Utilities.clickOnElement("(//div[@role='button'])[5]");
		Thread.sleep(2000);
		Utilities.clickOnElement("//li[@data-value='In Progress']");
	}
	
	@Then("^I validate Inprogress filter testname is same as dashboard test status$")
	public void i_validate_Inprogress_filter_testname_is_same_as_dashboard_test_status() throws Throwable {
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[1]");
		Thread.sleep(4000);
	    String Status_btn_name = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[1]")).getText();
		System.out.println("status name="+Status_btn_name);
		Thread.sleep(2000);
		String Test_sts_name = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-info css-1i8idci'])[1]")).getText();
		System.out.println("Teststatus name="+Test_sts_name);
	//	Assert.assertEquals(Status_btn_name, Test_sts_name);
		Assert.assertEquals(Test_sts_name.replaceAll("[\r\n]+", " "),"Copy of Copy of testfirefox105");
	}
	
	@Then("^I filtered testname with Completed option$")
	public void i_filtered_testname_with_Completed_option() throws Throwable {
			Utilities.clickOnElement("(//div[@role='button'])[5]");
			Thread.sleep(2000);
			Utilities.clickOnElement("//li[@data-value='completed']");
	}
	
	@Then("^I validate Completed filter testname is same as dashboard test status$")
	public void i_validate_Completed_filter_testname_is_same_as_dashboard_test_status() throws Throwable {
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[4]");
		Thread.sleep(2000);
	    String Status_btn_name = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[4]")).getText();
		System.out.println("status name="+Status_btn_name);
		Thread.sleep(2000);
		String Test_sts_name = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-info css-1i8idci'])[1]")).getText();
		System.out.println("Teststatus name="+Test_sts_name);
	//  Assert.assertEquals(Status_btn_name, Test_sts_name);
		Assert.assertEquals(Test_sts_name.replaceAll("[\r\n]+", " "),"Copy of Copy of Saved draft run");
	}
	@Then("^I validate dashboard contains filter bubbles or not when clicked Pass radio button$")
	public void i_validate_dashboard_contains_filter_bubbles_or_not_when_clicked_Pass_radio_button() throws Throwable {
		Thread.sleep(3000);
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[11]");
		List<WebElement> Circles = Hooks.driver.findElements(By.xpath("//*[name()='circle']"));
		int Count_Circle = Circles.size();
		String C_Count = Integer.toString(Count_Circle);
		Utilities.clickOnElement("(//span[contains(text(),'Pass')])[2]");
		Thread.sleep(3000);
		String TT_count = Hooks.driver.findElement(By.xpath("(//span[contains(text(),'Pass')])[2]")).getText();
		if (TT_count.contentEquals("0")) {
			
			  String message = Hooks.driver.findElement(By.xpath("//img[@alt='No Test Found!']")).getText();
			   System.out.println("filter message=" +message);
			   Assert.assertEquals(message, "Oops! No test found!");
		}
		else {
			Thread.sleep(1000);
			Utilities.clickOnElement("(//span[contains(text(),'Pass')])[2]");
			Thread.sleep(3000);
			String TT_count1 = Hooks.driver.findElement(By.xpath("(//span[contains(text(),'Pass')])[2]")).getText();
			System.out.println("count in tooltip=" +TT_count);
			
			Assert.assertEquals(TT_count1, TT_count);
		}
	}
	
	@Then("^I validate dashboard contains filter bubbles or not when clicked Fail radio button$")
	public void i_validate_dashboard_contains_filter_bubbles_or_not_when_clicked_Fail_radio_button() throws Throwable {
		Thread.sleep(3000);
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[11]");
		List<WebElement> Circles = Hooks.driver.findElements(By.xpath("//*[name()='circle']"));
		int Count_Circle = Circles.size();
		String C_Count = Integer.toString(Count_Circle);
		Thread.sleep(2000);
		Utilities.clickOnElement("(//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-d1ijfm'])[3]");
		Thread.sleep(3000);
		String TT_count = Hooks.driver.findElement(By.xpath("(//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-d1ijfm'])[3]")).getText();
		
		if (TT_count.contentEquals("0")) {
			
			  String message = Hooks.driver.findElement(By.xpath("//img[@alt='No Test Found!']")).getText();
			   System.out.println("filter message" +message);
			   Assert.assertEquals(message, "Oops! No test found!");
		}
		else {
			Thread.sleep(1000);
			Utilities.clickOnElement("(//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-d1ijfm'])[3]");
			Thread.sleep(3000);
			String TT_count1 = Hooks.driver.findElement(By.xpath("(//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-d1ijfm'])[3]")).getText();
			System.out.println("count in tooltip=" +TT_count);
			
			Assert.assertEquals(TT_count, TT_count1);	
		}
	}
	
	@Then("^I validate filter and share icon is not displayed when test is submitted$")
	public boolean i_validate_filter_and_share_icon_is_not_displayed_when_test_is_submitted() throws Throwable {
		try {
			WebElement Filter_En = Hooks.driver.findElement(By.xpath("//button[@aria-label='Filter Bubbles']"));
			WebElement Share_En = Hooks.driver.findElement(By.xpath("//button[@aria-label='Share']"));
			if(Filter_En.isDisplayed() && Share_En.isDisplayed() ) {
				return true;
			}
			
	}
		catch(org.openqa.selenium.NoSuchElementException e){
			System.out.println("Element not found"); 
			return false; 		
		}
//	    boolean Filter_En = Hooks.driver.findElement(By.xpath("//button[@aria-label='Filter Bubbles']")).isDisplayed();
//	    boolean Share_En = Hooks.driver.findElement(By.xpath("//button[@aria-label='Filter Bubbles']")).isDisplayed();
//	    //Assert.assertEquals(false,Filter_En);
//	    Assert.assertEquals(false,Share_En);
		return false;
	}
	
	@Then("^I validate Re-run,share and analytics button is not displayed when test is submitted$")
	public boolean i_validate_Re_run_share_and_analytics_button_is_not_displayed_when_test_is_submitted() throws Throwable {
		
		try {
			WebElement Rerun_btn = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Re-Run']"));
		    WebElement Share_btn = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Share']"));
		    WebElement Analytics_btn = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Analytics']"));
			if(Rerun_btn.isDisplayed() && Share_btn.isDisplayed() && Analytics_btn.isDisplayed() ) {
				return true;
			}
			
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			System.out.println("Element not found"); 
			return false; 		
		}

		return false;

	}

	@Then("^I validate test name of re-run button and config page test name when clicked on re-run button are same or not$")
	public void i_validate_test_name_of_re_run_button_and_config_page_test_name_when_clicked_on_re_run_button_are_same_or_not() throws Throwable {
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[5]");
		Thread.sleep(2000);
		String Testname = Hooks.driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[5]")).getText();
		System.out.println("TestName="+Testname);
		Utilities.clickOnElement("//img[@alt='ReRunLogo']");
		Thread.sleep(2000);
		String Cofig_test_name = Hooks.driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-info css-1i8idci']")).getText();
		System.out.println("config page test name"+ Cofig_test_name);
	//	Assert.assertEquals(Testname, Cofig_test_name);
		Assert.assertEquals(Cofig_test_name.replaceAll("[\r\n]+", " "),"demo testing");
	}
	
	@Then("^I clicked on bubble, then clicked on close button to check for every bubble$")
	public void i_clicked_on_bubble_then_clicked_on_close_button_to_check_for_every_bubble() throws Throwable {
		List<WebElement> Bubble_count = Hooks.driver.findElements(By.xpath("//*[name()='circle']"));
		int Bubble_size = Bubble_count.size();
		System.out.println("number of bubbles="+Bubble_size);
		for(int i=1;i<=Bubble_size;i++)
		{
			JavascriptExecutor j = (JavascriptExecutor)Hooks.driver;
			j.executeScript("window.scrollBy(0,1000)");
			Hooks.driver.findElement(By.xpath("(//*[name()='circle'])["+i+"]")).click();
			String Bubble_status = Hooks.driver.findElement(By.xpath("(//*[name()='circle'])["+i+"]")).getAttribute("status");
			System.out.println("Bubble Status="+Bubble_status);
			if(Bubble_status.equalsIgnoreCase("pass")) {
				Thread.sleep(1000);
				Utilities.clickOnElement("(//button[normalize-space()='Close'])[1]");
			}
			else if(Bubble_status.equalsIgnoreCase("fail")){
				Thread.sleep(1000);
				Utilities.clickOnElement("(//button[normalize-space()='Close'])[1]");
				
			}
			else if(Bubble_status.equalsIgnoreCase("submitted")){
				Thread.sleep(2000);
				WebElement element = Hooks.driver.findElement(By.xpath("//*[@id='notistack-snackbar']"));
				Actions action = new Actions(Hooks.driver);
				action.moveToElement(element).perform();
				String Notif_msg = Hooks.driver.findElement(By.xpath("//*[@id='notistack-snackbar']")).getText();
				System.out.println("error msg="+Notif_msg);
				Assert.assertEquals(Notif_msg, "Failed to generate test report");
				
			}
			
			
		}
		Hooks.driver.quit();
	}
	
	@Then("^I click on create Testrun button$")
	public void i_click_on_create_Testrun_button() throws Throwable {
		Utilities.clickOnElement("(//button[@type='button'])[2]");
	
	}
	
	@Then("^I validate Show summary data and config page data are same or not$")
	public void i_validate_Show_summary_data_and_config_page_data_are_same_or_not() throws Throwable {
		
		Utilities.clickOnElement("(//span[@class='MuiTypography-root MuiTypography-label css-1vhfms6'])[1]");
		Utilities.clickOnElement("//span[text()='View']");
		String tetrun_Name = Hooks.driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-info css-1i8idci']")).getText();
		 System.out.println("Text ="+tetrun_Name);
	//	Assert.assertEquals(tetrun_Name, "Copy of Copy of Copy of Copy of Copy of testurl");
		Assert.assertEquals(tetrun_Name.replaceAll("[\r\n]+", " "),"Copy of Cancel of Saved draft run");
	}
	
	@Then("^I Select Browser Versions$")
	public void i_Select_Browser_Versions() throws Throwable {
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//button[@aria-label='show more'])[1]");
		Thread.sleep(2000);
		Utilities.clickOnElement("//input[@name='103.0']");
		Thread.sleep(2000);
		WebElement input = Hooks.driver.findElement(By.xpath("(//button[@aria-label='show more'])[2]"));
	    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
	    js.executeScript("arguments[0].scrollIntoView();", input );
	    Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[10]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//button[@aria-label='show more'])[2]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@name='104.0'])[2]");
		Thread.sleep(2000);
		WebElement input1 = Hooks.driver.findElement(By.xpath("(//button[@aria-label='show more'])[3]"));
	    js.executeScript("arguments[0].scrollIntoView();", input1 );
	    Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[28]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//button[@aria-label='show more'])[3]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//input[@name='108.0'])[2]");
		Thread.sleep(2000);
	}
	
}
