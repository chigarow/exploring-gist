package mainTesting;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testData.DataVariables;
import utilities.OpenApp;

public class addNewGist {
	public static String username = DataVariables.LoginPage.username;
	public static String password = DataVariables.LoginPage.password;
	
	public static String gitdesc = DataVariables.AddNewGist.gitdesc;
	public static String filename = DataVariables.AddNewGist.filename;
	public static String filecontent = DataVariables.AddNewGist.filecontent;
	
	public static String browser = "chrome";
	public static String url = "https://gist.github.com/";
	public static WebDriver driver = null;
  @Test
  public void exploratoryGist() {
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
		
		/*Redirected to Discover Gist Page, and add new Gist */
		wait.until(ExpectedConditions.visibilityOf(pageObject.GistGithub.DiscoverGist.btn_AddNewGist(driver)));
		pageObject.GistGithub.DiscoverGist.btn_AddNewGist(driver).click();
		
		/*Set New File Name*/
		wait.until(ExpectedConditions.visibilityOf(pageObject.GistGithub.AddNewGist.txt_FileName(driver)));
		pageObject.GistGithub.AddNewGist.txt_GistDesc(driver).sendKeys(gitdesc);
		pageObject.GistGithub.AddNewGist.txt_FileName(driver).sendKeys(filename);
		pageObject.GistGithub.AddNewGist.txt_FileEditor(driver).sendKeys(filecontent);
		pageObject.GistGithub.AddNewGist.btn_CreatePublicGist(driver).click();
		
		/*Verify Created Gist */
		pageObject.GistGithub.MenuBar.btn_UserProfile(driver).click();
		pageObject.GistGithub.MenuBar.menu_YourGist(driver).click();
		String fileNameSaved = pageObject.GistGithub.YourGist.lbl_FileName(driver).getText();
		if(!fileNameSaved.contains(filename)) {
			org.testng.Assert.fail("File Name was Different!");
		}else {
			System.out.println("Add new gist success!!");
		}
		
		driver.quit();
  }
}
