package gistGithub;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtil;
import utilities.OpenApp;

public class ViewYourGist {

	public static String browser = "chrome";
	public static String url = "https://gist.github.com/";
	public static WebDriver driver = null;
	public static String projectDir = System.getProperty("user.dir");
	public static String filename = projectDir + "/data/gistGithubData.xlsx";
	public static String sheetname = "AddNewGist";
	@Test
	public void exploratoryGist() throws Exception{
		ExcelUtil.setExcelFile(filename, sheetname);

		String username = ExcelUtil.getCellData(1, 1);
		String password = ExcelUtil.getCellData(1, 2);

		/* Open Browser and Navigate to gist.github.com */
		driver = OpenApp.OpenBrowser(browser, url);
		WebDriverWait wait = new WebDriverWait(driver, 5);

		/* Click Login Button on Landing Page */
		objRepo.GistGithubOR.LandingPage.btn_Login(driver).click();

		/* Fill Username, Password and Click Sign In Button */
		wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.LoginPage.btn_SignIn(driver)));
		objRepo.GistGithubOR.LoginPage.txt_Username(driver).sendKeys(username);
		objRepo.GistGithubOR.LoginPage.txt_Password(driver).sendKeys(password);
		objRepo.GistGithubOR.LoginPage.btn_SignIn(driver).click();

		/* Redirected to Discover Gist Page, and go to Your Gist */
		wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.DiscoverGist.btn_AddNewGist(driver)));
		objRepo.GistGithubOR.MenuBar.btn_UserProfile(driver).click();
		objRepo.GistGithubOR.MenuBar.menu_YourGist(driver).click();

		System.out.println("View Your Gist success!!");
		driver.quit();
	}
}
