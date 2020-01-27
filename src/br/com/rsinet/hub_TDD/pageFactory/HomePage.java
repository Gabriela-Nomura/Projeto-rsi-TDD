package br.com.rsinet.hub_TDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.utils.constantes;

public class HomePage {
	/**
	 * Classe de manipulacao de webElements da pagina inicial da aplicacao
	 */
	static Logger Log = Logger.getLogger("Página inicial");
	final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.ID, using = "details_10")
	private WebElement produto;

	@FindBy(how = How.ID, using = "menuUser")
	private WebElement minhaConta;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement novaConta;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement busca;

	@FindBy(how = How.ID, using = "headphonesImg")
	private WebElement HeadPhones;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private WebElement userText;
	CadastraPage CadastraPage;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement buscaBox;
	@FindBy(how = How.ID, using = "16")
	private WebElement produtoSeleciona;
	
	public void minhaConta() {
		minhaConta.click();
		Log.info("O link minha conta recebu um clique");
	}

	public void novaConta() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Log.info("Foi aplicado um comando de espera para carregamento da página de 20 segundos");

		novaConta.sendKeys(Keys.ENTER);
		Log.info("O link nova conta recebeu um clique");
	}
	public void seleciona() {
		produtoSeleciona.click();
	}
	public boolean logadoNomeUser() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.textToBePresentInElement(userText, constantes.userName(3)));
		} catch (Exception e) {

			return userText.isDisplayed();
		}
		return userText.isDisplayed();
	}

	public void clickOn_HeadPhone() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(HeadPhones));
		HeadPhones.click();
		Log.info("A categoria de Headphones recebeu um clique");
	}

	public void clickOn_produtos() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(produto));
		produto.click();
		Log.info("O produto selecionado recebeu um clique");
	}

	public void clickOn_busca() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(busca));
		busca.click();
		Log.info("O ícone de busca recebeu um clique");
	}

	public void sendText_buscaFalha() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(buscaBox));
		buscaBox.sendKeys(constantes.buscaLupaFalha());
		Log.info("O ícone de busca recebeu um clique");
		buscaBox.sendKeys(Keys.ENTER);
		Thread.sleep(200);
	}

	public void sendText_busca() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(buscaBox));
		buscaBox.sendKeys(constantes.buscaLupa());
		Log.info("O ícone de busca recebeu um clique");
		buscaBox.sendKeys(Keys.ENTER);
	}
}
