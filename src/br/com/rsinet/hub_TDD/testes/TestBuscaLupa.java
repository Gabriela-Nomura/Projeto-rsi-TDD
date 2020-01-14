package br.com.rsinet.hub_TDD.testes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.validation.constraints.AssertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.modulos.ModuloBusca;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;
import junit.framework.Assert;

public class TestBuscaLupa {

	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.TestBuscaLupa");
	static WebDriver driver;

	@Before
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Teste2");
		Log.info("O arquivo do excel foi configurado");
	}

	@Test
	public void testaBuscaLupaValido() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		ModuloBusca.executa(1, driver);
		Log.info("Executa a busca pela lupa");
		String sbuscaNome = ExcelUtils.getCellData(1, constantes.Col_NomeBusca);
		
		assertTrue("Busca realizada com sucesso", sbuscaNome.equals("HP ELITEPAD 1000 G2 TABLET"));
		Log.info("Realiza a comparação através do método Assert");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		
		Print.takeSnapShot("TesteBuscaLupaSucesso", driver);
		Log.info("Tira um PrintScreen");
	}
	@Test
	public void testaBuscaLupaInvalido() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		ModuloBusca.executa(2, driver);
		Log.info("Executa a busca pela lupa");
		WebElement fail =	driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span/font/font"));
		assertNotNull(fail);
		Log.info("A comparação com método Assert foi realizada com sucesso");
//		/		assertTrue("Busca não realizada",  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		
		Print.takeSnapShot("TesteBuscaLupaFalha", driver);
		Log.info("Tira um PrintScreen");

	}
	@After

	public void encerra() {
		driver.close();
	}
}