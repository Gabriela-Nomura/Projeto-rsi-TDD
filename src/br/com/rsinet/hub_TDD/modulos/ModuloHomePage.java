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

	static Logger Log = Logger.getLogger("Modulo da página inicial");

	public static void executa(WebDriver driver) throws Exception {

		PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		HomePage_POF.minhaConta.click();
		Log.info("O link minha conta recebu um clique");

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Log.info("Foi aplicado um comando de espera para carregamento da página de 20 segundos");

		HomePage_POF.novaConta.sendKeys(Keys.ENTER);
		Log.info("O link nova conta recebeu um clique");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Log.info("Foi aplicado um comando de espera no driver por 5 segundos");
	}

}
