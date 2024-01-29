package cucumberBDDone.step;

import java.time.Duration;
import cucumberBDDone.utility.MyConfiguration;
import cucumberBDDone.utility.MyConfiguration.DriverA;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class StepLogin {

	//   GIVEN  //
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		// browser frame & time

		DriverA.getDriver().manage().window().maximize();
		DriverA.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// DriverA.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = MyConfiguration.getValue("url");
		DriverA.getDriver().navigate().to(url);
	}

	//   THEN   //
	@Then("user logs in as Developer")
	public void user_logs_in_as_Developer() {
		/*
		   Actions act = new Actions(DriverA.getDriver());
		   act.pause(Duration.ofSeconds(20)).perform();;
		 */
		String headName = DriverA.getDriver().getTitle();
		String uname = MyConfiguration.getValue("driver_username");
		String pwd = MyConfiguration.getValue("driver_password");

		System.out.println(headName);

		System.out.println(uname + "  " + pwd);
		Assert.assertEquals(MyConfiguration.getValue("title"), headName);
		DriverA.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(uname, Keys.TAB, pwd,
				Keys.RETURN);
	}

	//    AND    //
	@And("user verifies that 'Dashboard' page subtitle is displayed")
	public void user_verifies_that_Dashboard_page_subtitle_is_displayed() {

		Actions act = new Actions(DriverA.getDriver());
		act.pause(Duration.ofSeconds(7)).perform();
		String dshb= DriverA.getDriver().findElement(By.xpath("//nav//li/a/i[@class='icon-dashboard']/..")).getText();
		Assert.assertEquals(dshb,MyConfiguration.getValue("menu"));
		act.moveToElement(DriverA.getDriver().findElement(By.cssSelector(".fa-cog"))).pause(Duration.ofSeconds(2))
				.perform();
		act.moveToElement(DriverA.getDriver().findElement(By.linkText("Logout"))).click().pause(Duration.ofSeconds(4))
				.perform();

		DriverA.closeDriver();

		System.out.println("Cucumber Script Suceess!");

		
	}
}

/*

DriverA.getDriver().findElement(By.xpath(
"//img[contains(@alt,'profile')]/parent::span")).click();
DriverA.getDriver().findElement(By.linkText("Logout")).click();

*/

/*
 
@FindBy(xpath = "//input[@name='username']")
public WebElement un;

*/
