package br.com.rsinet.hub_TDD.modulos;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.pageObject.Home_Page;

public class Home_Modulo {

	static WebDriver driver;
	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.Home_Modulo");
	Home_Page page = new Home_Page();

	public static void homePage() throws Exception {
		
//		WebDriver wait = (WebDriver) new WebDriverWait(driver, 10);
//		((FluentWait<WebDriver>) wait).until(ExpectedConditions.elementToBeClickable(Home_Page.minhaConta));
//		Log.info("Foi aplicado um comando de espera para aguardar pelo elemento ser clicável");
		Home_Page.minhaConta.click();
		Log.info("O ícone minha conta recebeu um clique");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("Foi aplicado um comando de espera no driver por 15 segundos");
		WebElement PopUp = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
		PopUp.click();
		Log.info("O ícone minha conta recebeu um clique");
		Home_Page.novaConta.click();

		PageFactory.initElements(driver, Home_Page.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");
		
	}

}
