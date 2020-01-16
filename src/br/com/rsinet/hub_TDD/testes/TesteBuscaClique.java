package br.com.rsinet.hub_TDD.testes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.pageFactory.BuscaClique_POF;
import br.com.rsinet.hub_TDD.utils.Configuracoes;
import br.com.rsinet.hub_TDD.utils.Print;

public class TesteBuscaClique extends Configuracoes {

	static Logger Log = Logger.getLogger("Teste de busca por clique Válido");

	@Test
	public void testaBuscaCliqueValido() throws Exception {
		WebDriver driver = Configuracoes.setDriver();

		Reporter.log(" A aplicação foi iniciada com sucesso |");

		BuscaClique_POF.configuracoes(driver);
		BuscaClique_POF.inicializa(driver);
		BuscaClique_POF.clickOn_HeadPhone(driver);
		BuscaClique_POF.checkOut_click(driver);
		
		
//		Log.info("O módulo de busca por clique foi executado com sucesso");
		Reporter.log(" O produto clicado foi correspondente ao aberto |");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"userCart\"]"));
		Log.info("Localiza o produto no carrinho");

		AssertJUnit.assertNotNull(elemento);
		Log.info("Verifica que o produto foi inserido no carrinho com sucesso");

		Reporter.log(" O produto selecionado foi inserido no carrinho com sucesso |");

		Print.takeSnapShot("TesteBuscaClique", driver);
		Log.info("Foi obtido um print da tela");
		Reporter.log("O teste foi concluído com sucesso .");

		driver.close();
		Log.info("Encerra o navegador");

	}
}
