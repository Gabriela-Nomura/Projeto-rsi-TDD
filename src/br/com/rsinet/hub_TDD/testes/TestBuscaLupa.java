package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.modulos.ModuloBusca;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TestBuscaLupa {

	static Logger Log = Logger.getLogger(Logger.class.getName());
	static WebDriver driver;

	@BeforeMethod
	public void configuracoes() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de log");

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		Log.info("Realizada a configuração do driver");

		driver = new ChromeDriver();
		Log.info("Inicialização do navegador Chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Foi aplicado no driver um comando de espera por 10 segundos");

		driver.manage().window().maximize();
		Log.info("A janela foi maximizada");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Teste2");
		Log.info("O arquivo do excel foi configurado");
		Reporter.log("A aplicação foi iniciada com sucesso");
	}

	@Test	(priority = 1)

	public void testaBuscaLupaValido() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		ModuloBusca.executa(1, driver);
		Log.info("Executa a busca pela lupa");

		WebElement result = driver.findElement(By.xpath("//*[@id=\"16\"]"));
		result.click();
		Log.info("Clica no elemento que foi buscado");

		AssertJUnit.assertTrue("Busca realizada com sucesso", driver.getPageSource().contains("HP ELITEPAD 1000 G2 TABLET"));
		Log.info("Realiza a comparação através do método Assert");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		Print.takeSnapShot("TesteBuscaLupaSucesso", driver);
		Log.info("Tira um PrintScreen");
		Reporter.log("A busca pela lupa foi realizada com sucesso");
	}

	@Test (priority = 0)
	public void testaBuscaLupaInvalido() throws Exception {

				
		Thread.sleep(3000);
//		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		Log.info("Aplica um comando de espera de 3 ms");
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		
		scroll.executeScript("scrollBy(0,750)", "");
		Log.info("Aplica um scroll na tela para que o elemento fique visível para o print");
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		
		Print.takeSnapShot("TesteBuscaLupaFalha1", driver);
		Log.info("Tira um PrintScreen n. 1");
		
		ModuloBusca.executa(2, driver);
		Log.info("Executa a busca pela lupa");
		
		Thread.sleep(10000);
		Log.info("Aguarda 15s");

		AssertJUnit.assertTrue("Teste com falha", driver.getPageSource().contains("No results for "));

		Log.info("A comparação com método Assert foi realizada com sucesso");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		Reporter.log(" A busca pela lupa falhou");
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
		Log.info("Tira um PrintScreen");

	}

	@AfterMethod
	public void encerra() {
		driver.close();
	}
}