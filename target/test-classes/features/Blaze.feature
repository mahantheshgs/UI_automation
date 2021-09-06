Feature: Flight Booking Process

  @COM-1234 @Regression @Booking
    Scenario: Launch the Blaze site and verify the successful Registration
    Given launch the Blaze UI Portal
    Then go to "Home" Page
    When user clicks on "Register" link
    Then Registration Page should be displayed
    When user enters the below mandatory fields
    And clicks on "Register" button
    Then verify the successful Registration

  