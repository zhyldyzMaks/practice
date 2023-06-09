Feature: Register a Patient Functionality

  Scenario: Validation of Registering new patient functionality
    Given user navigates to OpenMRS system, enters username and password, chooses location 'Isolation Ward' and logs into the webpage
    When user clicks on the Register a patient button.
    And user clicks on Name button and enters first name 'Alex' and last name 'Boldy'
    And user clicks on Gender button and chooses the gender
    And user clicks on Birthday button and provides the date of birth
    And user clicks on Address button and provides the address details
    And user clicks on Phone Number button and provides the phone number
    Then user clicks the confirm button on a left side and validates the entries displayed are correct
    And user clicks green confirm button and validates the patient information is correct





