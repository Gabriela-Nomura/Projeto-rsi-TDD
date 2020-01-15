package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.modulos.BuscaCliqueModulo;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteBuscaClique {

	static Logger Log = Logger.getLogger("TestBuscaClique");
	WebDriver driver;

	@BeforeMethod
	public void configuracoes() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de logs");

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		Log.info("Configurado driver de execução");

		driver = new ChromeDriver();
		Log.info("Novo driver instanciado");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		driver.manage().window().maximize();
		Log.info("A janela foi maximizada");

		ExcelUtils.setExcelFile(constantes.Path_TestData, "TesteBusca");
		Log.info("Configurado o arquivo do excel a ser lido");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
	}

	@Test
	public void testaBuscaCliqueValido() throws Exception {

		Reporter.log(" A aplicação foi iniciada com sucesso |");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
		
		BuscaCliqueModulo.executa(driver);
		Log.info("O módulo de busca por clique foi executado com sucesso");
		Reporter.log(" O produto clicado foi correspondente ao aberto |");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"userCart\"]"));
		Log.info("Localiza o produto no carrinho");

		AssertJUnit.assertNotNull(elemento);
		Log.info("Verifica que o produto foi inserido no carrinho com sucesso");
	
		Reporter.log(" O produto selecionado foi inserido no carrinho com sucesso |");
		
		Print.takeSnapShot("TesteBuscaClique", driver);
		Log.info("Tira um PrintScreen");
	}

	@Test
	public void testaBuscaCliqueInvalido() throws Exception {
		
		Reporter.log(" A aplicação foi iniciada com sucesso |");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
		WebElement HP = driver.findElement(By.id("details_10"));
		Log.info("Localiza o elemento: HP ELITEBOOK FOLIO ");
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scrollBy(0,750)", "");
		Actions acao = new Actions(driver);
		acao.moveToElement(HP);
		Log.info("Aplica um scroll na tela para que o elemento fique visível para o print");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		
		
		
		Print.takeSnapShot("TesteBuscaCliquecomfalha1", driver);
		Log.info("Tira um PrintScreen 1");

		HP.sendKeys(Keys.ENTER);
		Log.info("Clica no item popular HP ELITEBOOK FOLIO");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();
		Log.info("Adiciona o item ao carriho");

		driver.findElement(By.id("checkOutPopUp")).click();
		Log.info("Vai para página de checkout");

		AssertJUnit.assertTrue(driver.getPageSource().contains("HP CHROMEBOOK 14 G1"));
		Log.info("Confirma que o item adicionado é diferente do item clicado inicialmente");
		Reporter.log("O produto inserido no carrinho é divergente do produto selecionado na tela inicial");
		
		Print.takeSnapShot("TesteBuscaCliquecomfalha", driver);
		Log.info("Tira um PrintScreen");
	}

	@AfterMethod
	public void encerra() {
		driver.close();
		Log.info("Encerra o navegador");

	}

}
