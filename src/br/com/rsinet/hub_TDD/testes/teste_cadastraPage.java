package br.com.rsinet.hub_TDD.testes;

import java.util.*;
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

import br.com.rsinet.hub_TDD.pageObject.Cadastra_Page;
import br.com.rsinet.hub_TDD.pageObject.Home_Page;
import br.com.rsinet.hub_TDD.utils.*;

public class teste_cadastraPage {

	static WebDriver driver = new ChromeDriver();
	private static int iTestCaseRow = 1;
	

	

	public static void main(String[] args) throws Exception {

		Home_Page.minhaConta.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement PopUp = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
		PopUp.click();
		Home_Page.novaConta.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		
		
		
		//String nomeUsuario = ExcelUtils.getCellData(2, constantes.Col_userName);
		
//		
//		System.out.println(nomeUsuario);
//		Cadastra_Page.nomeUsuario.sendKeys(nomeUsuario);
//		Cadastra_Page.emailUsuario.sendKeys(ExcelUtils.getCellData(iTestCaseRow, constantes.Col_Email));
		
		
		Cadastra_Page.senhaUsuario.sendKeys(ExcelUtils.getCellData(iTestCaseRow, constantes.Col_Senha));
		Cadastra_Page.confirmacaoSenhaUsuario.sendKeys(ExcelUtils.getCellData(iTestCaseRow, constantes.Col_confirmacaoDeSenha));
		Cadastra_Page.primeiroNome.sendKeys(ExcelUtils.getCellData(iTestCaseRow, constantes.Col_primeiroNome));
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

//		 Utils.takeScreenshot(driver, sTestCaseName);
	
	
	}

}
