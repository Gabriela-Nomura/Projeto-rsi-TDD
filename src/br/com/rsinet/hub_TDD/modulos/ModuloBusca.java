package br.com.rsinet.hub_TDD.modulos;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.pageFactory.CadastraPage_POF;
import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.screenShots.Print;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

public class ModuloBusca {

	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.TestBuscaLupa");
	WebDriver driver;

	public static void executa(int nLinha, WebDriver driver) throws Exception {
		
		PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		HomePage_POF.busca.click();
		Log.info("O primeiro clique foi dado");
		
		WebElement buscaBox = driver.findElement(By.id("autoComplete"));
		
		String sbuscaNome = ExcelUtils.getCellData(nLinha, constantes.Col_NomeBusca);
		Log.info("O nome de pesquisa obtido do excel é " + sbuscaNome);
		
		buscaBox.sendKeys(sbuscaNome + Keys.ENTER);
		Log.info("Insere parametros na busca");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");


	}
}