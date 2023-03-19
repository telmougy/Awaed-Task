package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver ;

	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver (@Optional("chrome") String browserName) {
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();
//
//		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		} 
		else if (browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}

		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("http://www.testyou.in/Login.aspx");
	}
	@AfterSuite(enabled=true)
	public void StopDriver() {
		driver.close();
	}
}
