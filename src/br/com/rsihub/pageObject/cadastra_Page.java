package br.com.rsihub.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cadastra_Page extends BaseClass {
	
public cadastra_Page(WebDriver driver) {
		super(driver);
	}

	
	public static WebElement elemento = null;

	public static WebElement nomeUsuario() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[1]/div[1]/sec-view[1]/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;
	}

	public static WebElement emailUsuario() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[1]/div[1]/sec-view[2]/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;
	}

	public static WebElement senhaUsuario() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[1]/div[2]/sec-view[1]/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;
	}
	public static WebElement confirmacaoSenhaUsuario() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[1]/div[2]/sec-view[2]/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;
	}

	public static WebElement primeiroNome() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[2]/div[1]/sec-view[1]/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;
		
	}
	public static WebElement ultimoNome() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[2]/div[1]/sec-view[2]/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;}
	
	public static WebElement telefoneUsuario() throws Exception {
		try {
			elemento = driver.findElement(By.xpath("//*[@id=\'formCover\']/div[2]/div[2]/sec-view/div/input"));
		} catch (Exception e) {
			throw (e);
		}
		return elemento;}

}