package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  ActiTimeHeader{
	
	@FindBy (xpath = "//div[text()='Time-Track']") 
	private WebElement timeTrack ;
	
	@FindBy (xpath = "//a[@class='content tasks']") 
	private WebElement tasks ;

	@FindBy (xpath = "//a[@class='content reports']") 
	private WebElement reports ;
	
	@FindBy (xpath = "//div[text()='Users']") 
	private WebElement user ;
	
	@FindBy (xpath = "//a[text()='Logout']") 
	private WebElement logout ;
	
	WebDriver driver ;
	WebDriverWait wait ;
	
	public ActiTimeHeader(WebDriver driver) // driver = driver = new ChromeDriver()
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnTimeTrack() {
		wait = new WebDriverWait(driver, 30) ;
		wait.until(ExpectedConditions.visibilityOf(tasks));
		timeTrack.click();
	}	
	
	public void clickOnTasksTab() {
		wait = new WebDriverWait(driver, 20) ;
		wait.until(ExpectedConditions.visibilityOf(tasks));
		tasks.click();
	}
	
	public void clickOnReportsTab() {
		reports.click();
	}
	
	public void clickOnUserTab() {
		user.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
}
