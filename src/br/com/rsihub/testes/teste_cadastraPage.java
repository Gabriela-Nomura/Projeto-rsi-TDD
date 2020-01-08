package br.com.rsihub.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import br.com.rsihub.pageObject.Cadastra_Page;
import br.com.rsihub.pageObject.Home_Page;
import br.com.rsihub.utils.ExcelUtils;
import br.com.rsihub.utils.constantes;

public class teste_cadastraPage {
	
	static WebDriver driver = new ChromeDriver();
	@BeforeMethod

	public void beforeMethod() throws Exception {

		DOMConfigurator.configure("log4j.xml");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Planilha1");}
	
	public static void main(String[] args) throws Exception {
	
	

//	Test_HomePage.homePage();
	driver.get(constantes.URL);
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(30000);
	PageFactory.initElements(driver, Home_Page.class);
	PageFactory.initElements(driver, Cadastra_Page.class);
	Home_Page.minhaConta.click();
	Thread.sleep(3000);
	WebElement PopUp = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
	PopUp.click();
	Home_Page.novaConta.click();
	Thread.sleep(3000);
	Cadastra_Page.nomeUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_userName, 1));
	Cadastra_Page.emailUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_Email, 1));
	Cadastra_Page.senhaUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_Senha, 1));
	Cadastra_Page.confirmacaoSenhaUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_confirmacaoDeSenha, 1));
	Cadastra_Page.primeiroNome.sendKeys(ExcelUtils.getCellData(constantes.Col_primeiroNome, 1));
	Cadastra_Page.ultimoNome.sendKeys();
	Cadastra_Page.telefoneUsuario.sendKeys();
	Cadastra_Page.paisUsuario.click();
	Select paisBox = new Select(Cadastra_Page.paisUsuario);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	paisBox.selectByVisibleText("Brazil");
	Cadastra_Page.cidadeUsuario.sendKeys();
	Cadastra_Page.enderecoUsuario.sendKeys();
	Cadastra_Page.cepUsuario.sendKeys();
	Cadastra_Page.aceitaTermos.click();
	Cadastra_Page.registraUsuario.click();

	}
	
	

	
}
