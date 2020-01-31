Contacts story
					 
Scenario:  Validate whether user is able to create a contact
Given user is on the contacts page
When user creates a contact
Then the contact should be visible on the screen

Scenario:  Validate whether user is able to update a contact
Given user is on the contacts page
When user updates a contact
Then the update contact should be visible on the screen

Scenario:  Validate whether user is able to delete a contact
Given user is on the contacts page
When user deletes a contact
Then the deleted contact should not be visible on the screen
					 
