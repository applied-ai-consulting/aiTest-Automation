Feature: Multibrowser test core functionalities

  Background:
    Given I on aiTest Login Page
    Then I enter Username
    And I enter Passowrd
    Then I click on SignIn button
    
    ##Check MultiBrowser test core functionalities
    
    
 @Functional
    Scenario: To verify selected test for multibrowser and test name displayed on dashboard are same
    Then I clicked on MultiBrowser Icon
    Then I validate seleted testname is same as displayed in dashboard
    
 @Functional
    Scenario: To validate status of test on dashboard and submitted filter test are same
    Then I clicked on MultiBrowser Icon
    Then I validate submitted filter testname is same as dashboard test status
    
 @Functional
    Scenario: To validate status of test on dashboard and In progress filter test are same
    Then I clicked on MultiBrowser Icon
    Then I filtered testname with In Progress option
    Then I validate Inprogress filter testname is same as dashboard test status
    
 @Functional
    Scenario: To validate status of test on dashboard and Completed filter test are same
    Then I clicked on MultiBrowser Icon
    Then I validate Completed filter testname is same as dashboard test status
    
 @Functional
    Scenario: Verification of bubble count on MultiBrowser Test Dashboard and count on Pass radio tooltip when clicked
    Then I clicked on MultiBrowser Icon
    Then I validate dashboard contains filter bubbles or not when clicked Pass radio button
    
 @Functional
    Scenario: Verification of bubble count on MultiBrowser Test Dashboard and count on Fail radio tooltip when clicked
    Then I clicked on MultiBrowser Icon
    Then I validate dashboard contains filter bubbles or not when clicked Fail radio button
    
 @Functional
    Scenario: To validate when user goes back to dashboard page when user is on config.page of 
              selected test by clicking it on Multibrowser Test text button 
    Then I clicked on MultiBrowser Icon
    Then I clicked on view config page of seletected test
    Then I verified user is on dasboard when clicked on Multibrowser test button
    
 @Functional
     Scenario: To validate analyze grpah is displayed when clicked on analyze button of selected test
     Then I clicked on MultiBrowser Icon
     Then I filtered completed test from the list 
     Then I clicked on Analyze button of selected test
     Then I validate analytics graph appears when clicked
     
 @Functional
     Scenario: To validate data of show summary of dashboard page and confi.page data of selected test are same
     Then I clicked on MultiBrowser Icon
     Then I validate Show summary data and config page data are same or not
     
 @Functional
      Scenario: To validate when clicked on Re-run button of MBT user is on same confi.page which test is selected for completed test
      Then I clicked on MultiBrowser Icon
      Then I filtered testname with Completed option
      Then I validate test name of re-run button and config page test name when clicked on re-run button are same or not
      
 @Functional
    Scenario: To validate Filter and share icon is disabled on dashboard when test is in submitted or inprogress.
    Then I clicked on MultiBrowser Icon
    Then I filtered testname with submitted option
    Then I validate filter and share icon is not displayed when test is submitted
     
 @Functional
    Scenario: To validate Re-run,share and analytics button is not displayed on dashboard when test is in submitted or inprogress.
    Then I clicked on MultiBrowser Icon
    Then I filtered testname with submitted option
    Then I validate Re-run,share and analytics button is not displayed when test is submitted
    
 @Functional
    Scenario: To check close button functionality in report drawer for Multiborwser Test
    Then I clicked on MultiBrowser Icon
    Then I filtered testname with Completed option
    Then I clicked on bubble, then clicked on close button to check for every bubble
    
     @Smoke
    Scenario: Try to add existing project from add project and check error message popup
    Then I clicked on MultiBrowser Icon
    Then I clicked on Create Testrun button
    Then I click on add project button and added new project as "aitest" and validate error message popup
   
   #@Smoke
    #Scenario: Try to Enter existing project name on project field and error message popup after click on Add button
    #Then I clicked on MultiBrowser Icon
    #Then I clicked on Create Testrun button
    #When I Enter Project name as "Marxeed" on project field and validate it
    
     @Smoke
    Scenario: Verify that the share button works properly
    When I clicked on MultiBrowser Icon
    Then I clicked on existing Created Testrun
    Then I clicked on Share button
    Then I Enter Emailid as "suvarna.kanawade@appliedaiconsulting.com"
    And  I Clicked on Send button
    And  I validate Message popup
    
     @Smoke
    Scenario: Select First Testrun and second Testrun and click on compare button and validate Testrun Comparison Summary deatils(Font,Header,Spelling,space)
    When I clicked on MultiBrowser Icon
    Then I select Created  Two Testrun 
    Then I clicked on Compare button
    And  I validate Testrun Comparison Summary deatils
    
    @Functional
    Scenario: To validate status of test on dashboard and draft filter test are same
    Then I clicked on MultiBrowser Icon
    Then I filtered testname with draft option
    Then I validate draft filter testname is same as dashboard test status
    
    
    #Create Test Functionality for MultiBrowser Test
    
    #Scenario: Create MultiBrowser Test using Zip automation code
    #When I clicked on MultiBrowser Icon
    #Then I clicked on Create Testrun button
    #Then I Enter Testrun name as "marxeedTest"
    #Then I Enter Project Name as "Marxeed"
    #Then I Enter Testrun Description as "TestDescription"
    #Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    #Then I Select Browser Versions
    #Then I Select Device Versions
    #Then I clicked on Your Automation Code radio button
    #Then I Clicked on Upload zip file button and select file
    #Then I clicked on Upload button
    #Then I Enter Testrun Command
    #Then I Enter Report Location
    #And  I clicked on Run It Now button
    #And  I Validate Testrun getting created successfully message popup as "Multi browser test created successfully in Marxeed project"
    
    
    @Smoke
    Scenario: Create MultiBrowser Test using Repo details
    When I clicked on MultiBrowser Icon 
    Then I clicked on Create Testrun button
     Then I Enter Testrun name as "MarxeedTest1"
    Then I Enter Project Name as "Default"
    Then I Enter Testrun Description as "TestDescription"
    Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    Then I Select Browser Versions
    Then I Select Device Versions
    Then I enter Repo Details
    And  I clicked on Run It Now button
    And  I validate Testrun getting created successfully message popup as "Multi browser test created successfully in Default project"
    
    @Smoke
    Scenario: Re-run the Created Testrun
    Then I clicked on MultiBrowser Icon 
    Then I clicked on existing Created Testrun
    Then I clicked on Copy and Run button
    Then I clicked on Run button
    And  I validate Testrun getting Rerunning successfully message popup as "Re-running test"
    
     #@Smoke
    #Scenario: Create draft Testrun on  MultiBrowser Test using Zip automation code
    #When I clicked on MultiBrowser Icon
    #Then I clicked on Create Testrun button
    #Then I Enter Testrun name as "Test1"
    #Then I Enter Project Name as "abc"
    #Then I Enter Testrun Description as "TestDescription"
    #Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    #Then I Select Browser Versions
    #Then I Select Device Versions
    #Then I clicked on Your Automation Code radio button
    #Then I Clicked on Upload zip file button and select file
    #Then I clicked on Upload button
    #Then I Enter Testrun Command
    #Then I Enter Report Location
    #And  I clicked on Save button
    #And  I Validate Testrun getting created successfully message popup as "Multi browser test saved successfully"
    
     @Smoke
    Scenario: Create draft Testrun on  MultiBrowser Test using Repo details
    When I clicked on MultiBrowser Icon
    Then I clicked on Create Testrun button
    Then I Enter Testrun name as "DemoTest"
    Then I Enter Project Name as "Marxeed"
    Then I Enter Testrun Description as "TestDescription"
    Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    Then I Select Browser Versions
    Then I Select Device Versions
    Then I enter Repo Details
    And  I clicked on Save button
    And  I validate Testrun getting created successfully message popup as "Multi browser test saved successfully"
    
    @Smoke
    Scenario: Re-run the draft Created Testrun
    When I clicked on MultiBrowser Icon
    Then I filtered testname with draft option
    Then I clicked on created draft Testrun
    Then I clicked on Run Button
    Then I Enter Git password
    Then I clicked on Run button
    And  I validate Testrun getting Rerunning successfully message popup as "Running the saved draft"