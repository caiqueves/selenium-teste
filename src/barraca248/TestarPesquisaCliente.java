package barraca248;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.AbriNavegador;


public class TestarPesquisaCliente {
	
	AbriNavegador abrir = new AbriNavegador();

	
	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}
	
	@Test
	public void testandoPesquisaCliente() {

		boolean obtido01 = false;
		boolean obtido02 = false;
		
		WebElement login, senha;

		login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("admin");

		senha = abrir.driver.findElement(By.id("senha"));
		senha.sendKeys("12345");

		abrir.driver.findElement(By.xpath("//*[@id=\"formlogin\"]/div[4]/button[2]")).click();

		if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/admin.php")) {
			obtido01 = true;
		} else {
			obtido01 = false;
		}
		
		if (obtido01) {
			
			abrir.driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/a")).click();
			
			WebElement campoPesquisa = abrir.driver.findElement(By.id("pesqcliente"));
			campoPesquisa.sendKeys("caique");
			
			WebDriverWait wait = new WebDriverWait(abrir.driver, 1);
			String text03 = (wait
					.until(ExpectedConditions
							.presenceOfElementLocated(By.cssSelector("#tabelapesqcliente > div")))
					.getText());
			
			if (text03.equals("Nenhum cliente encontrado!")) {
				obtido02 = false;
			}
			else
			{
				obtido02 = true;
			}
		    
		}
		assertEquals(true, obtido02);
	}
	
	@After
	public void fecharPagina() throws InterruptedException {
		Thread.sleep(12000);
		abrir.driver.quit();
	}
		
		
		
		
		
		
		
		
	
}
