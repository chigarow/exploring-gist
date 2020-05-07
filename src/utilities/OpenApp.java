package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.OperatingSystem;

public class OpenApp {
	public static String projectDir = System.getProperty("user.dir");
	public static WebDriver driver = null;
	
	public static WebDriver LaunchBrowser (String browser) {
		OperatingSystem os = new OperatingSystem();
		String osName = os.getOS();
		String driverPath =  projectDir + "/driver/"+ osName; 
		
		if(browser.toLowerCase() == "firefox") {
			if(osName == "windows") {
				System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver.exe");
			}else if (osName == "macos") {
				System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
			}
			driver = new FirefoxDriver();
			
		} else {
			if(osName == "windows") {
				System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
			}else if (osName == "macos") {
				System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
			}
			driver = new ChromeDriver();
			
		}
		return driver;
	}
	
	public static void OpenURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static WebDriver OpenBrowser(String BrowserName, String url){
		LaunchBrowser(BrowserName);
		OpenURL(url);
		return driver;
		}
	
}