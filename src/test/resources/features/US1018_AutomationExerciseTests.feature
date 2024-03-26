@AETests
Feature: User can be register in site

  Background:
    Given Access to 'automationUrl' SignIn Page and verify Login to your account is visible

  @AEregisterTest
  Scenario: User can be register in site

    And Enter 'mahmut128' and 'mahmut89999@aexercise.com' address and click SignUp button and Verify that ENTER ACCOUNT INFORMATION is visible
    And Enter account informations and click create account button
    And Verify that ACCOUNT CREATED! and Logged in as username visible
    Then Click Delete Account button and Verify that ACCOUNT DELETED! is visible
    And close page

    @CreateAccountTest
    Scenario: User can be register with specific username and password

    And Enter 'mahmut' and 'mahmut123@aexercise.com' address and click SignUp button and Verify that ENTER ACCOUNT INFORMATION is visible
    And Enter account informations and click create account button for mahmut
    And Verify that Logged in as username is visible registered user
    And close page

    @AEpositiveLoginTest
    Scenario: User can be login correct username and password
      Given Login with correct email and password
      Then Click Delete Account button and Verify that ACCOUNT DELETED! is visible
      And close page

      @AEnegativeLoginTest
      Scenario: User can not be login invalid username and password
        Given Login with incorrect email and password
        Then Verify error Your email or password is incorrect! is visible
        And close page

      @AElogoutTest
      Scenario: User can be log out
        Given Login with correct email and password
        Then Click Logout button
        And Verify that user is navigated to login page
        And close page