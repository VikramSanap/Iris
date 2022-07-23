package com.iris22a.uikeywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeyword {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.err.println("Invalid Browser Name" + browserName);
		}
		System.out.println("Browser is launched successfully");

	}

	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println("Url :" + url + " is launched successfully");
	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed successfully");
	}

	public static void switcheToWindow(String byTitle ) {
		String parentWndow = driver.getWindowHandle();
		Set<String> windows	= driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {
				System.out.println("Switched to window :"+byTitle);
				break;
			}
		}
		}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}

	public static void hitButton(int keyCode) {
		Robot robo = null;
		try {
			robo=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robo.keyPress(keyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt: elements) {
			texts.add(elmnt.getText());
		}
		return texts;
		
		
	}

}
