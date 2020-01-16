package br.com.rsinet.hub_TDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.utils.Configuracoes;

public class BuscaClique_POF {

	static Logger Log = Logger.getLogger("BuscaClique_POF");

	@FindBy(how = How.ID, using = "headphonesImg")
	private static WebElement HeadPhones;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[1]/p[1]/a")
	private static WebElement produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"productProperties\"]/div[3]/button")
	private static WebElement carrinho;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private static WebElement checkout;
	
	
	public static void configuracoes(WebDriver driver) throws Exception{
		
		Configuracoes.setDriver();
	}
	
	public static void inicializa(WebDriver driver) {
		PageFactory.initElements(driver, BuscaClique_POF.class);
		Log.info("A fabrica de objetos da página inicial foi instanciada");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
	}

	public static void clickOn_HeadPhone(WebDriver driver) {
		HeadPhones.click();
		Log.info("A categoria de Headphones recebeu um clique");

		produto.click();
		Log.info("Clica no elemento: Beats Studio 2 Over-Ear Matte Black Headphones");
	}
	public static void checkOut_click(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		carrinho.click();
		Log.info("Adiciona o produto procurado ao carrinho");

		checkout.click();
		Log.info("A opção de checkout recebeu um clique");
	}
	
}