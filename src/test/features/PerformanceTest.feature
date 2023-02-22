Feature: Create Test Functionality for Performance Test and check Performance test core functionalities

  Background:
    Given I on aiTest Login Page
    Then I enter Username
    And I enter Passowrd
    Then I click on SignIn button
    
     ##Check Performance test core functionalities
    
    @Smoke
    Scenario: To Check whether Create Test button is clickable
    Then I clicked on Performance Test Icon
    Then I clicked on Create Testrun button
    Then I validate I am on create Testrun page
    
    @Functional
    Scenario: To Check error message of Testname field when it not filled
    Then I clicked on Performance Test Icon
    Then I clicked on Create Testrun button
    When I Clicked on Testrun name and kept filed empty
    Then I validate error message appears for Testrun name field 
    
    @Functional
    Scenario: To Check error message of Project field when it not filled
    Then I clicked on Performance Test Icon
    Then I clicked on Create Testrun button
    When I Clicked on Project and kept filed empty
    Then I validate error message appears for project field
    
    #@Functional
    #Scenario: To verify newly added project is updated in project dropdown list
    #Then I clicked on Performance Test Icon
    #Then I clicked on Create Testrun button
    #Then I click on add project button and added new project as "Aitest"
    #Then I validate newly added project as "Aitest" updated in dropdown list or not
    #Then I verify the list
    
    @Functional
    Scenario: To check error messages for all repo details field
    Then I clicked on Performance Test Icon
    Then I clicked on Create Testrun button
    Then I click on all the fields of repo details and kept empty field
    Then I validate all the error messages of the repo details field
    
    @Functional
    Scenario: To check error messages for all Your Automation code details field
   Then  I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I clicked on Your Automation Code radio button
    Then I click on all the fields of automation code and kept empty field
    Then I validate all the error messages of the automation code field
    
    @Smoke
    Scenario: To verify upload button is enable after selecting file,also verify file is uploaded Successfully
    Then I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I clicked on Your Automation Code radio button
    Then I clicked on Upload zip file button and select file 
    Then I validate Upload button is visible and click on it
    Then I vallidate file is uploaded successfully
    
    @Functional
    Scenario: To verify after clicking on cancel button upload button disable or not
    Then I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I clicked on Your Automation Code radio button
    Then I clicked on Upload zip file button and select file
    Then I click on Cancel button
    Then I validate Upload button is disabled
    
    @Functional
    Scenario: To verify the slider count and text field count of max users till 100 users
    Then I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I checked the count of slider and text field
    
     @Functional
    Scenario: To verify the slider count and text field count of Total_duration till 100 users
    Then I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I checked the count of slider and text field of Total_duration
    
    @Functional
    Scenario: To verify the slider count and text field count of Ramp up time till 100 users
    Then I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I checked the count of slider and text field of Ramp up time
    
    @Smoke
    Scenario: To verify when clicked on Run It Now button without filling any details error message displays
    Then I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I click on Run It Now button without filling details
    Then I validate all error message
    
    @Smoke
    Scenario: Try to add existing project from add project and check error message popup
    Then I clicked on Performance Test Icon
    Then I clicked on Create Testrun button
    Then I click on add project button and added new project as "aitest" and validate error message popup
   
   @Smoke
    Scenario: Try to Enter existing project name on project field and error message popup after click on Add button
    Then I clicked on Performance Test Icon
    Then I clicked on Create Testrun button
    When I Enter Project name as "Marxeed" on project field and validate it
    
   @Smoke
    Scenario: To validate when user goes back to dashboard page when user is on config.page of 
              selected test by clicking it on Performance Test text button 
    Then I clicked on Performance Test Icon
    Then I clicked on Existing Created Testrun
    Then I verified user is on dasboard when clicked on Performance test button
    
   @Functional
     Scenario: To validate data of show summary of dashboard page and confi.page data of selected test are same
     Then I clicked on Performance Test Icon 
     Then I validate show summary data and config.page data are same or not
     
    @Smoke
    Scenario: Verify that the share button works properly
    When I clicked on Performance Test Icon 
    Then I clicked on Existing Created Testrun
    Then I clicked on Share button
    Then I Enter Emailid as "suvarna.kanawade@appliedaiconsulting.com"
    And  I Clicked on Send button
    And  I validate Message popup
    
     @Smoke
    Scenario: Select First Testrun and second Testrun and click on compare button and validate Testrun Comparison Summary deatils(Font,Header,Spelling,space)
    When I clicked on Performance Test Icon 
    Then I Select Created  Two Testrun 
    Then I clicked on Compare button
    And  I validate Testrun Comparison Summary deatils
    
    @Smoke
    Scenario: Check summary button validate summary details
    When I clicked on Performance Test Icon 
    Then I clicked on Created Testrun
    Then I clicked on Analytics button
    And  I validate Testrun api error Summary deatils
    
    
    ##Create Test Functionality for Performance Test
    
    @Smoke
    Scenario: Create Performance Test using Zip automation code
    When I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I Enter Testrun name as "marxeedTest"
    Then I Enter Project Name as "Marxeed"
    Then I Enter Testrun Description as "TestDescription"
    Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    When I Enter Run Configuration Details
    Then I clicked on Your Automation Code radio button
    Then I clicked on Upload zip file button and select file 
    Then I clicked on Upload button
    Then I Enter Testrun Command
    Then I Enter Report Location
    And  I clicked on Run It Now button
    And  I validate Testrun getting created successfully message popup as "Performance test created successfully in Marxeed project"
    
     @Smoke
    Scenario: Create Performance Test using Repo details
    When I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
     Then I Enter Testrun name as "Test1"
    Then I Enter Project Name as "Default"
    Then I Enter Testrun Description as "TestDescription"
    Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    When I Enter Run Configuration Details
    Then I Enter Repo Details
    And  I clicked on Run It Now button
    And  I validate Testrun getting created successfully message popup as "Performance test created successfully in Default project"
    
    @Smoke
    Scenario: Re-run the Created Testrun
    When I clicked on Performance Test Icon 
    Then I clicked on Created Testrun
    Then  I clicked on Copy and Run button
    Then  I clicked on Run button
    And  I validate Testrun getting Rerunning successfully message popup as "Re-running test"
    
    @Smoke
    Scenario: Create draft Testrun on  Performance Test using Zip automation code
    When I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I Enter Testrun name as "MarxeedTest"
    Then I Enter Project Name as "Marxeed"
    Then I Enter Testrun Description as "TestDescription"
    Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    When I Enter Run Configuration Details
    Then I clicked on Your Automation Code radio button
    Then I clicked on Upload zip file button and select file 
    Then I clicked on Upload button
    Then I Enter Testrun Command
    Then I Enter Report Location
    And  I clicked on Save button
    And  I validate Testrun getting created successfully message popup as "Performance test saved successfully"
    
     @Smoke
    Scenario: Create draft Testrun on  Performance Test using Repo details
    When I clicked on Performance Test Icon 
    Then I clicked on Create Testrun button
    Then I Enter Testrun name as "DemoTest"
    Then I Enter Project Name as "Marxeed"
    Then I Enter Testrun Description as "TestDescription"
    Then I Enter Testrun Aut URL as "https://app.marxeed.com/home"
    When I Enter Run Configuration Details
    Then I Enter Repo Details
    And  I clicked on Save button
    And  I validate Testrun getting created successfully message popup as "Performance test saved successfully"
    
    @Smoke
    Scenario: Re-run the draft Created Testrun
    When I clicked on Performance Test Icon 
    Then I clicked on Created draft Testrun 
    Then I clicked on Run Button
    Then I clicked on Run button
    And  I validate Testrun getting Rerunning successfully message popup as "Re-running test"
    
   