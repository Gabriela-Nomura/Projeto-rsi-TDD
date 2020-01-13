package br.com.rsinet.hub_TDD.modulos;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_TDD.pageFactory.Cadastra_Page;
import br.com.rsinet.hub_TDD.pageFactory.HomePage_POF;
import br.com.rsinet.hub_TDD.utils.ExcelUtils;
import br.com.rsinet.hub_TDD.utils.constantes;

// Now this method does not need any arguments

public class ModuloCadastra {


	public static void executa(WebDriver driver) throws Exception {
		
		Logger Log = Logger.getLogger("br.com.rsinet.hub_TDD.ModuloCadastra");
		
//		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\gabriela.nomura\\driver");
//		Log.info("Realizada a configuração do driver");
				 
		 PageFactory.initElements(driver, Cadastra_Page.class);
			Log.info("A fabrica de objetos da página de cadastro foi instanciada");
//		 This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
		 
			
		String sNomeUsuario = ExcelUtils.getCellData(1, constantes.Col_userName);
		Log.info("O nome de usuário obtido do excel é "+ sNomeUsuario );
		Cadastra_Page.nomeUsuario.sendKeys( sNomeUsuario );
		Log.info("Insere o nome de usuario");
		
		String sEmail = ExcelUtils.getCellData(1, constantes.Col_Email);
		Log.info("O email de usuário obtido do excel é "+ sEmail );
		Cadastra_Page.emailUsuario.sendKeys(sEmail);
		Log.info("Insere o email do usuário");

		String sSenha = ExcelUtils.getCellData(1, constantes.Col_Senha);
		Log.info("A senha obtida do excel é "+ sSenha );
		Cadastra_Page.senhaUsuario.sendKeys(sSenha);
		Log.info("Insere a senha do usuário");
		
		String sSenhaConfirma = ExcelUtils.getCellData(1, constantes.Col_confirmacaoDeSenha);
		Log.info("A confirmação de senha obtida do excel é "+ sSenhaConfirma );
		Cadastra_Page.confirmacaoSenhaUsuario.sendKeys(sSenhaConfirma);
		Log.info("Insere a confirmação de  senha do usuário");
		
		String sPrimeiroNome = ExcelUtils.getCellData(1, constantes.Col_primeiroNome);
		Log.info("O primeiro nome do usuário obtida do excel é "+ sPrimeiroNome);
		Cadastra_Page.primeiroNome.sendKeys(sPrimeiroNome);
		Log.info("Insere o primeiro nome do usuário");
		
		String sUltimoNome = ExcelUtils.getCellData(1, constantes.Col_ultimoNome);
		Log.info("O ultimo nome do usuário obtida do excel é "+ sUltimoNome);
		Cadastra_Page.ultimoNome.sendKeys(sUltimoNome);
		Log.info("Insere o ultimo nome do usuário");
		
		String sTelefone = ExcelUtils.getCellData(1, constantes.Col_Telefone).toString();
		Log.info("O telefone do usuário obtida do excel é "+ sTelefone);
		Cadastra_Page.telefoneUsuario.sendKeys(sTelefone);
		Log.info("Insere o telefone do usuário");
		
		Cadastra_Page.paisUsuario.click();
		Log.info ("Seleciona a caixa de país");
		Select paisBox = new Select(Cadastra_Page.paisUsuario);
		Log.info ("Instancia um objeto select para manipulação do objeto");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("Foi aplicado no driver um comando de espera por 15 segundos");
		paisBox.selectByVisibleText("Brazil");
		
		String sCidade = ExcelUtils.getCellData(1, constantes.Col_cidade);
		Log.info("A cidade obtida do excel é "+ sCidade);
		Cadastra_Page.cidadeUsuario.sendKeys(sCidade);
		Log.info("Insere a cidade do usuário");
		

		String sEndereco = ExcelUtils.getCellData(1, constantes.Col_Endereco);
		Log.info("O endereço obtida do excel é "+ sEndereco);
		Cadastra_Page.enderecoUsuario.sendKeys(sEndereco);
		Log.info("Insere o endereço do usuário");
		
		String sEstado = ExcelUtils.getCellData(1, constantes.Col_Estado);
		Log.info("O estado obtido do excel é "+ sEstado);
		Cadastra_Page.estadoUsuario.sendKeys(sEstado);
		Log.info("Insere o estado do usuário");
		

		String sCEP = ExcelUtils.getCellData(1, constantes.Col_CEP).toString();
		Log.info("O endereço obtida do excel é "+ sCEP);
		Cadastra_Page.cepUsuario.sendKeys(sCEP);
		Log.info("Insere o CEP do usuário");
		
		Cadastra_Page.aceitaTermos.click();
		Cadastra_Page.registraUsuario.click();
		
	}
}
		
