package br.com.rsinet.hub_TDD.modulos;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;

public class ModuloHomePage {

	static WebDriver driver;
	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.Home_Modulo");

	public static void executa() throws Exception {
		
		HomePage_POF.minhaConta.click();
		Log.info("O link minha conta foi acessado");
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(20000);
		Log.info("Foi aplicado um comando de espera no driver por 15 segundos");
//		WebElement PopUp = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
//		PopUp.click();
//		Log.info("O popUp foi clicado");
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", HomePage_POF.novaConta);
		Log.info("O link nova conta recebeu um clique");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Foi aplicado um comando de espera no driver por 10 segundos");
	}

}
