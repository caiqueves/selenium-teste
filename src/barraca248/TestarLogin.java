package barraca248;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestarLogin {
    AbriNavegador abrir = new AbriNavegador();
    
	private boolean esperado = true;
    private boolean obtido ;
    
	@Before
	public void abrirNavegador() {
		abrir.AbrindoNavegador("http://barraca248.rf.gd/login.php");
	}
   @Test
   public void testandoLogin() 
   {
	 String url = "";  
	 WebElement login = abrir.driver.findElement(By.id("login")); 
	 login.sendKeys("admin");
	 
	 WebElement senha = abrir.driver.findElement(By.id("senha")); 
	 senha.sendKeys("12345");
	 
	 abrir.driver.findElement(By.xpath("//*[@id=\"formlogin\"]/div[4]/button[2]")).click();
	 abrir.driver.navigate().refresh();
	 url = abrir.driver.getCurrentUrl();
	 
	 if (url.equals("http://barraca248.rf.gd/admin/admin.php")) 
	 {
		 obtido = true; 
	 }
	 else
	 {
		 obtido = false;
	 }
	 
	 assertEquals("CT_TestarLogin",esperado,obtido);
   }
	 
   @After
   public void fecharPagina() throws InterruptedException
   {
   Thread.sleep(12000);	   
   abrir.driver.quit();
   }
}
