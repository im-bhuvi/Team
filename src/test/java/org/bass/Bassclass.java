package org.bass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bassclass {
	public static WebDriver driver;
	public static void browserlaunch(String Browser) {
		switch (Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 driver =new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
		default:
			driver =new ChromeDriver();
		}
	}
	
	public static void url(String url) {
		driver.get(url);
	}
	public static void maxmize() {
		driver.manage().window().maximize();
	}
	public static  void timesout(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	public static  void quit() {
		driver.quit();
	}
	public static  void xpath(String path) {
		driver.findElement(By.xpath(path));
	}
	public static  void id(String id) {
		driver.findElement(By.id(id));
	}
	public static  void name(String name) {
		driver.findElement(By.name(name));
	}
	public static  void sendkeys(WebElement s,String value) {
		s.sendKeys(value);
	}
	public static  void click(WebElement c) {
		c.click();
	}
	public static  void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}
	public static String currenturl() {
	    return driver.getCurrentUrl();
	}
	public static String gettext(WebElement g) {
		String text = g.getText();
		return text;
	}
	public static String getattribute(WebElement g) {
		String attribute = g.getAttribute("value");
		return attribute;
	}
	public static  void selectbyindex(WebElement i,int index) {
		Select s=new Select(i);
		s.selectByIndex(index);
	}
	public static  void selectByVisbleText(WebElement i,String value) {
		Select s=new Select(i);
		s.selectByVisibleText(value);
	}
	public static  void selectByValue(WebElement i, String value) {
		Select s=new Select(i);
	    s.selectByValue(value);
	}
	public static  void doubleclick(WebElement d) {
		Actions a =new Actions(driver);
		a.doubleClick(d).perform();
	}
	public static void rightclick(WebElement c) {
		Actions a =new Actions(driver);
		a.contextClick(c).perform();
	}
	public static void contextclick() {
		Actions a =new Actions(driver);
		a.contextClick().perform();
	}
	
	public static void movetoelement(WebElement b) {
		Actions a =new Actions(driver);
		a.moveToElement(b).perform();
	}
	public static void dragandDrop(WebElement from,WebElement to) {
		Actions a =new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}
	public static void Scrollto(WebElement s) {
		Actions a =new Actions(driver);
		a.scrollToElement(s).perform();
	}
	public static void copy() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void paste() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void enterr() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void keydown() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static String readExcel(String filepath,String sheet,int row,int cell) throws IOException {
		File f=new File(filepath);
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet sheet2 = w.getSheet(sheet);
		Row row2 = sheet2.getRow(row);
		Cell cell2 = row2.getCell(cell);
		int cellType = cell2.getCellType();
		String value=null;
		if (cellType==1) {
			 value = cell2.getStringCellValue();
		}
		else {
			if (DateUtil.isCellDateFormatted(cell2)) {
				Date dateCellValue = cell2.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-mm-yyy");
				 value = sd.format(dateCellValue);
			}
			else {
				double numericCellValue = cell2.getNumericCellValue();
				long num=(long)numericCellValue;
				value=String.valueOf(num);
			}
			
		}
		return value;
		
	}	
	public static void Windowhandles(Integer value) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(windowHandles);
		driver.switchTo().window(li.get(value));
	}
	 

}
