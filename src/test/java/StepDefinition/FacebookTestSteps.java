package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;

public class FacebookTestSteps {
	static WebDriver driver;
	
	@Given("user open a {string} browser")
	public void user_open_a_browser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equalsIgnoreCase("incognito")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver = new ChromeDriver(opt);
		} else {
			System.out.println("Please Enter browser name");
		}
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/reg");
	}

	@Given("user enter first name as {string} and last name as {string}")
	public void user_enter_first_name_as_and_last_name_as(String FirstName, String LastName) {
	    driver.findElement(By.name("firstname")).sendKeys(FirstName);
	    driver.findElement(By.name("lastname")).sendKeys(LastName);
	}

	@Given("user select date as {int} and month as {string} and year {int}")
	public void user_select_date_as_and_month_as_and_year(Integer Date, String Month, Integer Year) {
	   
		WebElement wbDate = driver.findElement(By.name("birthday_day"));
		Select selDate = new Select(wbDate);

		// convert Integer into String
		String date = Date.toString();

		selDate.selectByVisibleText(date);

		WebElement wbMonth = driver.findElement(By.name("birthday_month"));
		Select selMonth = new Select(wbMonth);
		selMonth.selectByVisibleText(Month);

		WebElement wbYear = driver.findElement(By.name("birthday_year"));
		Select selYear = new Select(wbYear);

		String year = Year.toString();
		selYear.selectByVisibleText(year);
	}

}
	