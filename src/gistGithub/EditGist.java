package gistGithub;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtil;
import utilities.OpenApp;

public class EditGist {

	public static String browser = "chrome";
	public static String url = "https://gist.github.com/";
	public static WebDriver driver = null;
	public static String projectDir = System.getProperty("user.dir");
	public static String filename = projectDir + "/data/gistGithubData.xlsx";
	public static String sheetname = "EditGist";
	public static WebDriverWait wait = null;
	public static boolean firstRun = true;

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

			if (firstRun) {
				/* Open Browser and Navigate to gist.github.com */
				driver = OpenApp.OpenBrowser(browser, url);
				wait = new WebDriverWait(driver, 5);

				/* Click Login Button on Landing Page */
				Assert.assertEquals(objRepo.GistGithubOR.LandingPage.btn_Login(driver).isDisplayed(), true, "Button Login Not Found");
				objRepo.GistGithubOR.LandingPage.btn_Login(driver).click();

				/* Fill Username, Password and Click Sign In Button */
				wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.LoginPage.btn_SignIn(driver)));
				objRepo.GistGithubOR.LoginPage.txt_Username(driver).sendKeys(username);
				objRepo.GistGithubOR.LoginPage.txt_Password(driver).sendKeys(password);
				objRepo.GistGithubOR.LoginPage.btn_SignIn(driver).click();

				/* Redirected to Discover Gist Page, and go to Your Gist */
				wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.DiscoverGist.btn_AddNewGist(driver)));

				firstRun = false;
			}

			/* Redirected to Discover Gist Page, and go to Your Gist */
			objRepo.GistGithubOR.MenuBar.btn_UserProfile(driver).click();
			objRepo.GistGithubOR.MenuBar.menu_YourGist(driver).click();

			/* Select First Row Gist */
			objRepo.GistGithubOR.YourGist.link_FileName(driver).click();

			/* Click Button Edit */
			objRepo.GistGithubOR.YourGist.btn_Edit(driver).click();

			/* Update File */
			wait.until(ExpectedConditions.visibilityOf(objRepo.GistGithubOR.EditGist.btn_UpdatePublicGist(driver)));
			objRepo.GistGithubOR.EditGist.txt_GistDesc(driver).clear();

			objRepo.GistGithubOR.EditGist.txt_GistDesc(driver).sendKeys(gitdesc);
			objRepo.GistGithubOR.EditGist.txt_FileName(driver).clear();
			objRepo.GistGithubOR.EditGist.txt_FileName(driver).sendKeys(filename);
			objRepo.GistGithubOR.EditGist.txt_FileEditor(driver).clear();
			objRepo.GistGithubOR.EditGist.txt_FileEditor(driver).sendKeys(filecontent);
			objRepo.GistGithubOR.EditGist.btn_UpdatePublicGist(driver).click();

			/* Verify Updated Gist */
			objRepo.GistGithubOR.MenuBar.btn_UserProfile(driver).click();
			objRepo.GistGithubOR.MenuBar.menu_YourGist(driver).click();
			String fileNameSaved = objRepo.GistGithubOR.YourGist.lbl_FileName(driver).getText();
			if (!fileNameSaved.contains(filename)) {
				org.testng.Assert.fail("File Name was Different!");
			} else {
				System.out.println("Edit gist success!!");
			}
			
			if (i == totalRow) {
				driver.quit();
			}
		}

	}
}
