package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GistGithubOR {
	public static class LandingPage {
		public static WebElement btn_Login(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("div[role='navigation'] > .HeaderMenu-link.mr-3.no-underline"));
			return element;
		}
	
	}
	public static class LoginPage{
		public static WebElement txt_Username(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("/html//input[@id='login_field']"));
			return element;
		}
		public static WebElement txt_Password(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("/html//input[@id='password']"));
			return element;
		}
		public static WebElement btn_SignIn(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".btn-primary"));
			return element;
		}
	}
	
	public static class DiscoverGist{
		public static WebElement btn_AddNewGist(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".Header-link > .octicon.octicon-plus"));
			return element;
		}
	}
	
	public static class AddNewGist{
		public static WebElement txt_FileName(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("input[name='gist[contents][][name]']"));
			return element;
		}
		public static WebElement txt_FileEditor(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("pre[role='presentation']"));
			return element;
		}
		public static WebElement btn_AddFile(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".js-add-gist-file"));
			return element;
		}
		public static WebElement txt_GistDesc(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("[name='gist\\[description\\]']"));
			return element;
		}
		public static WebElement btn_CreatePublicGist(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".form-actions > button:nth-of-type(1)"));
			return element;
		}
	}
	public static class YourGist{
		public static WebElement lbl_FileName(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("//div[@class='d-inline-block']//span"));
			return element;
		}
		public static WebElement link_FileName(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("//div[@class='gist-snippet']//li[1]//a[1]"));
			return element;
		}
		public static WebElement link_FileNameEdit(WebDriver driver) {
			WebElement element = driver.findElement(By.className("user-select-contain gist-blob-name css-truncate-target"));
			return element;
		}
		public static WebElement btn_Edit(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".btn.btn-sm > .octicon.octicon-pencil"));
			return element;
		}
		public static WebElement btn_Delete(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-danger']"));
			return element;
		}
	}
	public static class MenuBar{
		public static WebElement btn_UserProfile(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("div#user-links  summary[role='button']"));
			return element;
		}
		public static WebElement menu_YourGist(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("details-menu[role='menu'] > a:nth-of-type(1)"));
			return element;
		}
	}
	public static class EditGist{
		public static WebElement txt_FileName(WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("//input[@placeholder='Filename including extension…']"));
			return element;
		}
		public static WebElement txt_FileEditor(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("pre[role='presentation']"));
			return element;
		}
		public static WebElement btn_AddFile(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".js-add-gist-file"));
			return element;
		}
		public static WebElement txt_GistDesc(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector("[name='gist\\[description\\]']"));
			return element;
		}
		public static WebElement btn_UpdatePublicGist(WebDriver driver) {
			WebElement element = driver.findElement(By.cssSelector(".btn.btn-primary"));
			return element;
		}
	}

}
