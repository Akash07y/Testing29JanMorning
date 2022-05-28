package browserSerring;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resource\\chromedriver.exe") ;
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "src"+File.separator+"test"+File.separator+"resource+"+File.separator+"chromedriver.exe") ;
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openOperaBrowser() {
		System.setProperty("webdriver.opera.driver", "Path\\opreariver.exe") ;
		WebDriver driver = new OperaDriver();
		return driver;
	}
	
	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "Path\\edgedriver.exe") ;
		WebDriver driver = new EdgeDriver();
		return driver;
	}
}
