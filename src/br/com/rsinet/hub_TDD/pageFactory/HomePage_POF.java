package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage_POF {

	@FindBy(how = How.ID, using = "menuUser")
	public static WebElement minhaConta;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	public static WebElement novaConta;

	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement busca;

	@FindBy(how = How.ID, using = "headphonesImg")
	public static WebElement HeadPhones;
}
