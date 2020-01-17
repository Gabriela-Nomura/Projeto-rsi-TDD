package br.com.rsinet.hub_TDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.utils.Print;
import br.com.rsinet.hub_TDD.utils.constantes;

public class HomePage_POF {

	static Logger Log = Logger.getLogger("Fabrica de objetos - Página inicial");
	final WebDriver driver;

	public HomePage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "details_10")
	private WebElement produto;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[6]/a")
	private WebElement popularProdutos;

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
	CadastraPage_POF CadastraPage;
	
	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement buscaBox;

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

	public boolean logadoNomeUser() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.textToBePresentInElement(userText, constantes.userName(1)));
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

	public void clickOn_PopularProdutos() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(popularProdutos));
		popularProdutos.sendKeys(Keys.ENTER);

		 driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
//		 

	}

	public void takePrint() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		Print.takeSnapShot("TesteBuscaCliqueInvalido-MostraProduto", driver);
		Log.info("Foi obtido um print da tela");
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
	
	public void sendText_busca() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(buscaBox));
		buscaBox.sendKeys(constantes.buscaLupa());
		Log.info("O ícone de busca recebeu um clique");
}
	
}

