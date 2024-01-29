package cucumberBDDone.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver==null) {
			
		}
		
		return new ChromeDriver();
	}

	// And user verifies that 'Dashboard' page subtitle is displayed
	/*
	 * <groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
	 */
	
}
