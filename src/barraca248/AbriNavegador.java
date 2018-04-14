package barraca248;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbriNavegador {
   public WebDriver driver;
   
   public void AbrindoNavegador(String site ) {
	   System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(site);
		driver.manage().window().maximize();
   }
}
