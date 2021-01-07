Feature: QualityMinds Navigation

  @Test1
  Scenario: Test case 1
    Given Go to www.qualityminds.de URL
    And Click on Kontakt
    Then Verify if the page contains email address
    And Navigate back to main page
    And Click on Kontakt & ANFAHRT
    Then Verify if the page displayed

  @Test2
  Scenario: Test case 2
    Given Go to www.qualityminds.de URL
    And Go to Portfolio and verify
    And Click on Web
    Then Verify that the Portfolio is highlighted
    And Click on Mobile tab
    Then Verify the download link
    Then Verify if file is available

  @Test3
  Scenario: Test case 3
    Given Go to www.qualityminds.de URL
    And Click on Karriere
    And Click on Bewirb
    And Click on Jetzt
    Then Verify if validation messages are displayed
    And Fill the Vorname and Nachname field
    And Click on Jetzt
    Then Verify if validation messages are displayed
    And Fill the Email field
    And Click on Jetzt
    And Attach file
    Then Check the checkbox
