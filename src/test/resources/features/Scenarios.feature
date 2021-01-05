Feature: QualityMinds Navigation

  @Test1
  Scenario: Test case 1
    Given A user go to main page
    And Click on contact
    Then Verify if the page contains email address
    And Navigate back to main page
    And Click on Kontakt & ANFAHRT
    Then Verify if the page displayed