package br.com.rsinet.hub_TDD.pageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBusca {
	/**
	 * Classe de manipulacao de webElements das paginas de buscas
	 */
	static Logger Log = Logger.getLogger("Fabrica de objetos - Página de busca");
	final WebDriver driver;

	public PaginaBusca(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[1]/p[1]/a")
	private WebElement produto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"productProperties\"]/div[3]/button")
	private WebElement carrinho;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement checkout;

	private void waitUntil(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickOn_Produto() {

		waitUntil(produto);
		Log.info("Driver recebeu um comando de espera para aguardar que o elemento se torne visível");

		produto.click();
		Log.info("Clica no elemento: Beats Studio 2 Over-Ear Matte Black Headphones");
	}

	public void addOn_carrinho() {

		waitUntil(carrinho);
		Log.info("Driver recebeu um comando de espera para aguardar que o elemento se torne visível");

		carrinho.click();
		Log.info("Adiciona o produto procurado ao carrinho");
	}

	public void clickOn_checkOut() {
		waitUntil(checkout);
		checkout.click();
		Log.info("A opção de checkout recebeu um clique");
	}
}
