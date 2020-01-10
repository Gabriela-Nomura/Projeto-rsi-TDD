package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.modulos.Home_Modulo;
import br.com.rsinet.hub_TDD.modulos.ModuloCadastra;
import br.com.rsinet.hub_TDD.pageObject.Cadastra_Page;
import br.com.rsinet.hub_TDD.pageObject.Home_Page;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class CadastraUsuarioTest {

	static WebDriver driver;
	Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.CadastraUsuarioTest");
@Test
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		WebDriver driver = new ChromeDriver();

		Log.info("O navegador Chrome foi inicializado");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("Foi aplicado no driver um comando de espera por 13 segundos");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Planilha1");
		Log.info("O arquivo do excel foi configurado");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Log.info("Foi aplicado no driver um comando de espera por 15 segundos");
	}

@Test	
	public void test() throws Exception{
//		PageFactory.initElements(driver, Home_Page.class);
//		Log.info("A fabrica de objetos da página inicial foi instanciada");
//		PageFactory.initElements(driver, Cadastra_Page.class);
//		Log.info("A fabrica de objetos da página de cadastro foi instanciada");
		WebDriver wait = (WebDriver) new WebDriverWait(driver, 10);
		((FluentWait<WebDriver>) wait).until(ExpectedConditions.elementToBeClickable(Home_Page.minhaConta));
		Log.info("Foi aplicado um comando de espera para aguardar pelo elemento ser clicável");
		Home_Modulo.homePage();
		Log.info("O módulo da página inicial foi inicializado");
		
//		Home_Page.minhaConta.click();
		Log.info("O ícone minha conta recebeu um clique");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement PopUp = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
		PopUp.click();
		
		Home_Page.novaConta.click();
		
		
		Log.info("O módulo da pagina inicial foi instanciada");
		ModuloCadastra.executa();
		
		Log.info("O módulo cadastra foi executado");}


//AssertJUnit.fail("Not yet implemented");}

}
