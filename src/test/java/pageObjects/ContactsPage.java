package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://screenplay-contacts.herokuapp.com/")
public class ContactsPage extends PageObject {

	@FindBy(xpath = "//button[text()='New']")
	WebElement NewButton;

	@FindBy(xpath = "//input[@name='contact-name']")
	WebElement Name;

	@FindBy(xpath = "//input[@name='contact-email']")
	WebElement Email;

	@FindBy(xpath = "//input[@name='contact-phone-mobile']")
	WebElement Mobile;

	@FindBy(xpath = "//input[@name='contact-phone-work']")
	WebElement WorkPhone;

	@FindBy(xpath = "//button[text()='Create']")
	WebElement CreateButton;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement UpdateButton;

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement DeleteButton;
	
	@FindBy(xpath = "/html/body/app-root/div/contact-list/div/div[1]/ul")
	WebElement ContactList;

	public WebElement ContactToBeOperatedOn(String fname) {
		return find(By.xpath("//li[contains(text(),'"+fname+"')]")); 
	}
	 
	public void createNewContact(String name, String email, String mobile, String workphone) throws InterruptedException {
         NewButton.click();
         Name.sendKeys(name);
         Email.sendKeys(email);
         Mobile.sendKeys(mobile);
         WorkPhone.sendKeys(workphone);
         CreateButton.click();
         waitFor(ContactToBeOperatedOn(name));
	}
	public void createContactIsSuccessful(String name) {
        assertTrue(ContactToBeOperatedOn(name).isDisplayed());
	}
	public void updateContact(String originalname, String name, String email, String mobile, String workphone) {
		ContactToBeOperatedOn(originalname).click();
		Name.clear();
        Name.sendKeys(name);
        Email.clear();
        Email.sendKeys(email);
        Mobile.clear();
        Mobile.sendKeys(mobile);
        WorkPhone.clear();
        WorkPhone.sendKeys(workphone);
        UpdateButton.click();
	}
	public void updateContactIsSuccessful(String name, String email, String mobile, String workphone) {
         assertTrue(ContactToBeOperatedOn(name).isDisplayed());
         //ContactToBeOperatedOn(name).click();
         assertTrue(Name.getText().equals(name));
         assertTrue(Email.getText().equals(email));
         assertTrue(Mobile.getText().equals(mobile));
         assertTrue(WorkPhone.getText().equals(workphone));
	}
	public void deleteContact(String name) {
		ContactToBeOperatedOn(name).click();
		DeleteButton.click();
	}
	public void deleteContactIsSuccessful(String name) {
		//assertTrue(!(ContactList.getText().contains(name)));
		List<WebElementFacade> elem = findAll(By.xpath("//li[contains(text(),'"+name+"')]"));
		assertTrue(elem.size()==0);
	}

}
