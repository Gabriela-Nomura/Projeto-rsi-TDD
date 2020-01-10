package br.com.rsihub.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsihub.appModules.ModuloCadastra;
import br.com.rsihub.pageObject.Cadastra_Page;
import br.com.rsihub.pageObject.Home_Page;
import br.com.rsihub.utils.ExcelUtils;
import br.com.rsihub.utils.constantes;

public class CadastraUsuarioTest {

	static WebDriver driver;
	@BeforeTest
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		WebDriver driver = new ChromeDriver();
		
//		Log.info("O navegador Chrome foi inicializado");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		Log.info("Foi aplicado no driver um comando de espera por 13 segundos");

		driver.get(constantes.URL);
//		Log.info("O Website foi acessado");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Planilha1");
//		Log.info("O arquivo do excel foi configurado");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Log.info("Foi aplicado no driver um comando de espera por 15 segundos");	
	}

	@Test
	public void test() throws Exception{
		PageFactory.initElements(driver, Home_Page.class);
//		Log.info("A fabrica de objetos da página inicial foi instanciada");
		PageFactory.initElements(driver, Cadastra_Page.class);
//		Log.info("A fabrica de objetos da página de cadastro foi instanciada");
		
		ModuloCadastra.executa();
		
//		Log.info("O módulo cadastra foi executado")
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		AssertJUnit.fail("Not yet implemented");
	}

}
