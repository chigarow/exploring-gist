package mainTesting;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import testData.DataVariables;
import utilities.OpenApp;

public class deleteGist {
	public static String username = DataVariables.LoginPage.username;
	public static String password = DataVariables.LoginPage.password;
	
	public static String gitdesc = DataVariables.EditGist.gitdesc;
	public static String filename = DataVariables.EditGist.filename;
	public static String filecontent = DataVariables.EditGist.filecontent;
	
	public static String browser = "chrome";
	public static String url = "https://gist.github.com/";
	public static WebDriver driver = null;
	
	
  @Test
  public void exploratoryGist() throws Throwable{
	  Robot robot = new Robot();
	  /*Open Browser and Navigate to gist.github.com */
		driver = OpenApp.OpenBrowser(browser, url);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		/*Click Login Button on Landing Page */
		pageObject.GistGithub.LandingPage.btn_Login(driver).click();
		
		/* Fill Username, Password and Click Sign In Button */
		wait.until(ExpectedConditions.visibilityOf(pageObject.GistGithub.LoginPage.btn_SignIn(driver)));
		pageObject.GistGithub.LoginPage.txt_Username(driver).sendKeys(username);
		pageObject.GistGithub.LoginPage.txt_Password(driver).sendKeys(password);
		pageObject.GistGithub.LoginPage.btn_SignIn(driver).click();
		
		/*Redirected to Discover Gist Page, and go to Your Gist */
		wait.until(ExpectedConditions.visibilityOf(pageObject.GistGithub.DiscoverGist.btn_AddNewGist(driver)));
		pageObject.GistGithub.MenuBar.btn_UserProfile(driver).click();
		pageObject.GistGithub.MenuBar.menu_YourGist(driver).click();
		
		/*Select First Row Gist*/
		pageObject.GistGithub.YourGist.link_FileName(driver).click();
		
		
		/*Click Button Edit */
		wait.until(ExpectedConditions.visibilityOf(pageObject.GistGithub.YourGist.btn_Delete(driver)));
		pageObject.GistGithub.YourGist.btn_Delete(driver).click();
		Thread.sleep(200);
		
		/*Confirm Delete Gist*/
//		driver.switchTo().alert().accept();
		robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.quit();
  }
}
