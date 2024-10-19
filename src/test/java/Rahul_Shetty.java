import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rahul_Shetty {
        @Test
    public void test01(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.id("inputUsername")).sendKeys("Vaibhav");
            driver.findElement(By.name("inputPassword")).sendKeys("Vaibhav123");
            driver.findElement(By.name("chkboxOne")).click();
            driver.findElement(By.name("chkboxTwo")).click();
            driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();
            //*[@class="error"]
            String error = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/p")).getText();
            Assert.assertEquals(error,"* Incorrect username or password");


    }

}
