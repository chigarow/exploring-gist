package gistGithub;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.OpenApp;
import utilities.ExcelUtil;

public class AddNewGist {
	public static String browser = "chrome";
	public static String url = "https://gist.github.com/";
	public static WebDriver driver = null;
	public static String projectDir = System.getProperty("user.dir");
	public static String filename = projectDir + "/data/gistGithubData.xlsx";
	public static boolean firstRun = true;
	public static String sheetname = "AddNewGist";
	public static WebDriverWait wait = null;
	@Test
	public void exploratoryGist() throws Exception {
		ExcelUtil.setExcelFile(filename, sheetname);

		int totalRow = ExcelUtil.totalDataRow(filename, sheetname);
		for (int i = 1; i <= totalRow; i++) {
			String username = ExcelUtil.getCellData(i, 1);
			String password = ExcelUtil.getCellData(i, 2);
			String gitdesc = ExcelUtil.getCellData(i, 3);
			String filename = ExcelUtil.getCellData(i, 4);
			String filecontent = ExcelUtil.getCellData(i, 5);
			

			/* Navigate to gist.github.com */
			if (firstRun) {
				/* Open Browser */
				driver = OpenApp.LaunchBrowser(browser);
				wait = new WebDriverWait(driver, 5);

				OpenApp.OpenURL(url);
				/* Click Login Button on Landing Page */
				Assert.assertEquals(objRepo.GistGithubOR.LandingPage.btn_Login(driver).isDisplayed(),true, "Login Button Not Found");
				objRepo.GistGithubOR.LandingPage.btn_Login(driver).click();
				
				

				/* Fill Username, Password and Click Sign In Button */
				wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.LoginPage.btn_SignIn(driver)));
				Assert.assertEquals(objRepo.GistGithubOR.LoginPage.btn_SignIn(driver).isDisplayed(), true);
				objRepo.GistGithubOR.LoginPage.txt_Username(driver).sendKeys(username);
				objRepo.GistGithubOR.LoginPage.txt_Password(driver).sendKeys(password);
				objRepo.GistGithubOR.LoginPage.btn_SignIn(driver).click();

				firstRun = false;
			}

			driver.navigate().to("https://gist.github.com");

			/* Redirected to Discover Gist Page, and add new Gist */
			wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.DiscoverGist.btn_AddNewGist(driver)));
			Assert.assertEquals(objRepo.GistGithubOR.DiscoverGist.btn_AddNewGist(driver).isDisplayed(), true, "Add New Gist Button Not Found");
			objRepo.GistGithubOR.DiscoverGist.btn_AddNewGist(driver).click();

			/* Set New File Name */
			wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.AddNewGist.txt_FileName(driver)));
			objRepo.GistGithubOR.AddNewGist.txt_GistDesc(driver).sendKeys(gitdesc);
			objRepo.GistGithubOR.AddNewGist.txt_FileName(driver).sendKeys(filename);
			objRepo.GistGithubOR.AddNewGist.txt_FileEditor(driver).sendKeys(filecontent);
			Assert.assertEquals(objRepo.GistGithubOR.AddNewGist.btn_CreatePublicGist(driver).isDisplayed(), true, "Create Public Gist Button Not Found");
			objRepo.GistGithubOR.AddNewGist.btn_CreatePublicGist(driver).click();

			/* Verify Created Gist */
			objRepo.GistGithubOR.MenuBar.btn_UserProfile(driver).click();
			objRepo.GistGithubOR.MenuBar.menu_YourGist(driver).click();
			String fileNameSaved = objRepo.GistGithubOR.YourGist.lbl_FileName(driver).getText();
			if (!fileNameSaved.contains(filename)) {
				org.testng.Assert.fail("File Name was Different!");
			} else {
				System.out.println("Add new gist success!!");
			}

			if (i == totalRow) {
				driver.quit();
			}

		}

	}
}
