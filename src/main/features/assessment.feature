Feature: Testing Pet Clinic

	Scenario: U1
    Given a vet
    When I navigate to All Owners
    And I select any owner
    Then I can see the visits available for animals

	Scenario: U2
    Given an admin
    When I update a record
    Then the correct details are now shown

	Scenario: U3
    Given an admin
    When I delete a animal
    Then animal is not displayed anymore
	
	Scenario: U5
    Given an admin
    When I add new records
    Then the records are correct
	
	Scenario: U5
    Given an admin
    When I add new owners to the records
    Then the details show the change

 