Feature: User can be register in site

  @AEregisterTest
  Scenario: User can be register in site

    Given Navigate to url 'automationUrl'
    Then Verify that home page is visible successfully
    And Click on Signup-Login button
    Then Verify New User Signup! is visible
    And Enter name and email address
    Then Click Signup button
    And Verify that ENTER ACCOUNT INFORMATION is visible
    And Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox Sign up for our newsletter!
    And Select checkbox Receive special offers from our partners!
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And Click Create Account button
    And Verify that ACCOUNT CREATED! is visible
    Then Click Continue button
    And Verify that Logged in as username is visible
    Then Click Delete Account button
    And Verify that ACCOUNT DELETED! is visible and click Continue button
    And close page

    @CreateAccountTest
    Scenario: User can be register with specific username and password
    Given Navigate to url 'automationUrl'
    Then Verify that home page is visible successfully
    And Click on Signup-Login button
    Then Verify New User Signup! is visible
    And Enter name and email address
    Then Click Signup button
    And Verify that ENTER ACCOUNT INFORMATION is visible
    And Fill details: Title, Name, Email, Password, Date of birth for mahmut
    And Select checkbox Sign up for our newsletter!
    And Select checkbox Receive special offers from our partners!
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And Click Create Account button
    And Verify that ACCOUNT CREATED! is visible
    Then Click Continue button
    And Verify that Logged in as username is visible registered user
    And close page

    @AEpositiveLoginTest
    Scenario: User can be login correct username and password
      Given Navigate to url 'automationUrl'
      Then Verify that home page is visible successfully
      And Click on Signup-Login button
      And Verify Login to your account is visible
      Then Enter correct email address and password
      And Click login button
      And Verify that Logged in as username is visible registered user
      Then Click Delete Account button
      And Verify that ACCOUNT DELETED! is visible and click Continue button
      And close page

      @AEnegativeLoginTest
      Scenario: User can not be login invalid username and password
        Given Navigate to url 'automationUrl'
        Then Verify that home page is visible successfully
        And Click on Signup-Login button
        And Verify Login to your account is visible
        Then Enter incorrect email address and password
        And Click login button
        Then Verify error Your email or password is incorrect! is visible
        And close page

      @AElogoutTest
      Scenario: User can be log out
        Given Navigate to url 'automationUrl'
        Then Verify that home page is visible successfully
        And Click on Signup-Login button
        And Verify Login to your account is visible
        Then Enter correct email address and password
        And Click login button
        And Verify that Logged in as username is visible registered user
        Then Click Logout button
        And Verify that user is navigated to login page
        And close page