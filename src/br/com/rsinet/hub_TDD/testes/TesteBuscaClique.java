package br.com.rsinet.hub_TDD.testes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.modulos.BuscaCliqueModulo;
import br.com.rsinet.hub_TDD.modulos.ModuloBusca;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteBuscaClique {

	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.TestBuscaLupa");
	WebDriver driver;

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
	public void testaBuscaCliqueValido() throws Exception {

		BuscaCliqueModulo.executa(driver);
		Log.info("O módulo de busca por clique foi executado com sucesso");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();
		Log.info("Adiciona o item ao carriho");

		driver.findElement(By.id("checkOutPopUp")).click();
		Log.info("Vai para página de checkout");
		
		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"userCart\"]"));
//		IMPLEMENTAÇÃO DO ASSERT
		assertNotNull(elemento);
		
		Print.takeSnapShot("TesteBuscaClique", driver);
		Log.info("Tira um PrintScreen");
	}
	@Test
	public void testaBuscaCliqueInvalido() throws Exception {

		BuscaCliqueModulo.executa(driver);
		Log.info("O módulo de busca por clique foi executado com sucesso");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");

		WebElement plus = driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[2]/e-sec-plus-minus/div/div[3]"));
		for (int cont = 1; cont<19; cont++) {
			plus.click();
			
		}
		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();
		Log.info("Adiciona o item ao carriho");

		driver.findElement(By.id("checkOutPopUp")).click();
		Log.info("Vai para página de checkout");
		
//		IMPLEMENTAÇÃO DO ASSERT		assert.
		
		Print.takeSnapShot("TesteBuscaCliquecomfalha", driver);
		Log.info("Tira um PrintScreen");
	}

	@After
	public void encerra() {
		driver.close();

	}

}
