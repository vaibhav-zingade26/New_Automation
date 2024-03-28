import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UI_Testing {

    String toolsQa = "https://demo.automationtesting.in/Register.html";
    String google="https://www.google.co.in/";
    private final String searchBox = "#APjFqb";

    WebDriver driver ;
    @BeforeTest
    public void chromeOpen(){
        // driver = new ChromeDriver();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MICROSECONDS);
    }

    @Test(priority = 1)
    public void verifyheaders(){
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        String actualHeaders = driver.getTitle();
        String expectedHeaders = "DEMOQA";
        Assert.assertEquals(actualHeaders,expectedHeaders);
        driver.close();
    }
    @Test(priority = 2)
    public void verifyName(){
        driver = new ChromeDriver();
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        String actualName = driver.findElement(By.xpath("//*[@id=\"userName-wrapper\"]/div[1]")).getText();
        String expectedName = "Full Name";
        Assert.assertEquals(actualName,expectedName);
        driver.close();
    }
    @Test
    public void login() {
        //System.setProperty("wedriver.chrome.driver", "_1.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
        WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        // WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\'submit']"));
        uName.sendKeys("vaibhav");
        pswd.sendKeys("Vaibhav");
        // loginBtn.click();
        loginBtn.sendKeys(Keys.ENTER);
        String errorMsgOnScreen = driver.findElement(By.id("name")).getText();
        String expectedErrorOn_Screen ="Invalid username or password!";
        Assert.assertEquals(errorMsgOnScreen,expectedErrorOn_Screen);
        driver.close();
    }
    @Test
    public void automation(){
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Vaibhav");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Zingade");
        driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']")).sendKeys("Mukai Nagar");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vaibhav@gmail.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9021317200");
        driver.findElement(By.xpath("//input[@type='radio' and @value ='Male']")).click();
        driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
        driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
        driver.findElement(By.xpath("//input[@id='checkbox3']")).click();
        driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']")).click();
        driver.findElement(By.xpath("//a[@class='ui-corner-all' and text()='English']")).click();
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']")).click();
        Select skills = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
        skills.selectByValue("Programming");
        driver.findElement(By.xpath("//b[@role='presentation']")).click();
        driver.findElement(By.xpath("//*[@class='select2-results__option' and text()='India']")).click();
        Select year = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
        year.selectByValue("1997");
        Select month = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
        month.selectByValue("December");
        Select day = new Select(driver.findElement(By.xpath("//select[@placeholder='Day']")));
        day.selectByValue("26");
        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("VacZ@1234");
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("VacZ@1234");
        driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

    }
    @Test
    void yt(){
        driver.get("https://www.youtube.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("windowScrollBy(0,500)");
    }

    @Test
    public void google() throws InterruptedException {
        /*if(true)
            throw new SkipException("Skipping the test");*/
        driver.get(google);
        System.out.println(driver.manage().window().getSize());
        Dimension d=new Dimension(200,200);
        driver.manage().window().setSize(d);
        //Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(searchBox),true));
        driver.findElement(By.cssSelector(searchBox)).sendKeys("Think Analytics");
        driver.findElement(By.cssSelector(searchBox)).sendKeys(Keys.ENTER);
    }
    /*@DataProvider(name="users")
    String sendKeysData(){
        String val="thinkAnalytics";
        return val;
    }*/
    String switchTo="//a[text()='SwitchTo']";

    @Test
    public void hoverAndClick() throws InterruptedException {
        driver.get(toolsQa);
        Thread.sleep(1000);
        Actions swichTo = new Actions(driver);
        // swichTo.dragAndDrop(driver.findElement(By.xpath(switchTo)), driver.findElement(By.linkText("Windows"))).build().perform();
        /*swichTo.moveToElement(driver.findElement(By.xpath(switchTo))).build().perform();
                //moveToElement(driver.findElement(By.xpath("//a[text()='Alerts']")))
        driver.findElement(By.xpath("//a[text()='Alerts']")).click();
        driver.navigate().back();
        swichTo.moveToElement(driver.findElement(By.xpath(switchTo))).build().perform();
        driver.findElement(By.xpath("//a[text()='Windows']")).click();
        driver.navigate().back();*/
        swichTo.moveToElement(driver.findElement(By.xpath(switchTo))).build().perform();
        driver.findElement(By.xpath("//a[text()='Frames']")).click();
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Vaibhav");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
        driver.switchTo().frame("Nested iFrames");
        driver.switchTo().frame("iFrame Demo");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("vaibhav");
    }
    String g1="//b[contains(text(),'Group 1')]";
    String g2="//b[contains(text(),'Group 2')]";
    String g3="//b[contains(text(),'Group 3')]";
    String g4="//b[contains(text(),'Group 4')]";
    String Widget="//a[text()='Widgets']";

    @Test
    void containsTest() throws InterruptedException {
        driver.get(toolsQa);
        Actions Widgets = new Actions(driver);
        Widgets.moveToElement(driver.findElement(By.xpath(Widget))).build().perform();
        driver.findElement(By.xpath("//a[text()=' Accordion ']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath(g1)).click();
        driver.findElement(By.xpath(g2)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(g2)).click();
        driver.findElement(By.xpath(g3)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(g3)).click();
        driver.findElement(By.xpath(g4)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(g4)).click();
    }

    String addToBasket="//a[text()='Add to basket']";
    String items ="//a[@class='wpmenucart-contents']";
    String checkout="//a[@class='checkout-button button alt wc-forward']";
    public static void sendKeys(WebDriver driver,String css,String text){
        driver.findElement(By.cssSelector(css)).sendKeys(text);
    }
    @Test(invocationCount = 10)
    public void testDemo(){
        driver.get("https://practice.automationtesting.in/");
        List<WebElement> books=driver.findElements(By.xpath(addToBasket));
        for(WebElement b:books){
            b.click();
        }
        driver.get("https://practice.automationtesting.in/basket/");
        //driver.switchTo().window("Basket - Automation Practice Site");
        driver.findElement(By.xpath(checkout)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Billing Details
        sendKeys(driver,"#billing_first_name","Vaibhav");
        sendKeys(driver,"#billing_last_name","zingade");
        sendKeys(driver,"#billing_company","Info");
        sendKeys(driver,"#billing_phone","9023415678");
        sendKeys(driver,"#billing_email","zingade@gmail.com");
        /*driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).click();
        Actions country = new Actions(driver);
        country.moveToElement(driver.findElement(By.cssSelector("#select2-result-label-2596"))).build().perform();
*/      sendKeys(driver,"#billing_address_1","bhagat Singh Chowk");
        sendKeys(driver,"#billing_address_2","Shasti nagar");
        sendKeys(driver,"#billing_city","Solapur");
        //driver.findElement(By.cssSelector("#select2-chosen-2035")).click();
        sendKeys(driver,"#billing_postcode","411067");
        driver.findElement(By.xpath("//input[@id='payment_method_cod']")).click();
        driver.findElement(By.xpath("//input[@id='place_order']")).click();
        String successMsg=driver.findElement(By.xpath("//p[@class='woocommerce-thankyou-order-received']")).getText();
        Assert.assertEquals(successMsg,"Thank you. Your order has been received.");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

