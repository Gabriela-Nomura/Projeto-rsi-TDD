package br.com.rsinet.hub_TDD.testes;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.modulos.ModuloCadastra;
import br.com.rsinet.hub_TDD.modulos.ModuloHomePage;
import br.com.rsinet.hub_TDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteCadastro {

	static Logger Log = Logger.getLogger("Teste de Cadastro");
	static WebDriver driver;

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

		ExcelUtils.setExcelFile(constantes.Path_TestData, "Planilha1");
		Log.info("Configurado o arquivo do excel a ser lido");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

	}

	@Test(priority = 0)
	public void testeCadastroValido() throws Exception {
		try {
			Reporter.log(" A aplicação foi iniciada com sucesso");

			ModuloHomePage.executa(driver);
			Log.info("O modulo da página inicial foi executado com sucesso");

			ModuloCadastra.executa(driver);
			Log.info("O módulo do cadastro foi executado com sucesso");

		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");
		}
		Reporter.log("Um novo usuário foi cadastrado com sucesso");
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
		Log.info("Driver recebeu um comando de espera para aguardar a atualização da Url");

		String url = driver.getCurrentUrl();
		Log.info("O endereço da url foi obtido: " + url);

		assertTrue("Usuário cadastrado com sucesso", url.equals("https://www.advantageonlineshopping.com/#/"));
		Log.info("Realiza a comparação entre as urls esperada e a obtida");

		Print.takeSnapShot("TesteCadastroValido", driver);
		Log.info("Um PrintScreen é obtido da tela atual");
		Reporter.log("O teste de cadastro válido foi concluído com sucesso");
	}

	@Test(priority = 1)
	public void testeCadastroInvalido() throws Exception {
		try {
			Reporter.log(" A aplicação foi iniciada com sucesso");

			ModuloHomePage.executa(driver);
			Log.info("O modulo da página inicial foi executado com sucesso");
			
			ModuloCadastra.executa(driver);
			Log.info("O módulo do cadastro foi executado com sucesso");
		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");
		
		}
		CadastraPage_POF.registraUsuario.click();
		
		Reporter.log("O usuário não foi cadastrado");
	
		String url = driver.getCurrentUrl();
		Log.info("O endereço da url foi obtido: " + url);
		
		assertTrue("Usuário não cadastrado", url.equals("https://www.advantageonlineshopping.com/#/register"));
		Log.info("Realiza a comparação entre as urls esperada e a obtida");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,150)", "");
		Log.info("Foi aplicado um comando de rolagem de tela, para melhoria do print obtido");

		Reporter.log("A mensagem de usuário já cadastrado foi obtida com sucesso");
		Print.takeSnapShot("TesteCadastroInvalido", driver);
		Log.info("Tira um PrintScreen para comprovar fim do teste");
	}

	@AfterMethod
	public void encerra() {
		
		driver.quit();
		Log.info("O driver é encerrado");
		
	}
}
