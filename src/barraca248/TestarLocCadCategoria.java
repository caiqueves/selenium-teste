package barraca248;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.AbriNavegador;

public class TestarLocCadCategoria {
	AbriNavegador abrir = new AbriNavegador();

	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}

	@Test
	public void testandoCadastramentoCategoria() throws Exception {
		boolean obtido;
		WebElement login, senha;

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

		if (obtido) {
			abrir.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/a")).click();

			if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/categorias.php")) {
				abrir.driver.findElement(By.className("addnovo")).click();

				if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/cadastrarcategoria.php")) {
                    
					obtido = true;
				}
				else {
					obtido = false;
				}
	        }
		}
		assertEquals(true,obtido);
	}

	@After
	public void fecharPagina() throws InterruptedException {
		Thread.sleep(12000);
		abrir.driver.quit();
	}

}
