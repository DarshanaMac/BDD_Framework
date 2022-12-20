package stepDefinition;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
public Test_Steps() {

	
	
	// TODO Auto-generated constructor stub
}
public static  WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		
   
        driver.get("https://buggy.justtestit.org/");
       driver.manage().window().maximize();
        
      //  driver.quit();
		}

	@When("^User Navigate to registration Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		 driver.findElement(By.xpath("//a[text()='Register']")).click();
	     
		}
	
	@And("^User enters registration details$")
	public void User_enters_registration_details() throws Throwable {
		// driver.findElement(By.xpath("//a[text()='Register']")).click();
	     driver.findElement(By.xpath("//input[@id='username']")).sendKeys("darshana8");
	     driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("darshana8");
	     driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("koanra8");
	     driver.findElement(By.xpath("//input[@id='password']")).sendKeys("User@12345");
	     driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("User@12345");
	     
		}

	@And("^User password should contains capital simple and numbers$")
	public void User_password_should_contains_capital_simple_and_numbers() throws Throwable {
	
		
		}
	
	
	@When("^User enters valid username and password$")
	public void User_enters_valid_username_and_password(DataTable usercredentials) throws Throwable {
		
		 driver.findElement(By.xpath("//input[@name='login']")).sendKeys(usercredentials.row(1).get(0));
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(usercredentials.row(1).get(1));
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		}
	

	@And("^Verify Login Success$")
	public void Verify_Login_Success() throws Throwable {
	
		Thread.sleep(4000);
		boolean status=driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
		
		Assert.assertEquals(status, true);
		}
	
	@When("^Click on Alfa Romeo logo$")
	public void Click_on_Alfa_Romeo_logo() throws Throwable {
		 driver.findElement(By.xpath("//img[@title='Alfa Romeo']")).click();
		 
		}
	
	@Then("^Verify URL contains make keyword$")
	public void verify_URL_contains_make_keyword() throws Throwable {
		String currentURL=driver.getCurrentUrl();
		Assert.assertEquals(currentURL,"https://buggy.justtestit.org/make/c4u1mqnarscc72is00ng");
		 
		}
	
	
	
	
	
//	@When("^User enters UserName and Password$")
//	public void user_enters_UserName_and_Password() throws Throwable {
//		driver.findElement(By.id("log")).sendKeys("testuser_1"); 	 
//	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
//	    driver.findElement(By.id("login")).click();
//		}
//
//	@Then("^Message displayed Login Successfully$")
//	public void message_displayed_Login_Successfully() throws Throwable {
//		System.out.println("Login Successfully");
//	}
//
//	@When("^User LogOut from the Application$")
//	public void user_LogOut_from_the_Application() throws Throwable {
//		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
//	}
//
//	@Then("^Message displayed Logout Successfully$")
//	public void message_displayed_Logout_Successfully() throws Throwable {
//        System.out.println("LogOut Successfully");
//	}
	
	
	public static void isAllPresent(String str)
    {
        // ReGex to check if a string
        // contains uppercase, lowercase
        // special character & numeric value
        String regex = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // then print No
        if (str == null) {
            System.out.println("No");
            return;
        }
 
        // Find match between given string
        // & regular expression
        Matcher m = p.matcher(str);
 
        // Print Yes if string
        // matches ReGex
        if (m.matches())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
	
}
