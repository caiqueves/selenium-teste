package alterarSenha;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.AbriNavegador;


public class TestarAlteracaoSenha {
	AbriNavegador abrir = new AbriNavegador();
	
	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("file:///D:/Pessoal/P%C3%B3s%20-%20Gradua%C3%A7%C3%A3o%20(%20IFPE%20)/Teste%20de%20Software/Atividades%2005.2_Selenium/selenium-teste/Resource/PaginaAlterarSenha_Web/login.html");
	}
	
	@Test
	public void testandoAlteracaoSenhaSucesso() {
		boolean esperado01 = true;
		boolean obtido01 = false;

		WebElement login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("rafael.melo");

		WebElement senhaAtual = abrir.driver.findElement(By.id("senhaatual"));
		senhaAtual.sendKeys("12345");
		
		WebElement data = abrir.driver.findElement(By.id("datanascimento"));
		data.sendKeys("01101988");
		
		WebElement cpf = abrir.driver.findElement(By.id("cpf"));
		cpf.sendKeys("18773103012");
		
		WebElement senhanova = abrir.driver.findElement(By.id("senhanova"));
		senhanova.sendKeys("1234567");
		
		WebElement confirmasenha = abrir.driver.findElement(By.id("confirmasenha"));
		confirmasenha.sendKeys("1234567");
		
		WebElement lembrete = abrir.driver.findElement(By.id("lembrete"));
		lembrete.sendKeys("Cachorro");
		
		abrir.driver.findElement(By.id("button")).click();
		
		String text01 = abrir.driver.switchTo().alert().getText();	
		
		if (text01.equals("Alteração realizada com sucesso!")) {
			obtido01 = true;
		} else {
			obtido01 = false;
		}
		assertEquals(esperado01, obtido01);
	}
	
	@Test
	public void testandoLembreteVazio() {
		boolean esperado02 = true;
		boolean obtido02 = false;

		WebElement login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("rafael.melo");

		WebElement senhaAtual = abrir.driver.findElement(By.id("senhaatual"));
		senhaAtual.sendKeys("12345");
		
		WebElement data = abrir.driver.findElement(By.id("datanascimento"));
		data.sendKeys("01101988");
		
		WebElement cpf = abrir.driver.findElement(By.id("cpf"));
		cpf.sendKeys("18773103012");
		
		WebElement senhanova = abrir.driver.findElement(By.id("senhanova"));
		senhanova.sendKeys("1234567");
		
		WebElement confirmasenha = abrir.driver.findElement(By.id("confirmasenha"));
		confirmasenha.sendKeys("1234567");
		
		WebElement lembrete = abrir.driver.findElement(By.id("lembrete"));
		lembrete.sendKeys("");
		
		abrir.driver.findElement(By.id("button")).click();
		
		String text02 = abrir.driver.switchTo().alert().getText();	
		
		if (text02.equals("1 - Lembrete inválido")) {
			obtido02 = false;
		} else {
			obtido02 = true;
		}
		assertEquals(esperado02, obtido02);
	}
	
	@Test
	public void testandoCPFInvalido() {
		boolean esperado03 = true;
		boolean obtido03 = false;

		WebElement login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("rafael.melo");

		WebElement senhaAtual = abrir.driver.findElement(By.id("senhaatual"));
		senhaAtual.sendKeys("12345");
		
		WebElement data = abrir.driver.findElement(By.id("datanascimento"));
		data.sendKeys("01101988");
		
		WebElement cpf = abrir.driver.findElement(By.id("cpf"));
		cpf.sendKeys("18773103014");
		
		WebElement senhanova = abrir.driver.findElement(By.id("senhanova"));
		senhanova.sendKeys("1234567");
		
		WebElement confirmasenha = abrir.driver.findElement(By.id("confirmasenha"));
		confirmasenha.sendKeys("1234567");
		
		WebElement lembrete = abrir.driver.findElement(By.id("lembrete"));
		lembrete.sendKeys("");
		
		abrir.driver.findElement(By.id("button")).click();
		
	
		
		String text03 = abrir.driver.switchTo().alert().getText();	
		
		if (text03.equals("1 - Dígito verificador inválido")) {
			obtido03 = false;
		} else {
			obtido03 = true;
		}
		assertEquals(esperado03, obtido03);
	}
	
	@Test
	public void testandoSenhaDiferente() {
		boolean esperado04 = true;
		boolean obtido04 = false;

		WebElement login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("rafael.melo");

		WebElement senhaAtual = abrir.driver.findElement(By.id("senhaatual"));
		senhaAtual.sendKeys("12345");
		
		WebElement data = abrir.driver.findElement(By.id("datanascimento"));
		data.sendKeys("01101988");
		
		WebElement cpf = abrir.driver.findElement(By.id("cpf"));
		cpf.sendKeys("18773103014");
		
		WebElement senhanova = abrir.driver.findElement(By.id("senhanova"));
		senhanova.sendKeys("1234567");
		
		WebElement confirmasenha = abrir.driver.findElement(By.id("confirmasenha"));
		confirmasenha.sendKeys("1234567-diferente");
		
		WebElement lembrete = abrir.driver.findElement(By.id("lembrete"));
		lembrete.sendKeys("");
		
		abrir.driver.findElement(By.id("button")).click();
		
		String text04 = abrir.driver.switchTo().alert().getText();	
		
		if (text04.equals("1 - Confirmaçao da nova senha está diferente da nova senha.")) {
			obtido04 = false;
		} else {
			obtido04 = true;
		}
		assertEquals(esperado04, obtido04);
	}
	
	@Test
	public void testandoSenhaVazia() {
		boolean esperado05 = true;
		boolean obtido05 = false;

		WebElement login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("rafael.melo");

		WebElement senhaAtual = abrir.driver.findElement(By.id("senhaatual"));
		senhaAtual.sendKeys("12345");
		
		WebElement data = abrir.driver.findElement(By.id("datanascimento"));
		data.sendKeys("01101988");
		
		WebElement cpf = abrir.driver.findElement(By.id("cpf"));
		cpf.sendKeys("18773103014");
		
		WebElement senhanova = abrir.driver.findElement(By.id("senhanova"));
		senhanova.sendKeys("");
		
		WebElement confirmasenha = abrir.driver.findElement(By.id("confirmasenha"));
		confirmasenha.sendKeys("1234567-diferente");
		
		WebElement lembrete = abrir.driver.findElement(By.id("lembrete"));
		lembrete.sendKeys("");
		
		abrir.driver.findElement(By.id("button")).click();
		
		String text05 = abrir.driver.switchTo().alert().getText();	
		
		if (text05.equals("1 - Confirmaçao da nova senha está diferente da nova senha.")) {
			obtido05 = false;
		} else {
			obtido05 = true;
		}
		assertEquals(esperado05, obtido05);
	}
}
