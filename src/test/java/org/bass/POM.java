package org.bass;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM extends Bassclass {

	public POM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='c15uy c15uy-mod-variant-default']")
	private WebElement options;
	
	@FindBy(xpath = "(//li[@role='option'])[2]")
	private WebElement oneway;
	
	@FindBy(xpath ="//div[@class='c_neb-item-close']")
	private WebElement close;
	
	@FindBy(xpath ="(//input[@type='text'])[2]" )
	private WebElement from;
	
	@FindBy(xpath ="(//input[@type='text'])[3]")
	private WebElement TO;
	
	@FindBy(xpath ="//div[@aria-label='1 February, 2025 Prices on this day are around average']" )
	private WebElement date;
	
	@FindBy(xpath ="//button[@type='submit']" )
	private WebElement search;

	public WebElement getOptions() {
		return options;
	}

	public WebElement getOneway() {
		return oneway;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getFrom() {
		return from;
	}

	public WebElement getTO() {
		return TO;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getSearch() {
		return search;
	}
	
}
