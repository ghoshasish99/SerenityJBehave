package steps;

import net.thucydides.core.annotations.Step;
import pageObjects.*;

public class SerenitySteps {

	ContactsPage contactpage;

	@Step
	public void OpenURL() {
	   contactpage.open();
	}
	@Step
	public void createNewContact(String name, String email, String mobile, String workphone) throws InterruptedException {
		contactpage.createNewContact(name, email, mobile, workphone);
	}
	@Step
	public void createContactIsSuccessful(String name) {
		contactpage.createContactIsSuccessful(name);
	}
	@Step
	public void updateContact(String originalname, String name, String email, String mobile, String workphone) {
		contactpage.updateContact(originalname, name, email, mobile, workphone);
	}
	@Step
	public void updateContactIsSuccessful(String name, String email, String mobile, String workphone) {
		contactpage.open();
		contactpage.updateContactIsSuccessful(name, email, mobile, workphone);
	}
	@Step
	public void deleteContact(String name) {
		contactpage.deleteContact(name);
	}
	@Step
	public void deleteContactIsSuccessful(String name) {
		contactpage.open();
		contactpage.deleteContactIsSuccessful(name);
	}
	
}
