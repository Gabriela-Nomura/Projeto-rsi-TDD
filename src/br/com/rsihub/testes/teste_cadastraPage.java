package br.com.rsihub.testes;

import br.com.rsihub.pageObject.cadastra_Page;

public class teste_cadastraPage {

	cadastra_Page cadastro = new cadastra_Page(driver) {
	};
	
	
	public static void main(String[] args) throws Exception {
		
	
	//Adiciona o nome de usuario
	cadastra_Page.nomeUsuario().sendKeys("dasda");
	cadastra_Page.emailUsuario().sendKeys("afadfasd");
	cadastra_Page.senhaUsuario().sendKeys("rqwerewrqew");
	cadastra_Page.confirmacaoSenhaUsuario().sendKeys("rqewrwer");
	cadastra_Page.primeiroNome().sendKeys("rqwerweq");
	cadastra_Page.ultimoNome().sendKeys("rqwerweq");
	cadastra_Page.telefoneUsuario().sendKeys("rewqrwerewq");
	
	
}}
