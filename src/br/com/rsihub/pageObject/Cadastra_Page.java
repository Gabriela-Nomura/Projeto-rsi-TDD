package br.com.rsihub.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cadastra_Page {
	
	static WebDriver driver;
	
	//Account Details
	 @FindBy(how = How.NAME, using = "usernameRegisterPage")
	 public static WebElement nomeUsuario;

	 @FindBy(how = How.NAME, using = "emailRegisterPage")
	 public static WebElement emailUsuario;
	 
	 @FindBy(how = How.NAME, using = "passwordRegisterPage")
	 public static WebElement senhaUsuario;

	 @FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	 public static WebElement confirmacaoSenhaUsuario;
	 
	//Personal Details
	 
	 @FindBy(how = How.NAME, using = "first_nameRegisterPage")
	 public static WebElement primeiroNome;
	
	 @FindBy(how = How.NAME, using = "last_nameRegisterPage")
	 public static WebElement ultimoNome;
	 
	 @FindBy(how = How.XPATH, using = "phone_numberRegisterPage")
	public static WebElement telefoneUsuario;
	
	//Addresss
	
	 @FindBy(how = How.XPATH, using = "//*[@id=\'formCover\']/div[3]/div[1]/sec-view[1]/div/select")
	 public static WebElement paisUsuario;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\'formCover\']/div[3]/div[1]/sec-view[2]/div/input")
	 public static WebElement cidadeUsuario;
	
	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[1]/div/input")
	 public static WebElement enderecoUsuario;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[2]/div/input")
	 public static WebElement estadoUsuario;
	
	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[3]/sec-view/div/input")
	 public static WebElement cepUsuario;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/sec-view/div/input")
	 public static WebElement aceitaTermos;
	 
	 @FindBy(how = How.ID, using = "register_btnundefined")
	 public static WebElement registraUsuario;
	 


}