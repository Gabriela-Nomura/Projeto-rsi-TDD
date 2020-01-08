package br.com.rsihub.testes;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsihub.constantes.constantes;
import br.com.rsihub.pageObject.Home_Page;
import br.com.rsihub.pageObject.cadastra_Page;

public class Test_HomePage {
	static WebDriver driver = new ChromeDriver();
	static Home_Page home = new Home_Page(driver);

	public static void main(String[] args) throws Exception {
		
		driver.get(constantes.URL);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		home.minhaConta().click();
		Thread.sleep(3000);
		WebElement PopUp =	driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
		PopUp.click();
		home.novaConta().click();
		
		cadastra_Page.nomeUsuario().sendKeys("dasda");
		cadastra_Page.emailUsuario().sendKeys("afadfasd");
		cadastra_Page.senhaUsuario().sendKeys("rqwerewrqew");
		cadastra_Page.confirmacaoSenhaUsuario().sendKeys("rqewrwer");
		cadastra_Page.primeiroNome().sendKeys("rqwerweq");
		cadastra_Page.ultimoNome().sendKeys("rqwerweq");
		cadastra_Page.telefoneUsuario().sendKeys("rewqrwerewq");
	}
}
