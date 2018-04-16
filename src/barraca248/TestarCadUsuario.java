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


public class TestarCadUsuario {
	AbriNavegador abrir = new AbriNavegador();

	
	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}

	@Test
	public void testandoCadastramentoCategoria() throws Exception {
		boolean obtido = false;
		boolean obtido01 = false;
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
			abrir.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[6]/div/a")).click();
			
			if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/usuarios.php")) 
			{
				abrir.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();

				if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/cadastrarusuario.php")) 
				{
					abrir.driver.findElement(By.id("cadastrarusuario")).click();
					
					WebDriverWait wait = new WebDriverWait(abrir.driver, 1);
				    String text03 = (wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#alerta-modal > div > div > div.modal-body"))).getText());
					
				    System.out.println(text03);
					if (text03.equals("- Nome é obrigatório /n - Usuário é obrigatório /n - Senha no mínimo 6 caracteres ")) {
						obtido = false;
					}
					else
					{
						obtido = true;
					}
				    
				}
			}
		}
		assertEquals(true, obtido);
	}
	
	@After
	public void fecharPagina() throws InterruptedException {
		Thread.sleep(12000);
		abrir.driver.quit();
	}
}	
