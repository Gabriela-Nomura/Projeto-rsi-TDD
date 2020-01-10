package br.com.rsinet.hub_TDD.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {
		
	static WebDriver driver;
	 static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.Home_Page");
	 
	 @FindBy(how = How.ID, using ="menuUser")
	 public static WebElement minhaConta;
	 
	 
//	 Log.info("O elemento minha conta foi encontrado");

	 @FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]") 
	 public static WebElement novaConta;
//	 Log.info("O elemento crie uma nova conta foi encontrado");
	
	
}
