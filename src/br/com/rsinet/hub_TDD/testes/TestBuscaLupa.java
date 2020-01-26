package br.com.rsinet.hub_TDD.testes;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.PaginaBusca;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TestBuscaLupa {
	/**
	 * Classe de teste da funcionalidade de busca atraves da lupa do website:
	 * https://www.advantageonlineshopping.com/#/
	 * Opção invalida por nao encontrar um elemento disponível na homepage: HP ELITEBOOK FOLIO
	 */
	static Logger Log = Logger.getLogger("Teste de busca pela lupa");
	static WebDriver driver;
	HomePage HomePage;
	PaginaBusca BuscaPage;

	@BeforeMethod
	public void configura() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de logs");

		Driver_Factory.configExcel();
		Log.info("O arquivo do excel foi configurado");

		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, PaginaBusca.class);
	}

	@Test(priority = 0)
	public void testaBuscaLupaValido() throws Exception {

		Reporter.log(" A aplicação foi iniciada com sucesso |");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		HomePage.clickOn_busca();
		Log.info("O botão de lupa recebeu um clique");

		HomePage.sendText_busca();
		Log.info("O texto de busca foi enviado HP ELITEPAD 1000 G2 TABLET");

		Log.info("A pela lupa foi executada com sucesso");
		Reporter.log("O campo de busca recebeu os parâmetros enviados |");

		driver.findElement(By.id("16")).click();

		Log.info("Clica no elemento que foi buscado");

		assertTrue(driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET"));
		Log.info("Realiza a comparação através do método Assert");

		Reporter.log("A aplicação retornou o produto pesquisado |");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		constantes.takeSnapShot("TesteBuscaLupaSucesso", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log("A busca pela lupa foi realizada com sucesso");
		Reporter.log(" O teste foi finalizado ");
		
	}

	@Test(priority = 0)
	public void testaBuscaLupaInvalido() throws Exception {

		Reporter.log(" A aplicação foi iniciada com sucesso |");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 15 segundos");
		HomePage.clickOn_busca();
		HomePage.sendText_buscaFalha();
		Reporter.log("O campo de busca recebeu os parâmetros enviados |");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		assertTrue(driver.getPageSource().contains("No results for"));
		Log.info("A comparação com método Assert foi realizada com sucesso");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		Reporter.log(" A busca pela lupa não retornou o resultado esperado | ");
		
		constantes.takeSnapShot("TesteBuscaLupaFalha", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log(" O teste foi finalizado ");
	}

	@AfterMethod
	public void encerra() {
		driver.close();
	}
}