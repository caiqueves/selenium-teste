package Util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbriNavegador {
   public WebDriver driver;
   public String url;
   
   public void AbrindoNavegador(String site ) {
	   System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(site);
		driver.manage().window().maximize();
   }
   
   public String RetornarUrl() {
		driver.navigate().refresh();
		url = driver.getCurrentUrl();
		return url;
	}
 
}
