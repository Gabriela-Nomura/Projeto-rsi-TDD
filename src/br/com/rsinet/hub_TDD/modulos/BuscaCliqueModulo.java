package br.com.rsinet.hub_TDD.modulos;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;

public class BuscaCliqueModulo {

	static Logger Log = Logger.getLogger("BuscaCliqueModulo");

	public static void executa(WebDriver driver) throws Exception {
		
		PageFactory.initElements(driver, HomePage_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		HomePage_POF.HeadPhones.click();
		Log.info("A categoria de Headphones recebeu um clique");
		
		driver.findElement(By.linkText("Beats Studio 2 Over-Ear Matte Black Headphones")).click();
		Log.info("Clica no elemento: Beats Studio 2 Over-Ear Matte Black Headphones");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();
		Log.info("Adiciona o produto procurado ao carrinho");

		driver.findElement(By.id("checkOutPopUp")).click();
		Log.info("A opção de checkout recebeu um clique");
	}
}
