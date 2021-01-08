Feature: QualityMinds Navigation

  @Test1
  Scenario: Test case 1
    Given Go to www.qualityminds.de URL
    And Click on "Kontakt" at the top navigation bar of the page
    Then Verify if the page contains email address hello@qualityminds.de
    And Navigate back to www.qualityminds.de main page
    And Click on Kontakt & ANFAHRT link at the bottom of the page
    Then Verify if the page displayed in step 2 is the same page that is displayed in step 5

  @Test2
  Scenario: Test case 2
    Given Go to www.qualityminds.de URL
    And Hover on Portfolio at the top navigation bar of the page and verify if submenu is displayed
    And Click on Web, Automation & Mobile Testing sub option
    Then Verify that the Portfolio item of the top bar menu is highlighted
    And Click on Mobile tab in "Web - Automatisierung - Mobile" section
    Then Verify the download link for the flyer
    Then Verify if file is available via downloaded link

  @Test3
  Scenario: Test case 3
    Given Go to www.qualityminds.de URL
    And Click on the Karriere link in top navigation bar
    And Click on Bewirb Dich Jetzt! button
    And Click on Jetzt bewerben button
    Then Verify if validation messages are displayed
    And Fill the Vorname and Nachname field
    And Click on Jetzt bewerben button
    Then Verify if validation messages are displayed
    And Fill the E-mail field with an Invalid value
    And Click on Jetzt bewerben button
    And Attach file with DATEIN HOCHLADEN button
    Then Check the checkbox for Datenschutzerklarung
