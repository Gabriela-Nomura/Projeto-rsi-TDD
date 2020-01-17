package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.pageFactory.PaginaBusca_POF;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteBuscaClique {
	/**
	 * Classe de teste para busca através de cliques. Verifica se o produto aberto é
	 * correspondente ao produto que recebeu o clique.
	 * 
	 */
	static Logger Log = Logger.getLogger("Teste de busca por clique [válido]");
	WebDriver driver;

	HomePage_POF HomePage;
	PaginaBusca_POF BuscaPage;

	@BeforeMethod
	public void configura() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de logs");

		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		BuscaPage = PageFactory.initElements(driver, PaginaBusca_POF.class);
		Reporter.log(" A aplicação foi iniciada com sucesso |");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

	}

	@Test
	public void testaBuscaCliqueValido() throws Exception {

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

		Print.takeSnapShot("TesteBuscaCliqueValido", driver);
		Log.info("Foi obtido um print da tela");
		Reporter.log("O teste foi concluído com sucesso .");

	}

	@Test
	public void testaBuscaCliqueInvalido() throws Exception {

		HomePage.clickOn_PopularProdutos();
//		Thread.sleep(2000);
		HomePage.takePrint();
		HomePage.clickOn_produtos();
		BuscaPage.addOn_carrinho();
		BuscaPage.clickOn_checkOut();

		Assert.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1(ES)"));

		Log.info("Confirma que o item adicionado é diferente do item clicado inicialmente");
		Reporter.log("O produto inserido no carrinho é divergente do produto selecionado na tela inicial");

		Print.takeSnapShot("TesteBuscaCliquecomfalha", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log("O teste foi concluído com sucesso");

		Reporter.log(" O produto selecionado foi inserido no carrinho com sucesso |");
		Reporter.log(" O resultado do teste indica que produto clicado foi correspondente ao aberto |");

	}
	@AfterMethod
	public void encerra() {

		driver.quit();
		Log.info("O driver é encerrado");

	}
}
