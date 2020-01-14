package br.com.rsinet.hub_TDD.modulos;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;

public class BuscaCliqueModulo {

	static Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.BuscaCliqueModulo");

	public static void executa(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		HomePage_POF.HeadPhones.click();
		Log.info("Clica na categoria Headphones");
		
		driver.findElement(By.linkText("Beats Studio 2 Over-Ear Matte Black Headphones")).click();
		Log.info("Clica no elemento: Beats Studio 2 Over-Ear Matte Black Headphones");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Aguarda 10s");
		
	}
}
