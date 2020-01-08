package br.com.rsihub.pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page extends BaseClass {
	
			
	public Home_Page(WebDriver driver) {
		super(driver);
	}
	
	//static WebDriver driver = new ChromeDriver();
	
	public static WebElement elemento = null;

	public static WebElement minhaConta() throws Exception{
		try{
			
			elemento = driver.findElement(By.id("menuUserLink"));
		}
		//Log.info("dasdasdas");
		catch (Exception e){
			throw (e);
		};
		return elemento;
		}

	public static WebElement novaConta() throws Exception {
		try {			
		elemento = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		}
		catch (Exception e) {
			throw (e);
			};
	return elemento;
}
}