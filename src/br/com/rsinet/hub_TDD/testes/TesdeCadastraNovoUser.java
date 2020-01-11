package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.modulos.ModuloHomePage;
import br.com.rsinet.hub_TDD.modulos.ModuloCadastra;
import br.com.rsinet.hub_TDD.pageFactory.Cadastra_Page;
import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesdeCadastraNovoUser {

	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.teste_cadastraPage");
	static WebDriver driver;

	@Before
	public  void configuracoes() throws Exception {
		
		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de log");
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\gabriela.nomura\\driver");
		Log.info("Realizada a configuração do driver");
		WebDriver driver = new ChromeDriver();
		Log.info("Inicialização do navegador Chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Foi aplicado no driver um comando de espera por 10 segundos");

		driver.manage().window().maximize();
		Log.info("A janela foi maximizada");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Planilha1");
		Log.info("O arquivo do excel foi configurado");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Foi aplicado no driver um comando de espera por 10 segundos");
	
		PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");
	}

	@Test
	public void testa() throws Exception {
		try{
	
			System.setProperty("Webdriver.chrome.driver", "C:\\Users\\gabriela.nomura\\driver");
			Log.info("Realizada a configuração do driver");
			ModuloHomePage.executa();
			Log.info("O modulo da página inicial foi iniciado");
			ModuloCadastra.executa();
			Log.info("O módulo de inserção de dados do cadastro foi iniciado");
		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");
		}}

//		Assert.assertEquals(HomePage_POF.UserName, ExcelUtils.getCellData(1, constantes.Col_userName));
//	}

	@After

	public void encerra() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\gabriela.nomura\\driver");
		Log.info("Realizada a configuração do driver");
		driver.close();
	}
}
