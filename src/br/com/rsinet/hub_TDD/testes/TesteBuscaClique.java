package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.modulos.BuscaCliqueModulo;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteBuscaClique {

	static Logger Log = Logger.getLogger("TestBuscaClique");
	WebDriver driver;

	@BeforeMethod
	public void configuracoes() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de log");

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		Log.info("Realizada a configuração do driver");

		driver = new ChromeDriver();
		Log.info("Inicialização do navegador Chrome");

		driver.manage().window().maximize();
		Log.info("A janela foi maximizada");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Teste2");
		Log.info("O arquivo do excel foi configurado");
	
		Reporter.log("A aplicação foi iniciada com sucesso");
	}

	@Test
	public void testaBuscaCliqueValido() throws Exception {

		BuscaCliqueModulo.executa(driver);
		Log.info("O módulo de busca por clique foi executado com sucesso");
		
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"userCart\"]"));
		Log.info("Localiza o produto no carrinho");

		//		IMPLEMENTAÇÃO DO ASSERT
		AssertJUnit.assertNotNull(elemento);
		Log.info("Verifica que o produto foi inserido no carrinho com sucesso");
		Reporter.log("O produto foi inserido no carrinho com sucesso");
		
		Print.takeSnapShot("TesteBuscaClique", driver);
		Log.info("Tira um PrintScreen");
	}

	@Test
	public void testaBuscaCliqueInvalido() throws Exception {
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,750)", "");
		Log.info("Aplica um scroll na tela para que o elemento fique visível para o print");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		
		WebElement HP = driver.findElement(By.id("details_10"));
		Log.info("Localiza o elemento: HP ELITEBOOK FOLIO ");
		
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
