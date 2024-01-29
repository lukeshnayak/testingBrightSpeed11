package cucumberBDDone.utility;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.xmlbeans.impl.values.XmlDoubleRestriction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyConfiguration {
	private static Properties pop;
	
	static {
		try {
			String path ="src/test/resources/myConfiguration.properties";
			FileInputStream fis = new FileInputStream(path);
			pop=new Properties();
			pop.load(fis);
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return pop.getProperty(key);
	}
	
	public static class DriverA{
		
		private static WebDriver driver1;
		
		public static WebDriver getDriver() {
			if (driver1==null) {
				String browser=MyConfiguration.getValue("browser");
				switch (browser) {
				case "chrome-headless":
						//WebDriverManager.chromedriver().setup();
						driver1 = new ChromeDriver();
					break;
				case "firefox-headless":
						WebDriverManager.firefoxdriver().setup();
						driver1 = new FirefoxDriver();
					break;
				case "edge-headless":
						WebDriverManager.edgedriver().setup();
						driver1 = new EdgeDriver();
					break;
				}
			}
			return driver1;
		}
		
		public static void closeDriver() {
			if (driver1!=null) {
				driver1.quit();
				driver1=null;
			}
		}
	}
	
	
}
