package br.com.rsinet.hub_TDD.utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Configuracoes {
	static Logger Log = Logger.getLogger("TestBuscaClique");

	public static WebDriver setDriver() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		Log.info("Configurado driver de execução");

		WebDriver driver = new ChromeDriver();
		DOMConfigurator.configure("log4j.xml");
		Log.info("Configurado arquivo de registros de logs");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		driver.manage().window().maximize();
		Log.info("A janela foi maximizada");

		ExcelUtils.setExcelFile(constantes.Path_TestData, "TesteBusca");
		Log.info("Configurado o arquivo do excel a ser lido");

		driver.get(constantes.URL);
		Log.info("O Website foi acessado");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");

		return driver;
	}


}