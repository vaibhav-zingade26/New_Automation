import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class toolsQA {
    public static void main(String[] args) {
        System.setProperty("wedriver.chrome.driver","_1.exe" );
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
        WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id='submit']"));
        uName.sendKeys("vaibhav");
        pswd.sendKeys("Vaibhav");
        loginBtn.click();
    }
}
