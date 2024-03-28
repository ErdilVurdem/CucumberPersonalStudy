@AETests
Feature: User can be register in site

  Background:
    Given Access to 'automationUrl' home page

  @AEregisterTest
  Scenario: User can be register in site
    Given Access to SignIn Page and verify Login to your account is visible
    And Enter 'mahmut128' and 'mahmut89999@aexercise.com' address and click SignUp button and Verify that ENTER ACCOUNT INFORMATION is visible
    And Enter account informations and click create account button
    And Verify that ACCOUNT CREATED! and Logged in as username visible
    Then Click Delete Account button and Verify that ACCOUNT DELETED! is visible
    And close page

    @CreateAccountTest
    Scenario: User can be register with specific username and password
      Given Access to SignIn Page and verify Login to your account is visible
    And Enter 'mahmut' and 'mahmut123@aexercise.com' address and click SignUp button and Verify that ENTER ACCOUNT INFORMATION is visible
    And Enter account informations and click create account button for mahmut
    And Verify that Logged in as username is visible registered user
    And close page

    @AEpositiveLoginTest
    Scenario: User can be login correct username and password
      Given Access to SignIn Page and verify Login to your account is visible
      Given Login with correct email and password
      Then Click Delete Account button and Verify that ACCOUNT DELETED! is visible
      And close page

      @AEnegativeLoginTest
      Scenario: User can not be login invalid username and password
        Given Access to SignIn Page and verify Login to your account is visible
        Given Login with incorrect email and password
        Then Verify error Your email or password is incorrect! is visible
        And close page

      @AElogoutTest
      Scenario: User can be log out
        Given Access to SignIn Page and verify Login to your account is visible
        Given Login with correct email and password
        Then Click Logout button
        And Verify that user is navigated to login page
        And close page

      @AERegisterWithExistingMail
      Scenario: User can not create account with exist email
        Given Access to SignIn Page and verify Login to your account is visible
        Given Enter already registered 'aeValidEmail' address and verify error 'Email Address already exist!' is visible
        And close page

     @AEContactUsTest
     Scenario: User can be fill the contact us form
       Given Click on ' Contact us' button and Verify 'Get In Touch' is visible
       And fill contact form, upload 'Flip-Logo' image and click Submit button
       And Verify 'Success! Your details have been submitted successfully.' is visible
       And Click Home button and verify that landed to 'automationTitle' successfully
       And close page

     @AETestCasePageTest
     Scenario: User can be access to test case page
       Given Click on ' Test Cases' button and Verify 'Test Cases' is visible
       And close page

     @AEProductsTest
     Scenario Outline: User can be access products page and do necessary actions
       Given Click on ' Products' button and Verify 'All Products' is visible
       And Scroll page 400 pixel
       And Click First Elements View Product Button
       And Verify '<Product Features>' is visible
       And close page
       Examples:
         | Product Features  |
         |Availability:      |
         |Condition:         |
         |Brand:             |

     @SearchPorductTest
     Scenario: User can be search in product page
       Given Click on ' Products' button and Verify 'All Products' is visible
       And Enter 'Dress' in search input, click search button and verify Searched Products is visible
       And Verify all the products related to search are visible
       And close page

#


