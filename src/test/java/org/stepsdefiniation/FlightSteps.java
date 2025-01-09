package org.stepsdefiniation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bass.Bassclass;
import org.bass.POM;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class FlightSteps extends Bassclass {
	Robot r;
	List<String> li;
	POM p;
	@Given("The user should be in Kayak home page")
	public void the_user_should_be_in_kayak_home_page() {
		String currenturl = currenturl();
		boolean contains = currenturl.contains("kayak");
		Assert.assertTrue(contains);
		System.out.println(currenturl);
	    
	}
	@When("The user has to select the flight and One way")
	public void the_user_has_to_select_the_flight_and_one_way() throws AWTException, InterruptedException {
		 p=new POM();
		p.getOptions().click();
		p.getOneway().click();
	}
	@Then("The user has to enter From and To")
	public void the_user_has_to_enter_from_and_to() throws AWTException {
		p.getClose().click();
		sendkeys(p.getFrom(),"los");	
		WebElement element = driver.findElement(By.xpath("(//div[@class='vPgG-name-container'])[1]"));
		click(element);
		sendkeys(p.getTO(),"new delhi");
		WebElement element2 = driver.findElement(By.xpath("(//div[@class='vPgG-name-container'])[1]"));
		element2.click();
	
	}
	@Then("The user has to enter the date")
	public void the_user_has_to_enter_the_date() {
		p.getDate().click();
	}
	@Then("The user has to select the Travellers")
	public void the_user_has_to_select_the_travellers() {
	
	}
	@Then("click the search button")
	public void click_the_search_button() {
		p.getSearch().click();
	}
	@Then("The user has to select the choosen flight and click book")
	public void the_user_has_to_select_the_choosen_flight_and_click_book() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		li=new ArrayList<String>();
		li.addAll(windowHandles);
		sleep(2000);
		if (li.size()>1) {
			driver.switchTo().window(li.get(1));
		
			
		}
		System.out.println("handled");
			sleep(8000);
			WebElement viewdeal = driver.findElement(By.xpath("(//div[@class='oVHK'])[4]"));
			viewdeal.click();
			sleep(5000);
			WebElement book = driver.findElement(By.xpath("(//div[@class='Iqt3-button-content'])[23]"));
			book.click();
			
		}

	
	@Then("The user has enterd to another application and click select")
	public void the_user_has_enterd_to_another_application_and_click_select() throws InterruptedException {

		sleep(9000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li2=new ArrayList<String>();
		li2.addAll(windowHandles);
			driver.switchTo().window(li2.get(2));
		
		WebElement select = driver.findElement(By.xpath("//button[@class='Actionable-module__root___ph-jy Button-module__root___RNgyk Button-module__root--variant-primary___3zF7+ Button-module__root--size-large___QzDFj Button-module__root--variant-primary-action___CWu4O']"));
		select.click();
	}
	@Then("The user has to select ticket type")
	public void the_user_has_to_select_ticket_type() {
		WebElement ticket = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
		ticket.click();
	   
	}
	@Then("The user has to enter traveller detalis")
	public void the_user_has_to_enter_traveller_detalis() throws AWTException {
		WebElement details = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		details.click();
		WebElement firstname = driver.findElement(By.name("passengers.0.firstName"));
		sendkeys(firstname, "bhuvi");
		WebElement lastname = driver.findElement(By.name("passengers.0.lastName"));
		sendkeys(lastname, "waran");
		WebElement gender = driver.findElement(By.name("passengers.0.gender"));
		gender.click();
		keydown();
		enterr();
		WebElement month = driver.findElement(By.xpath("(//select[@class='InputSelect-module__field___tLmBd'])[2]"));
		Select s=new Select(month);
		s.selectByIndex(1);
		WebElement date = driver.findElement(By.xpath("(//input[@type='tel'])[2]"));
		sendkeys(date, "16");
		WebElement year = driver.findElement(By.xpath("(//input[@type='tel'])[3]"));
		sendkeys(year, "2003");
		WebElement done = driver.findElement(By.xpath("(//button[@type='button'])[7]"));
		done.click();
	}
	@Then("The user has to enter email and phone number and click next")
	public void the_user_has_to_enter_email_and_phone_number_and_click_next() throws InterruptedException {
		WebElement email = driver.findElement(By.name("booker.email"));
		sendkeys(email, "bhuvi@gmail.com");
		WebElement number = driver.findElement(By.name("number"));
		sendkeys(number, "9897678678");
		WebElement next = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
		next.click();
		sleep(15000);
	    }
	@Then("The user has to click skip")
	public void the_user_has_to_click_skip() {
		WebElement skip = driver.findElement(By.xpath("//button[@class='Actionable-module__root___ph-jy Button-module__root___RNgyk Button-module__root--variant-primary___3zF7+ Button-module__root--size-large___QzDFj Button-module__root--wide___vGG-n Button-module__root--variant-primary-action___CWu4O Actionable-module__root--wide-true___V0+an']"));
		skip.click();
		
	  }
	@Then("The user has to enter Cardnumber,Expiry date and cvc")
	public void the_user_has_to_enter_cardnumber_expiry_date_and_cvc(io.cucumber.datatable.DataTable data) throws InterruptedException {
		
		sleep(5000);
		WebElement number = driver.findElement(By.xpath("(//input[@class='O9HXu4VtC_TmoOn0gszL'])[2]"));
		sendkeys(number, "1234567891123456789");
		List<String> li = data.asList();
		WebElement expdate = driver.findElement(By.name("expirationDate"));
		sendkeys(expdate, li.get(1));
		WebElement cvc = driver.findElement(By.name("cvc"));
		sendkeys(cvc, li.get(2));
	    }
	@Then("The user has to click the pay button")
	public void the_user_has_to_click_the_pay_button() {
		WebElement pay = driver.findElement(By.xpath("//div[@class='CheckoutFooter-desktop-module__ctaWrapper___CmF+d']"));
		pay.click();
		System.out.println("hi");
	    }





}
