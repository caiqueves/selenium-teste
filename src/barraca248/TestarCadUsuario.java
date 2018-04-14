package barraca248;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Util.AbriNavegador;

public class TestarCadUsuario {
	AbriNavegador abrir = new AbriNavegador();

	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}

	@Test
	public void testandoCadastramentoCategoria() throws Exception {
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
			abrir.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[6]/div/a")).click();
			
			if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/usuarios.php")) 
			{
				abrir.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();

				if (abrir.RetornarUrl().equals("http://barraca248.rf.gd/admin/cadastrarusuario.php")) 
				{
					abrir.driver.findElement(By.id("cadastrarusuario")).click();
					
					String valor = abrir.driver.findElement(By.xpath("//*[@id=\"alerta-modal\"]/div/div/div")).getText();
					
					System.out.println(valor);
				    
				}
			}
		}
	}
}	
