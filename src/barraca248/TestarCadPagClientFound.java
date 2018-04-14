package barraca248;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;

import Util.AbriNavegador;

public class TestarCadPagClientFound {
	AbriNavegador abrir = new AbriNavegador();

	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}

	@Test
	public void testandoCadastramentoCategoria() throws Exception {
		boolean obtido01 = false;
		boolean obtido02 = false;
		WebElement login, senha, valormensagem;

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

			if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/pagamentos.php")) 
			{
				abrir.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();

				if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/cadastrarpagamento.php")) 
				{
					WebElement cliente = abrir.driver.findElement(By.id("cliente"));
					cliente.sendKeys("ana teste");

					valormensagem = abrir.driver.findElement(By.className("nome"));

					if (valormensagem.getText().equals("Ana Teste")) 
					{
						obtido02 = true;
					} else {
						obtido02 = false;
					}
				}
			}
			assertEquals(true, obtido02);
		}
	}
}