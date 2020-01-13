package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeCadastro {
	
	static WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using = "hi-user containMiniTitle ng-binding")
	public static WebElement UserName;
}
