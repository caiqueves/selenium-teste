package barraca248;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Util.*;

public class TestarLogin {
	AbriNavegador abrir = new AbriNavegador();
   
	
	private WebElement login,senha;
	
	@Before
	public void abrindoNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}

	@Test
	public void testandoLogin() {
		
		boolean obtido;
		
		login = abrir.driver.findElement(By.id("login"));
		login.sendKeys("admin");

		senha = abrir.driver.findElement(By.id("senha"));
		senha.sendKeys("12345");

		abrir.driver.findElement(By.xpath("//*[@id=\"formlogin\"]/div[4]/button[2]")).click();

		if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/admin.php")) {
			obtido = true;
		} else {
			obtido = false;
		}
		assertEquals(true, obtido);
	}

	@After
	public void fecharPagina() throws InterruptedException {
		Thread.sleep(12000);
		abrir.driver.quit();
	}
}
