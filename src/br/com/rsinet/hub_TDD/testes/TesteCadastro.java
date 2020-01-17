package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.utils.Driver_Factory;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;

public class TesteCadastro {
/**
 * Inicializa as fábricas de objetos da página inicial e de cadastro, manipula os elementos a fim de realizar 2 tentativas de cadastro.
 * Uma válida, e uma inválida. 
 * [Opção inválida pela nome de usuário já ter sido cadastrado].
 * 
 */
	static Logger Log = Logger.getLogger("Teste de Cadastro");
	WebDriver driver;

	HomePage_POF HomePage;
	CadastraPage_POF CadastraPage;

	@BeforeMethod
	public void configura() throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de logs");

		driver = Driver_Factory.configDriver();
		Log.info("Faz a configuração do driver");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");
		
		ExcelUtils.setExcelFile(constantes.Path_TestData, "TesteCadastro");
		Log.info("Configurado o arquivo do excel a ser lido");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		CadastraPage = PageFactory.initElements(driver, CadastraPage_POF.class);
		Log.info("A fabrica de objetos da página de cadastro foi instanciada");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

	}

	@Test(priority = 0)
	public void testeCadastroValido() throws Exception {
		try {
			Reporter.log(" A aplicação foi iniciada com sucesso |");

			HomePage.minhaConta();
			HomePage.novaConta();

			Reporter.log(" A página de criação de novo usuário foi acessada |");

			CadastraPage.sendUserName(1);
			CadastraPage.sendUserEmail();
			CadastraPage.sendUserSenha();
			CadastraPage.sendUserSenhaConfirmacao();
			CadastraPage.sendUserSPrimeiroNome();
			CadastraPage.sendUserUltimoNome();
			CadastraPage.sendUserTelefone();
			CadastraPage.clickOn_pais();
			CadastraPage.seleciona_pais();
			CadastraPage.sendUserCidade();
			CadastraPage.sendUserEndereco();
			CadastraPage.sendUserEstado();
			CadastraPage.sendUserCep();
			CadastraPage.aceitaTermos();
			CadastraPage.registaUser();

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");
		}
		Reporter.log("Um novo usuário foi cadastrado com sucesso |");

		Assert.assertTrue(HomePage.logadoNomeUser());

		Reporter.log("O nome de usuário obtido é igual ao enviado a aplicação |");
		Print.takeSnapShot("TesteCadastroValido", driver);
		Log.info("Um PrintScreen é obtido da tela atual");
		Reporter.log("O teste de cadastro válido foi concluído com sucesso |");
		Reporter.log(" A aplicação foi encerrada");
	}

	@Test(priority = 1)
	public void testeCadastroInvalido() throws Exception {
		try {
			HomePage.minhaConta();
			HomePage.novaConta();

			Reporter.log(" A página de criação de novo usuário foi acessada |");

			CadastraPage.sendUserName(2);
			CadastraPage.sendUserEmail();
			CadastraPage.sendUserSenha();
			CadastraPage.sendUserSenhaConfirmacao();
			CadastraPage.sendUserSPrimeiroNome();
			CadastraPage.sendUserUltimoNome();
			CadastraPage.sendUserTelefone();
			CadastraPage.clickOn_pais();
			CadastraPage.seleciona_pais();
			CadastraPage.sendUserCidade();
			CadastraPage.sendUserEndereco();
			CadastraPage.sendUserEstado();
			CadastraPage.sendUserCep();
			CadastraPage.aceitaTermos();
			CadastraPage.registaUser();

		} catch (Exception e) {
			Log.info("Ocorreu uma exceção");
			e.printStackTrace();
			Log.info("Foi impresso o caminho do erro");

		}

		Reporter.log("O usuário não foi cadastrado |");

		Assert.assertFalse(HomePage.logadoNomeUser());
		Log.info("Realiza a comparação entre as urls esperada e a obtida");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,150)", "");
		Log.info("Foi aplicado um comando de rolagem de tela, para melhoria do print obtido");

		Reporter.log("A mensagem de usuário já cadastrado foi obtida com sucesso");
		Print.takeSnapShot("TesteCadastroInvalido", driver);
		Log.info("Tira um PrintScreen para comprovar fim do teste");
		Reporter.log(" O teste foi finalizado ");

	}

	@AfterMethod
	public void encerra() {

		driver.quit();
		Log.info("O driver é encerrado");

	}
}
