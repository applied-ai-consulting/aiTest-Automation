
package com.java.aitest_cukes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class StepsDefinitions {	
	public static WebDriver driver;
	private String testdriveURL;
	public static String currentDate= Utilities.dateForTodayTomorrowAndYestderday("Today");
	public static String firstname = "Automation"+Utilities.rndmNumGen(1, 100000);
	public static String commEmailID = "cucumber.automation+"+Utilities.rndmNumGen(1, 100000)+"@gmail.com";
	public static String scheduleName = "ScheduleAutomation"+Utilities.rndmNumGen(1, 100000);
	static String updateddate="";
	static String randomString="";
	static String assistantname="";
	public StepsDefinitions()
	{
		testdriveURL = System.getenv("TESTDRIVE_URL");
		if(testdriveURL == null){
			testdriveURL = System.getenv("TEST_URL");
		}
		driver = Hooks.driver;
	}

	@Given("^I on aiTest Login Page$")
	public void i_on_aiTest_Login_Page() throws Throwable {
	   driver.get("https://app.aitest.dev.appliedaiconsulting.com/");
	}
//	@Then("^I enter loginId as \"([^\"]*)\"$")
//	public void i_enter_loginId_as(String userId) throws Throwable {
//		driver.findElement(By.id("email")).sendKeys(userId);
//	}
	@Then("^I click on Continue With Google button$")
	public void i_click_on_Continue_With_Google_button() throws Throwable {
		Utilities.clickOnElement("(//button[@type='button'])[2]");//span[text()='Next']
	}
	
	@Then("^I enter Email$")
	public void i_enter_Email() throws Throwable {
		String Emailid = System.getenv("Email");
		driver.findElement(By.xpath("//div[text()='Email or phone']")).sendKeys(Emailid);
	}
	
	@Then("^I click on Next button$")
	public void i_click_on_Next_button() throws Throwable {
		Utilities.clickOnElement("//span[text()='Next']");
	}
	
	@Then("^I enter Username$")
	public void i_enter_Username() throws Throwable {
		String UserId = System.getenv("Username");
		driver.findElement(By.id("email")).sendKeys(UserId);
	}

	@Then("^I enter Passowrd$")
	public void i_enter_Passowrd() throws Throwable {
		String Pwd = System.getenv("Password");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Pwd);
	}

//	@Then("^I enter pswd as \"([^\"]*)\"$")
//	public void i_enter_pswd_as(String pwd) throws Throwable {
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd); 
//	}
	
	@Then("^I click on SignIn button$")
	public void i_click_on_SignIn_button() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Then("^I validate user logged in successfully$")
	public void i_validate_user_logged_in_successfully() throws Throwable {
		Thread.sleep(2000);
	   String Noti_msg= driver.findElement(By.id("notistack-snackbar")).getText();
	   System.out.println("Notification msg" +Noti_msg);
	   Assert.assertEquals(Noti_msg, "Log in successful");
	}

	
	@Then("^I search testname \"([^\"]*)\" in searchbar$")
	public void i_search_testname_in_searchbar(String arg1) throws Throwable {
		Thread.sleep(5000);
		Utilities.clickOnElement("(//button[@type='button'])[5]");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@id='search-test'])[1]")).sendKeys(arg1);
	
	}
	
//	@Then("^I validate Tooptip count and bubbles present on dashboard are equal$")
//	public void i_validate_Tooptip_count_and_bubbles_present_on_dashboard_are_equal() throws Throwable {
//		Thread.sleep(3000);
//		List<WebElement> Circles = driver.findElements(By.xpath("//*[name()='circle']"));
//		int Count_Circle = Circles.size();
//		String C_Count = Integer.toString(Count_Circle);
//		
//		Thread.sleep(2000);
//		Utilities.clickOnElement("//span[contains(text(),'All')]");
//		Thread.sleep(3000);
//		String TT_count = driver.findElement(By.xpath("//div[@data-foo='bar']")).getText();
//		System.out.println("count in tooltip=" +TT_count);
//		
//		Assert.assertEquals(C_Count, TT_count);
//		 
//	}
	
	@Then("^I clicked on MultiBrowser Icon$")
	public void i_clicked_on_MultiBrowser_Icon() throws Throwable {
		Thread.sleep(5000);
		Utilities.clickOnElement("(//ul[@class='MuiList-root css-okxfso'])[2]");
	}
	
	@Then("^I clicked on Performance Test Icon$")
	public void i_clicked_on_Performance_Test_Icon() throws Throwable {
		Thread.sleep(5000);
		Utilities.clickOnElement("(//ul[@class='MuiList-root css-okxfso'])[3]");
		Thread.sleep(5000);
	}
	
	@Then("^I filter for testname on multibrowser Test$")
	public void i_filter_for_testname_on_multibrowser_Test() throws Throwable {
		Thread.sleep(5000);
		Utilities.clickOnElement("(//ul[@class='MuiList-root css-okxfso'])[2]");
		Thread.sleep(5000);
		Utilities.clickOnElement("(//div[contains(@role,'button')])[1]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//li[@id='3'])[1]");
//		Thread.sleep(2000);
//		Utilities.clickOnElement("(//div[contains(@role,'button')])[2]");
//		Thread.sleep(2000);
//		Utilities.clickOnElement("(//li[@id='25eb4e62-9946-11ec-8fe0-b77919f7c4e3'])[1]");
		
//		JavascriptExecutor j = (JavascriptExecutor)driver;
//		j.executeScript("window.scrollBy(0,1000)");
//		Thread.sleep(3000);
//		Utilities.clickOnElement("(//span[normalize-space()='next'])[1]");
//		Thread.sleep(2000);
//		Utilities.clickOnElement("(//span[normalize-space()='Multi browser repo'])[1]");
		}
	
	@Then("^I applied filter for sorting of bubbles$")
	public void i_applied_filter_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
		String ActualPass_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Pass']")).getText();
		System.out.println("ActPass Text="+ActualPass_txt);
		Thread.sleep(1000);
		String Pass_txt = Hooks.driver.findElement(By.xpath("(//div[@role='button'])[3]")).getText();
		System.out.println("Pass Text="+Pass_txt);
		Assert.assertEquals(Pass_txt, ActualPass_txt);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Top Time Taken dropdown button  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Top Time taken User']")).click();
		Thread.sleep(1000);
		String ActTimeTkn_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Top Time taken User']")).getText();
		System.out.println("ActTimeTkn Text="+ActTimeTkn_txt);
		driver.findElement(By.xpath("(//input[@id='value'])[1]")).sendKeys("5"); //enter value in Top time taken section
		Thread.sleep(1000);
		String TimeTkn_txt = Hooks.driver.findElement(By.xpath("(//div[@role='button'])[4]")).getText();
		System.out.println("ActTimeTkn Text="+TimeTkn_txt);
		boolean Text_visible = TimeTkn_txt.contains(ActTimeTkn_txt);
		Assert.assertEquals(true, Text_visible);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Mozilla Firefox']");
		String ActFF_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Mozilla Firefox']")).getText();
		String ExFF_txt = Hooks.driver.findElement(By.xpath("//span[normalize-space()='Mozilla Firefox']")).getText();
		Assert.assertEquals(ExFF_txt, ActFF_txt);
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	}
	
//	@Then("^I validate result shown on dashboard after applying filter$")
//	public void i_validate_result_shown_on_dashboard_after_applying_filter() throws Throwable {
//	   Thread.sleep(1000);
//	   String message = driver.findElement(By.xpath("//span[normalize-space()='Oops! No test found!']")).getText();
//	   System.out.println("filter message" +message);
//	}
	
	@Then("^I applied filter with least time taken for sorting of bubbles$")
	public void i_applied_filter_with_least_time_taken_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Least Time taken User']")).click();
		Thread.sleep(1000);
		String ActTimeTkn_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Least Time taken User']")).getText();
		System.out.println("ActTimeTkn Text="+ActTimeTkn_txt);
		driver.findElement(By.xpath("(//input[@id='value'])[2]")).sendKeys("5"); //enter value in least time taken section
		Thread.sleep(1000);
		String TimeTkn_txt = Hooks.driver.findElement(By.xpath("(//div[@role='button'])[4]")).getText();
		System.out.println("ActTimeTkn Text="+TimeTkn_txt);
		boolean Text_visible = TimeTkn_txt.contains(ActTimeTkn_txt);
		Assert.assertEquals(true, Text_visible);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Mozilla Firefox']");
		String ActFF_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Mozilla Firefox']")).getText();
		String ExFF_txt = Hooks.driver.findElement(By.xpath("//span[normalize-space()='Mozilla Firefox']")).getText();
		Assert.assertEquals(ExFF_txt, ActFF_txt);
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	}
	
	
	@Then("^I applied filter with Pass,Top Time Taken,chrome for sorting of bubbles$")
	public void i_applied_filter_with_Pass_Top_Time_Taken_chrome_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Top Time taken User']")).click();
		driver.findElement(By.xpath("(//input[@id='value'])[1]")).sendKeys("5"); //enter value in Top time taken section
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		String ActGC_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Google Chrome']")).getText();
		String ExGC_txt = Hooks.driver.findElement(By.xpath("//span[normalize-space()='Google Chrome']")).getText();
		Assert.assertEquals(ExGC_txt, ActGC_txt);
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	}
	
	@Then("^I validate dashboard contains filter bubbles or not$")
	public void i_validate_dashboard_contains_filter_bubbles_or_not() throws Throwable {
		Thread.sleep(3000);
		List<WebElement> Circles = driver.findElements(By.xpath("//*[name()='circle']"));
		int Count_Circle = Circles.size();
		String C_Count = Integer.toString(Count_Circle);
		
		if (Count_Circle > 0) {
			Thread.sleep(2000);
			Utilities.clickOnElement("//span[contains(text(),'All')]");
			Thread.sleep(3000);
			String TT_count = driver.findElement(By.xpath("//div[@data-foo='bar']")).getText();
			System.out.println("count in tooltip=" +TT_count);
			
			Assert.assertEquals(C_Count, TT_count);
		}
		else {
			Thread.sleep(1000);
			   String message = driver.findElement(By.xpath("//span[normalize-space()='Oops! No test found!']")).getText();
			   System.out.println("filter message" +message);
			   Assert.assertEquals(message, "Oops! No test found!");
			 	
		}	
	}
	
	@Then("^I applied filter with Pass,Least Time Taken,chrome for sorting of bubbles$")
	public void i_applied_filter_with_Pass_Least_Time_Taken_chrome_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Least Time taken User']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='value'])[2]")).sendKeys("5"); //enter value in least time taken section
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	}
	
	@Then("^I applied filter with Fail,Top Time Taken,chrome for sorting of bubbles$")
	public void i_applied_filter_with_Fail_Top_Time_Taken_chrome_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Fail']"); //click on Pass button
		Thread.sleep(1000);
		String ActualFail_txt = Hooks.driver.findElement(By.xpath("//p[normalize-space()='Fail']")).getText();
		System.out.println("ActPass Text="+ActualFail_txt);
		Thread.sleep(1000);
		String Fail_txt = Hooks.driver.findElement(By.xpath("(//div[@role='button'])[3]")).getText();
		System.out.println("Pass Text="+Fail_txt);
		Assert.assertEquals(Fail_txt, ActualFail_txt);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Top Time taken User']")).click();
		driver.findElement(By.xpath("(//input[@id='value'])[1]")).sendKeys("5"); //enter value in Top time taken section
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	    
	}
	
	@Then("^I applied filter with Fail,Least Time Taken,chrome for sorting of bubbles$")
	public void i_applied_filter_with_Fail_Least_Time_Taken_chrome_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Fail']"); //click on Pass button
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Least Time taken User']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='value'])[2]")).sendKeys("5"); //enter value in Top time taken section
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	}
	
	
	@Then("^I applied filter with Fail,Top Time Taken,firefox for sorting of bubbles$")
	public void i_applied_filter_with_Fail_Top_Time_Taken_firefox_for_sorting_of_bubbles() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Fail']"); //click on Pass button
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[normalize-space()='Top Time taken User']")).click();
		driver.findElement(By.xpath("(//input[@id='value'])[1]")).sendKeys("5"); //enter value in Top time taken section
		Thread.sleep(1000);
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Mozilla Firefox']");
		
		
		Thread.sleep(1000);
		Utilities.clickOnElement("//button[normalize-space()='Apply Filter']");
	}
	
	
	@Then("^I filter testname as completed and default on Performance Test$")
	public void i_filter_testname_as_completed_and_default_on_Performance_Test() throws Throwable {
		Thread.sleep(5000);
		Utilities.clickOnElement("(//ul[@class='MuiList-root css-okxfso'])[3]");
		Thread.sleep(5000);
		Utilities.clickOnElement("(//div[contains(@role,'button')])[1]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//li[@id='3'])[1]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//div[contains(@role,'button')])[2]");
		Thread.sleep(2000);
		Utilities.clickOnElement("(//li[@id='25eb4e62-9946-11ec-8fe0-b77919f7c4e3'])[1]");
		
	}
	
	@Then("^I validate Apply Filter button is disabled when filter is not seleceted$")
	public void i_validate_Apply_Filter_button_is_disabled_when_filter_is_not_seleceted() throws Throwable {
		Thread.sleep(2000);
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
	    boolean Apply_Disable = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Apply Filter']")).isEnabled();
	    Assert.assertEquals(false, Apply_Disable);
	}
	
	
	@Then("^I validate Apply Filter button is not diabled when filtered with any status$")
	public void i_validate_Apply_Filter_button_is_not_diabled_when_filtered_with_any_status() throws Throwable {
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
		boolean Apply_Disable = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Apply Filter']")).isEnabled();
		Assert.assertEquals(false, Apply_Disable);
	}
	
	@Then("^I validate Apply Filter button is not diabled when filtered with browser$")
	public void i_validate_Apply_Filter_button_is_not_diabled_when_filtered_with_browser() throws Throwable {
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		boolean Apply_Disable = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Apply Filter']")).isEnabled();
		Assert.assertEquals(false, Apply_Disable);
	}
	
	@Then("^I validate Apply Filter button is diabled when filtered with status and browser$")
	public void i_validate_Apply_Filter_button_is_diabled_when_filtered_with_status_and_browser() throws Throwable {
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
        Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		boolean Apply_Disable = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Apply Filter']")).isEnabled();
		Assert.assertEquals(false, Apply_Disable);
	}
	
	@Then("^I validate Apply Filter button is not diabled when filtered with browser and time taken$")
	public void i_validate_Apply_Filter_button_is_not_diabled_when_filtered_with_browser_and_time_taken() throws Throwable {
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button 
		driver.findElement(By.xpath("//p[normalize-space()='Least Time taken User']")).click();
		Utilities.clickOnElement("(//div[@id='panel3d-header'])[1]"); //click on browser dropdown button
		Thread.sleep(1000);
		Utilities.clickOnElement("//p[normalize-space()='Google Chrome']");
		boolean Apply_Enable = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Apply Filter']")).isEnabled();
		Assert.assertEquals(true, Apply_Enable);
	}
	
	@Then("^I validate Apply Filter button is not diabled when filtered with status and time taken$")
	public void i_validate_Apply_Filter_button_is_not_diabled_when_filtered_with_status_and_time_taken() throws Throwable {
		Utilities.clickOnElement("//button[@aria-label='Filter Bubbles']");  //click on filter icon
		Utilities.clickOnElement("//p[normalize-space()='Pass']"); //click on Pass button
		Utilities.clickOnElement("(//div[@id='panel2d-header'])[1]"); //click on Time Taken dropdown button 
		driver.findElement(By.xpath("//p[normalize-space()='Least Time taken User']")).click();
		boolean Apply_Enable = Hooks.driver.findElement(By.xpath("//button[normalize-space()='Apply Filter']")).isEnabled();
		Assert.assertEquals(true, Apply_Enable);
	}


	static void sleepTime(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}