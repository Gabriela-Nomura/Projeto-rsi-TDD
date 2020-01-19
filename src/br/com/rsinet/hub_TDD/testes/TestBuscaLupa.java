package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

public class TestBuscaLupa {

	static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;
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
	
	@Test(priority = 1)
	public void testaBuscaLupaValido() throws Exception {
		
		Reporter.log(" A aplicação foi iniciada com sucesso |");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		HomePage.clickOn_busca();
		HomePage.sendText_busca();
		
		Log.info("O módulo de busca foi executado com sucesso");
		Reporter.log("O campo de busca recebeu os parâmetros enviados |");
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"16\"]"));
		result.click();
		Log.info("Clica no elemento que foi buscado");

		AssertJUnit.assertTrue("Busca realizada com sucesso",
				driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET"));
		Log.info("Realiza a comparação através do método Assert");
		
		Reporter.log("A aplicação retornou o produto pesquisado |");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		Print.takeSnapShot("TesteBuscaLupaSucesso", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log("A busca pela lupa foi realizada com sucesso");
	}

	@Test(priority = 0)
	public void testaBuscaLupaInvalido() throws Exception {
		
		Reporter.log(" A aplicação foi iniciada com sucesso |");
		
//		HomePage.ajusta_tela();
		HomePage.clickOn_PopularProdutos();
		HomePage.take_Print();
		HomePage.clickOn_busca();
		HomePage.sendText_busca();
		
		AssertJUnit.assertTrue("Teste com falha", driver.getPageSource().contains("No results for "));

		Log.info("A comparação com método Assert foi realizada com sucesso");
		Reporter.log(" A busca foi realizada com sucesso |");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		Reporter.log(" A busca pela lupa não retornou o resultado esperado | ");
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log(" O teste foi finalizado ");
	}

	@AfterMethod
	public void encerra() {
		driver.close();
	}
}