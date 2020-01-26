package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.PaginaBusca;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteBuscaClique {
	/**
	 * Classe de teste da funcionalidade de busca através de cliques. Verifica se o
	 * produto aberto é correspondente ao produto que recebeu o clique no website
	 * https://www.advantageonlineshopping.com/#/ opção invalida por adicionar um
	 * produto [HP CHROMEBOOK 14 G1 (ES)] diferente ao carrinho quando selecionamos
	 * com cliques o item HP ELITEBOOK FOLIO disponível na homepage.
	 * 
	 */
	static Logger Log = Logger.getLogger("Teste de busca por clique");
	WebDriver driver;

	HomePage HomePage;
	PaginaBusca BuscaPage;

	@BeforeMethod
	public void configura() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de logs");

		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, PaginaBusca.class);
	}

	@Test(priority = 0)
	public void testaBuscaCliqueValido() throws Exception {

		Reporter.log(" A aplicação foi iniciada com sucesso |");

		HomePage.clickOn_HeadPhone();
		BuscaPage.clickOn_Produto();
		BuscaPage.addOn_carrinho();
		BuscaPage.clickOn_checkOut();
		Reporter.log("Os comandos de cliques foram executados com sucesso |");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"userCart\"]"));
		Log.info("Localiza o produto no carrinho");

		Assert.assertTrue(elemento != null);
		Log.info("Localiza o produto no carrinho");
		Reporter.log("O produto foi inserido no carrinho corretamente");

		constantes.takeSnapShot("TesteBuscaCliqueValido", driver);
		Log.info("Foi obtido um print da tela");
		Reporter.log("O teste foi finalizado ");

	}

	@Test
	public void testaBuscaCliqueInvalido() throws Exception {
		Reporter.log(" A aplicação foi iniciada com sucesso |");
		HomePage.clickOn_produtos();
		Reporter.log("Os comandos de cliques foram executados com sucesso |");
		BuscaPage.addOn_carrinho();
		BuscaPage.clickOn_checkOut();
		Reporter.log(" O produto selecionado foi inserido no carrinho com sucesso |");

		Assert.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));

		Log.info("Confirma que o item adicionado é diferente do item clicado inicialmente");
		Reporter.log("O produto inserido no carrinho é divergente do produto selecionado na tela inicial |");

		constantes.takeSnapShot("TesteBuscaCliqueInvalido", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log("O teste foi finalizado.");

	}

	@AfterMethod
	public void encerra() {

		driver.quit();
		Log.info("O driver é encerrado");

	}
}
