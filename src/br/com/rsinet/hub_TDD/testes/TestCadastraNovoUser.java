package br.com.rsinet.hub_TDD.testes;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.modulos.ModuloCadastra;
import br.com.rsinet.hub_TDD.modulos.ModuloHomePage;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TestCadastraNovoUser {

	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.TesteCadastraNovoUser");
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

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Planilha1");
		Log.info("O arquivo do excel foi configurado");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("Foi aplicado no driver um comando de espera por 15 segundos");

	}

	@Test
	public void testaCadastroValido() throws Exception {
		try {

			ModuloHomePage.executa(driver);
			Log.info("O modulo da página inicial foi executado com sucesso");
			ModuloCadastra.executa(driver);
			Log.info("O módulo do cadastro foi executado com sucesso");
		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");
		}

		// FALTA A IMPLEMENTAÇÃO DOS METODOS COMPARATIVOS DE TESTE
		Thread.sleep(8000);
		String url = driver.getCurrentUrl();
		System.out.println(url);

		assertTrue("Usuário cadastrado com sucesso", url.equals("https://www.advantageonlineshopping.com/#/"));
		Log.info("Realiza a comparação através do método Assert");
		
		Print.takeSnapShot("TesteCadastraUsuariocomsucesso", driver);
		Log.info("Tira um PrintScreen");
	}
	@Test
	public void testaCadastroInvalido() throws Exception {
		try {

			ModuloHomePage.executa(driver);
			Log.info("O modulo da página inicial foi executado com sucesso");
			ModuloCadastra.executa(driver);
			Log.info("O módulo do cadastro foi executado com sucesso");
		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");
		}

		// FALTA A IMPLEMENTAÇÃO DOS METODOS COMPARATIVOS DE TESTE
		Thread.sleep(8000);
		String url = driver.getCurrentUrl();
		System.out.println(url);

		assertTrue("Usuário não cadastrado", url.equals("https://www.advantageonlineshopping.com/#/register"));
		Log.info("Realiza a comparação através do método Assert");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Print.takeSnapShot("TesteCadastraUsuariocomFalha", driver);
		Log.info("Tira um PrintScreen");}
	@After

	public void encerra() {

		driver.quit();
	}
}
