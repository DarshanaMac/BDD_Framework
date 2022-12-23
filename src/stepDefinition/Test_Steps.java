package stepDefinition;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Steps {

	public static WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		/*Initiate chrome
		 * 
		 * CHROME BROWSER
		 */
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);

		driver.get("https://buggy.justtestit.org/");
		driver.manage().window().maximize();
	}

	@When("^User Navigate to registration Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		// click on register button
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

	@And("^User enters registration details$")
	public void User_enters_registration_details(DataTable registerdata) throws Throwable {
		/* get data from feature file
		Register as new user
		*/
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(registerdata.row(1).get(0));
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(registerdata.row(1).get(1));
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(registerdata.row(1).get(2));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(registerdata.row(1).get(3));
		driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(registerdata.row(1).get(4));
		isAllPresent(registerdata.row(1).get(3));
		driver.findElement(By.xpath("//button[text()='Register']")).submit();
	}


	@When("^User enters valid username and password$")
	public void User_enters_valid_username_and_password(DataTable usercredentials) throws Throwable {
		//Enter username and password
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys(usercredentials.row(1).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(usercredentials.row(1).get(1));
		driver.findElement(By.xpath("//button[text()='Login']")).click();

	}

	@And("^Verify Login Success$")
	public void Verify_Login_Success() throws Throwable {
		//Check user login success or not
		pause();
		boolean status = driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
		Assert.assertEquals(status, true);
		driver.quit();
	}

	@And("^Click on Alfa Romeo logo$")
	public void Click_on_Alfa_Romeo_logo() throws Throwable {
		//Sroll page and click on  Alfa Romeo
		driver.findElement(By.xpath("//img[@title='Alfa Romeo']")).click();
		pause();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}

	@And("^Vote to car$")
	public void Vote_to_car() throws Throwable {
		// Vote for car
		driver.findElement(By.xpath("//a[text()='View more'][1]")).click();
		String currentvote = driver.findElement(By.xpath("//div[@class='card'][2]/div[1]/h4/strong")).getText();
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("MyVote");
		driver.findElement(By.xpath("//button[text()='Vote!']")).click();
		int currentVoteInt = Integer.parseInt(currentvote);
		String afterVote = driver.findElement(By.xpath("//div[@class='card'][2]/div[1]/h4/strong")).getText();

		Assert.assertEquals(currentVoteInt, Integer.parseInt(afterVote));
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		//Check Login Success message
		pause();
		WebElement element = driver.findElement(By.xpath("//div[normalize-space(text())='Registration is successful']"));

		boolean status = element.isDisplayed();
		Assert.assertEquals(status, true);
		driver.quit();
	}

	public static String isAllPresent(String str) {
		// contains uppercase, lowercase
		// special character & numeric value and length
		String status=null;
		if (str.length()>=8) {
			String regex = "^(?=.*[a-z])(?=." + "*[A-Z])(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?]).+$";

			// Compile the ReGex
			Pattern p = Pattern.compile(regex);

			// Find match between given string
			// & regular expression
			Matcher m = p.matcher(str);

			// Print Yes if string
			// matches ReGex
			if (m.matches()) {
				status="YES";
				return "yes";
			}
			else
				System.out.println("No");
			status="NO";
		}
		return status;
		
	}

	public void pause() {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
}
