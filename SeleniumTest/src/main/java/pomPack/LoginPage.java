package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy (xpath = "//input[@name='username']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@name='pwd']") 
	private WebElement password ;

	@FindBy (xpath = "//a[text()='Login']") 
	private WebElement loginButton ;
	
	@FindBy (xpath = "//input[@id='keepLoggedInCheckBox']") 
	private WebElement keepMeLoginCheckbox ;
	
	private WebDriver driver ;
	
	public LoginPage(WebDriver driver)  // driver1 = driver = new ChromeDriver
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;		
	}
	
	public void sendUserName(String user) {
		
		WebDriverWait wait = new WebDriverWait(driver,30); // 20 sec
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(user);
	}
	
	public void sendPasswordName(String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 sec
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}
	
	public void selectKeepMeLogin() {
		keepMeLoginCheckbox.click();
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	
	//OR
	
	public void loginToActitime() {
		userName.sendKeys("Admin");
		password.sendKeys("manager");
		keepMeLoginCheckbox.click();
		loginButton.click();
	}
}
