package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.utils.Configuracoes;
import br.com.rsinet.hub_TDD.utils.Print;

public class BuscaCliqueInvalido {

	static Logger Log = Logger.getLogger("Teste de busca por clique inválido");

	@Test
	public void testaBuscaCliqueInvalido() throws Exception {

		WebDriver driver = Configuracoes.setDriver();
		Reporter.log(" A aplicação foi iniciada com sucesso |");

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scrollBy(0,650)", "");
		Actions acao = new Actions(driver);
		acao.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
		Log.info("Aplica um scroll na tela para que o elemento fique visível para o print");

		acao.sendKeys(Keys.TAB).perform();		

		WebElement HP = driver.findElement(By.id("details_10"));
		Log.info("Localiza o elemento: HP ELITEBOOK FOLIO ");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(HP));
		Log.info("Aguarda que o elemento esteja visível");

		Print.takeSnapShot("MostraProdutoaSerClicado", driver);
		Log.info("Tira um PrintScreen 1");

		HP.click();
		Log.info("Clica no item popular HP ELITEBOOK FOLIO");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();

		driver.findElement(By.id("checkOutPopUp")).click();

		AssertJUnit.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));

		Log.info("Confirma que o item adicionado é diferente do item clicado inicialmente");
		Reporter.log("O produto inserido no carrinho é divergente do produto selecionado na tela inicial");

		Print.takeSnapShot("TesteBuscaCliquecomfalha", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log("O teste foi concluído com sucesso");
	}
}
