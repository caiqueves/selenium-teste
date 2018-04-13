package barraca248;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestarLogin {
    
	private WebDriver driver;
    private boolean esperado = true;
    private boolean obtido ;
    
	@Before
	public void abrirNavegador() {

		System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://barraca248.rf.gd/admin/index.php");
		driver.manage().window().maximize();
		
		//AbrindoNavegador abrir = new AbrindoNavegador();
		//abrir.abrindoNavegador();

	}
   @Test
   public void testandoLogin() 
   {
	 String teste = "";  
	 WebElement login = driver.findElement(By.id("usuario")); 
	 login.sendKeys("admin");
	 
	 WebElement senha = driver.findElement(By.id("senha")); 
	 senha.sendKeys("12345");
	 
	 driver.findElement(By.xpath("//*[@id=\"formlogin\"]/div[5]/button")).click();
	 
	 teste = driver.getCurrentUrl();
	 
	 if (teste == "http://barraca248.rf.gd/admin/admin.php")
	 {
		 obtido = false; 
	 }
	 else
	 {
		 obtido = true;
	 }
	 
	 assertEquals("ct02",esperado,obtido);
   }
	 
   @After
   public void fecharPagina() throws InterruptedException
   {
   Thread.sleep(12000);	   
   driver.quit();
   }
}
