package br.com.rsihub.pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
	
			
	static WebDriver driver;
	
	 @FindBy(how = How.ID, using ="menuUserLink")
	 public static WebElement minhaConta;

	 @FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]") 
	 public static WebElement novaConta;

}
