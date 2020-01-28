package br.com.rsinet.hub_TDD.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Factory {

	/**
	 * Classe de configuração do driver a executar os testes. Inicialização do
	 * navegador, definição da url, arquivo do excel e arquivo de registros de log.
	 */

	static Logger Log = Logger.getLogger("Fábrica de driver");

	public static WebDriver configDriver() throws Exception {
		WebDriver driver = null;
		if (driver == null) {

			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			Log.info("Configurado driver de execução");

			driver = new ChromeDriver();

			driver.manage().window().maximize();
			Log.info("A janela foi maximizada");

		}
		return driver;
	}

	public static void configExcel() throws Exception {
		ConfigExcel.setExcelFile(constantes.Path_TestData, "Teste");
		Log.info("Configurado o arquivo do excel a ser lido");
	}

	public static void encerra(WebDriver driver) {
		if (driver != null) {
			driver.close();
			Log.info("Driver encerrado ");
		}
	}
}
