Feature: Flight Booking Process

  @COM-1234 @Regression @Booking
    Scenario: Launch the Blaze site and verify the successful Registration
    Given launch the Blaze UI Portal
    Then go to "Home" Page
    When user clicks on "Register" link
    Then Registration Page should be displayed
    When user enters the below mandatory fields
      | Name   | Company  | Email          | Password | Confirm password |
      | saname | scompany | semailid@c.com |ksdljf88# |ksdljf88#         |
    And clicks on "Register" button
    Then verify the successful Registration

  @COM-1241:
  Scenario Outline: Verify Book a flight
    Given launch the Blaze UI Portal
    When user selects the "<from>" and "<To>" cities
    Examples:
      | From City | TO City |
    And  clicks on "Find Flights" button
    Then will navigate to Flights page
    When clicks on "Choose This Flight" button
    And will navigate to Booking Details page
    And clicks on "Purchase Flight" button
    Then verify the booking confirmation




  @COM-1235 @Regression @Booking
  Scenario Outline: Verify the login for a registered user
    Given launch the Blaze UI Portal
    When user enters valid <username> and <password>
    And clicks on "login" button
    Then user will be navigated Home Page
    Examples:
      | username | password |
      | user1    | pass1    |

  @COM-1236
  Scenario: Verify the forgot password link
  @COM-1238
  Scenario: Verify the "Remember me" check box
  @COM-1239
  Scenario: Verify the Navigation back to "Welcome Page"
  @COM-1239
  Scenorio: Verify the Destination of the Week Link
  @COM-1242: Book any lowest fare flight


