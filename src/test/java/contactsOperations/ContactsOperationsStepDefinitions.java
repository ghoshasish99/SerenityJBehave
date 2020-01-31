package contactsOperations;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import steps.SerenitySteps;

public class ContactsOperationsStepDefinitions {
	@Steps
	SerenitySteps steps;
	
	@Given("user is on the contacts page")
	public void givenUserIsOnTheContactsPage() {
	  steps.OpenURL();
	}

	@When("user creates a contact")
	public void whenUserCreatesAContact() throws InterruptedException {
		steps.createNewContact("Ashish Ghosh", "Ash@gmail.com", "8018018018011", "6262626262626");
	}

	@Then("the contact should be visible on the screen")
	public void thenTheContactShouldBeVisibleOnTheScreen() {
		steps.createContactIsSuccessful("Ashish");
	}
	

	@When("user updates a contact")
	public void whenUserUpdatesAContact() {
		steps.updateContact("Ashish", "Asish", "Ash@gmail.com", "989888989898", "6262778772872");
	}

	@Then("the update contact should be visible on the screen")
	public void thenTheUpdateContactShouldBeVisibleOnTheScreen() {
		steps.updateContactIsSuccessful("Asish", "Ash@gmail.com", "989888989898", "6262778772872");
	}
	

	@When("user deletes a contact")
	public void whenUserDeletesAContact() {
		steps.deleteContact("Ashish");
	}

	@Then("the deleted contact should not be visible on the screen")
	public void thenTheDeletedContactShouldNotBeVisibleOnTheScreen() {
		steps.deleteContactIsSuccessful("Ashish");
	}

}
