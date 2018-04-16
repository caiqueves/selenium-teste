package barraca248;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.*;

public class TestarCadPagClientFound {
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
			abrir.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[5]/div/a")).click();

			if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/pagamentos.php")) {
				abrir.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();

				if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/cadastrarpagamento.php")) {
					WebElement cliente = abrir.driver.findElement(By.id("cliente"));
					cliente.sendKeys("ana teste");

					WebDriverWait wait = new WebDriverWait(abrir.driver, 1);
					String text03 = (wait
							.until(ExpectedConditions
									.presenceOfElementLocated(By.cssSelector("#tabelacliente > tbody > tr > td.nome")))
							.getText());

					if (text03.equals("Ana Teste")) {
						obtido = true;
					} else {
						obtido = false;
					}
				}
			}
			assertEquals(true, obtido);
		}
	}
	
	@After
	public void fecharPagina() throws InterruptedException {
		Thread.sleep(12000);
		abrir.driver.quit();
	}

}