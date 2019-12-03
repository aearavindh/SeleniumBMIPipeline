import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void test() throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
       ChromeOptions opt = new ChromeOptions();
       opt.addArguments("--headless");
       opt.addArguments("window-size=1920x1080");
       WebDriver driver = new ChromeDriver(opt);
       driver.get("http://52.14.134.71:8080/BMI/");
       Thread.sleep(1000);
       driver.findElement(By.name("weight")).sendKeys("80.0"); 
       Thread.sleep(1000);
       driver.findElement(By.name("height")).sendKeys("2.0"); 
       Thread.sleep(1000);
       driver.findElement(By.cssSelector("input:nth-child(8)")).click();
       Thread.sleep(2000);
      String h= driver.getTitle();
      System.out.println(h);
      String e= "BMI Calculator";
      if(h.equalsIgnoreCase(e)){
      System.out.println("Success");
      }
      else{
      System.out.println("Failure");
      }       
      driver.close();
		
  }
}
